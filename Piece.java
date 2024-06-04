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
        // add en passant later
        Piece a = board.getPiece(endX, endY);
        if (isWhite()) {
            // move up one
            if ((endY == startY-1) && (endX == startX)) {
                if (a == null) { return true; }
            }
            // move up two
            Piece b = board.getPiece(endX, endY-1);
            if ((startX == 6) && (endY == startY-2) && (endX == startX)) {
                if (a == null && b == null) { return true; }
            }
            // need to check captures
        }
        // black Piece
        else {
            // move down one
            if ((endY == startY+1)  && (endX == startX)) {
                if (a == null) {return true;}
            }
            // move down two
            Piece b = board.getPiece(endX, endY+1);
            if ((startX == 1) && (endY == startY+2) && (endX == startX)) {
                if (a == null && b == null) { return true; }
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

    @Override
    public boolean isLegalMove(Board board, int startX, int startY, int endX, int endY) {
        if (endX == startX){
            if (endY>startY){
                for(int i = endY; i>startY; i--){
                    if(!(board.getPiece(startX, i) == null)){ return false; }
                }
            }
            else {
                for(int i = startY; i>=endY; i--){
                    if(!(board.getPiece(startX, i) == null)){ return false; }
                }
            }
        }
        else if (endY == startY){
            if (endX>startX){
                for(int i = endX; i>startX; i--){
                    if(!(board.getPiece(i,startY) == null)){
                        return false;
                    }
                }
            }
            else {
                for(int i = startX; i<=endX; i--) {
                    if (!(board.getPiece(i, startY) == null)) {
                        return false;
                    }
                }
            }
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
