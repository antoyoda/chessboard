public class Piece {
    private boolean isWhite;

    public Piece() {
        this.isWhite = true;
    }

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() { return isWhite; }
    // public moveTo() {}

    public String toString() {return "X";}

    public boolean isLegalMove() {
      return false;
    }
}

class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    public String toString() {return "P";}

    public boolean isLegalMove(int startX, int startY,  int endX, int endY) {
      if (isWhite()) {
        if (startY == 7) {
          if (!(endY == 6 || endY = 5) && (endX == startX-1 || endX == startX || endX == startX+1)) {
            return false;
          }
        }
      }
    }
    // public void convertToQueen();
    // add more later
}

class Rook extends Piece {
    public boolean hasMoved;

    public Rook(boolean isWhite, boolean hasMoved) {
        super(isWhite);
        this.hasMoved = hasMoved;
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
}
class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }
    public String toString() {return "B";}
}
class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }
    public String toString() {return "Q";}
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
