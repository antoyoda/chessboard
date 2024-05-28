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
}

class Pawn extends Piece {
    private boolean hasMoved;

    public Pawn(boolean isWhite) {
        super(isWhite);
        hasMoved = false;
    }

    public boolean hasMoved() { return hasMoved; }

    public String toString() {return "P";}
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
