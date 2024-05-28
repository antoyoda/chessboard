public class Piece {
    private int row;
    private int col;
    private boolean isWhite;
    public Piece() {
        this.row = 0;
        this.col = 0;
        this.isWhite = true;
    }
    public Piece(int row, int col, boolean isWhite) {
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isWhite() { return isWhite; }

    // public moveTo() {}


}

class Pawn extends Piece {
    private boolean hasMoved;

    public Pawn(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
        hasMoved = false;
    }

    public boolean hasMoved() { return hasMoved; }

    // public void convertToQueen();
    // add more later
}

class Rook extends Piece {
    public boolean hasMoved;

    public Rook(int row, int col, boolean isWhite, boolean hasMoved) {
        super(row, col, isWhite);
        this.hasMoved = hasMoved;
    }

    public boolean hasMoved() { return hasMoved; }
}
class Knight extends Piece {
    // can jump pieces
    public Knight(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }
}
class Bishop extends Piece {
    public Bishop(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }
}
class Queen extends Piece {
    public Queen(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }
}
class King extends Piece {
    private boolean hasMoved;

    // public boolean canCastleKingside() {}
    // public boolean canCastleQueenside() {}

    public King(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
    }
}
