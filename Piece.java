import java.lang.Math;

public class Piece {
    private boolean isWhite;

    public Piece() {
        this.isWhite = true;
    }

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public Piece(Piece piece) {
      isWhite = piece.isWhite();
    }

    public boolean isWhite() { return isWhite; }

    public String toString() {return "X";}

    public boolean isLegalMove(Board board, int startX, int startY,  int endX, int endY) {
      return false;
    }

    public void moved() {
      return;
    }

    public boolean hasMoved() { return false; }
}

class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    public Pawn(Pawn piece) {
      super(piece);
    }

    public String toString() {return "P";}

    // d2 to d2
    public boolean isLegalMove(Board board, int startX, int startY,  int endX, int endY) {
        // add en passant later -- has moved that expires after one move
        if (isWhite()) {
            if (endY >= startY) { // if same row/backwards
              return false;
            }
            if (Math.abs(endX - startX) > 1) { // if moving to the side by two or more
              return false;
            }
            if (startX == endX) { // if same column
              if (startY != 6 && startY - endY > 1) { // if not row 2 and moves more than 1
                return false;
              }
              Piece up1 = board.getPiece(startX, startY - 1);
              if (startY == 6) { // if row 2
                if (startY - endY > 2) { // AND moves more than 2
                  return false;
                }
                else if (endX - startX == 2) { // AND only moving 2
                  // check piece up and piece up + 1
                  Piece up2 = board.getPiece(startX, startY - 2);
                  if (up1 == null && up2 == null) {
                    return true; // if nothing there = return true
                  }
                  else {
                    return false;
                  }
                }
              }
              if (up1 == null) { // check piece infront
                return true; // nothing there = return true
              }
              else {
                return false;
              }
            }
            if (Math.abs(endX - startX) == 1) { // if col to the right or left
              if (Math.abs(endY - startY) > 1) { // if moves more than 1
                return false;
              }
              Piece diagonal = board.getPiece(endX, endY);
              // check piece diagonal
              if (diagonal == null) { // if not there
                return false;
              }
              if (diagonal.isWhite()) { // if same color
                return false;
              }
              return true;
            }
        }
        else {
          if (endY <= startY) { // if same row/backwards
            return false;
          }
          if (Math.abs(endX - startX) > 1) { // if moving to the side by two or more
            return false;
          }
          if (startX == endX) { // if same column
            if (startY != 1 && endY - startY > 1) { // if not row 2 and moves more than 1
              return false;
            }
            Piece up1 = board.getPiece(startX, startY + 1);
            if (startY == 1) { // if row 2
              if (endY - startY > 2) { // AND moves more than 2
                return false;
              }
              else if (endX - startX == 2) { // AND only moving 2
                // check piece up and piece up + 1
                Piece up2 = board.getPiece(startX, startY + 2);
                if (up1 == null && up2 == null) {
                  return true; // if nothing there = return true
                }
                else {
                  return false;
                }
              }
            }
            if (up1 == null) { // check piece infront
              return true; // nothing there = return true
            }
            else {
              return false;
            }
          }
          if (Math.abs(endX - startX) == 1) { // if col to the right or left
            if (Math.abs(startY - endY) > 1) { // if moves more than 1
              return false;
            }
            Piece diagonal = board.getPiece(endX, endY);
            // check piece diagonal
            if (diagonal == null) { // if not there
              return false;
            }
            if (!diagonal.isWhite()) { // if same color
              return false;
            }
            return true;
          }
        }
        return false;
    }
}

class Rook extends Piece {
    public boolean hasMoved;

    public Rook(boolean isWhite, boolean hasMoved) {
        super(isWhite);
        this.hasMoved = hasMoved;
    }

    public Rook(Rook piece) {
      super(piece);
      hasMoved = piece.hasMoved();
    }

    // 7, 0, ends, 1, 0
    // public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {
    //     if (board.getPiece(endX, endY) != null) {
    //         if (board.getPiece(endX, endY).isWhite() == isWhite()) {
    //             return false;
    //         }
    //     }
    //     if (endX == startX) {
    //         if (endY == startY) {
    //           return false;
    //         }
    //         int step = ()
    //     }
    //     else if (endY == startY) {
    //
    //     }
    //     else {
    //         return false;
    //     }
    //     return true;
    // }

    public void moved() {
      hasMoved = true;
    }

    public boolean hasMoved() { return hasMoved; }
    public String toString() {return "R";}
}
class Knight extends Piece {
    // can jump pieces
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    public Knight(Knight piece) {
      super(piece);
    }

    public String toString() {return "N";}

    public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {
      // check if same color
      Piece end = board.getPiece(endX, endY);
      if (end != null) {
        if (isWhite() == end.isWhite()) {
          return false;
        }
      }
      if (Math.abs(startX-endX) == 2) {
        if (Math.abs(startY-endY) == 1) {
          return true;
        }
      }
      else if (Math.abs(startY-endY) == 2) {
        if (Math.abs(startX-endX) == 1) {
          return true;
        }
      }
      return false;
    }
  }

class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    public Bishop(Bishop piece) {
      super(piece);
    }

    public String toString() {return "B";}

    public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {
      Piece end = board.getPiece(endX, endY);
      if (end != null) {
        if (isWhite() == end.isWhite()) {
          return false;
        }
      }

      // Check if the move is diagonal
      if (Math.abs(startX - endX) != Math.abs(startY - endY)) {
        return false;
      }

      int xDirection = endX > startX ? 1 : -1;
      int yDirection = endY > startY ? 1 : -1;

      int x = startX + xDirection;
      int y = startY + yDirection;

      while (x != endX && y != endY) {
        if (board.getPiece(x, y) != null) {
            return false;
        }
        x += xDirection;
        y += yDirection;
      }
      return true;
    }
}
class Queen extends Piece {
    private Piece rookDelegate;
    private Piece bishopDelegate;

    public Queen(boolean isWhite) {
        super(isWhite);
        rookDelegate = new Rook(isWhite(), true);
        bishopDelegate = new Bishop(isWhite());
    }

    public Queen(Queen piece) {
      super(piece);
      rookDelegate = new Rook(isWhite(), true);
      bishopDelegate = new Bishop(isWhite());
    }

    public String toString() {return "Q";}

    public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {
      return rookDelegate.isLegalMove(board, startX, startY, endX, endY) || bishopDelegate.isLegalMove(board, startX, startY, endX, endY);
    }
}
class King extends Piece {
    private boolean hasMoved;

    public King(boolean isWhite) {
        super(isWhite);
    }

    public King(King piece) {
      super(piece);
      hasMoved = piece.hasMoved();
    }

    // public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {}
    // public boolean canCastleKingside() {}
    // public boolean canCastleQueenside() {}

    public void moved() {
      hasMoved = true;
    }

    public boolean hasMoved() { return hasMoved; }
    public String toString() {return "K";}
}
