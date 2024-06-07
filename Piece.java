import java.lang.Math;

public class Piece {
    private boolean isWhite;

    public Piece() {
        this.isWhite = true;
    }

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() { return isWhite; }

    public String toString() {return "X";}

    public boolean isLegalMove(Board board, int startX, int startY,  int endX, int endY) {
      return false;
    }
}

class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    public String toString() {return "P";}

    public boolean isLegalMove(Board board, int startX, int startY,  int endX, int endY) {
        // add en passant later -- has moved that expires after one move
        if (isWhite()) {
            if (endY > startY) { // if same row/backwards
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
              if ((endY - startY) > 1) { // if moves more than 1
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
          if (endY < startY) { // if same row/backwards
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
            if ((startY - endY) > 1) { // if moves more than 1
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

    public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {
        if (board.getPiece(endX, endY) != null) {
            if (board.getPiece(endX, endY).isWhite() == isWhite()) {
                return false;
            }
        }
        if (endX == startX) {
            if (endY > startY) {
                for(int i = endY-1; i > startY; i--) {
                    if(!(board.getPiece(startX, i) == null)) {
                      return false;
                    }
                }
            }
            else if (endY < startY) {
                for(int i = startY-1; i > endY; i--) {
                    if(!(board.getPiece(startX, i) == null)) {
                        return false;
                    }
                }
            }
        }
        else if (endY == startY) {
            if (endX > startX) {
                for (int i = endX-1; i > startX; i--) {
                    if (!(board.getPiece(i,startY) == null)) {
                        return false;
                    }
                }
            }
            else if (endX < startX) {
                for(int i = startX+1; i < endX; i--) {
                    if (!(board.getPiece(i, startY) == null)) {
                        return false;
                    }
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

    public boolean hasMoved() { return hasMoved; }
    public String toString() {return "R";}
}
class Knight extends Piece {
    // can jump pieces
    public Knight(boolean isWhite) {
        super(isWhite);
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
    public String toString() {return "B";}

    public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {
      // check if same color
      Piece end = board.getPiece(endX, endY);
      if (end != null) {
        if (isWhite() == end.isWhite()) {
          return false;
        }
      }

      if ((startY - endY) / (startX - endX) == 1) {
          if (endX > startX){
              for (int i = startX + 1, j = startY + 1; i < endX && j < endY; i++, j++) {
                  if (board.getPiece(i, j) != null){
                      return false;
                  }
              }
          }
          else {
              for (int i = startX - 1, j = startY - 1; i > endX && j > endY; i--, j--) {
                  if (board.getPiece(i, j) != null) {
                      return false;
                  }
              }
          }
      }
      else if ((startY - endY) / (startX - endX) == -1) {
          if (endX > startX){
              for (int i = startX + 1, j = startY - 1; i < endX && j > endY; i++, j--) {
                  if (board.getPiece(i, j) != null) {
                      return false;
                  }
              }
          }
          else {
              for (int i = startX - 1, j = startY + 1; i > endX && j < endY; i++, j--) {
                  if (board.getPiece(i, j) != null) {
                      return false;
                  }
              }
          }
      }
      else {
          return false;
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
    public String toString() {return "Q";}

    public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {
      return rookDelegate.isLegalMove(board, startX, startY, endX, endY) || bishopDelegate.isLegalMove(board, startX, startY, endX, endY);
    }
}
class King extends Piece {
    private boolean hasMoved;

    // public boolean canCastleKingside() {}
    // public boolean canCastleQueenside() {}

    public King(boolean isWhite) {
        super(isWhite);
    }
    public String toString() {return "K";}
}
