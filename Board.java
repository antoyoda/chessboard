public class Board {
    private final Piece[][] board = new Piece[8][8];
    private int length = 8;
    // black pieces
    // 4 lines of space
    // white pieces
    public Board() {
        // black pawns
        for (int i = 0; i < length; i++) {
            board[1][i] = new Pawn(false);
        }
        // white pawns
        for (int i = 0; i < length; i++) {
            board[6][i] = new Pawn(true);
        }
        // black pieces
        board[0][0] = new Rook(false, false); // second false is Boolean hasMoved
        board[0][7] = new Rook(false, false);
        board[0][1] = new Knight(false);
        board[0][6] = new Knight(false);
        board[0][2] = new Bishop(false);
        board[0][5] = new Bishop(false);
        board[0][3] = new Queen(false);
        board[0][4] = new King(false); // king doesn't have hasMoved in constructor because it cannot be promoted
        // white pieces
        board[7][0] = new Rook(true, false);
        board[7][7] = new Rook(true, false);
        board[7][1] = new Knight(true);
        board[7][6] = new Knight(true);
        board[7][2] = new Bishop(true);
        board[7][5] = new Bishop(true);
        board[7][3] = new Queen(true);
        board[7][4] = new King(true);
    }

    public Board(Board other) {
      Piece[][] board1 = other.getBoard();
      for (int row = 0; row < length; row++) {
        for (int col = 0; col < length; col++) {
          Piece p = board1[row][col];
          if (p != null) {
                if (p instanceof Pawn) {
                    this.board[row][col] = new Pawn((Pawn) p);
                } else if (p instanceof Rook) {
                    this.board[row][col] = new Rook((Rook) p);
                } else if (p instanceof Knight) {
                    this.board[row][col] = new Knight((Knight) p);
                } else if (p instanceof Bishop) {
                    this.board[row][col] = new Bishop((Bishop) p);
                } else if (p instanceof Queen) {
                    this.board[row][col] = new Queen((Queen) p);
                } else if (p instanceof King) {
                    this.board[row][col] = new King((King) p);
                } else {
                    throw new IllegalArgumentException("Unknown piece type");
                }
            }
        }
      }
    }

    public Piece[][] getBoard() { return board; }

    public Piece getPiece(int xPos, int yPos) {
      return board[yPos][xPos];
    }

    // public Class<?> getPieceClass(int xPos, int yPos) {
    //     if (board[yPos][xPos] == null) {
    //         return null;
    //     }
    //     return board[yPos][xPos].getClass();
    // }

    public void movePiece(int startX, int startY, int endX, int endY) {
      if (board[startY][startX] == null) {
        System.out.print("No piece there.");
        return;
      }
      board[endY][endX] = board[startY][startX];
      board[startY][startX] = null;
      board[endY][endX].moved();
    }

    public boolean isSquareInCheck(int xPos, int yPos, boolean whiteSquare) {
      for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
          Piece p = board[row][col]; // loop through each piece
          if (p != null) { // if not null
            if (whiteSquare != p.isWhite()) { // AND different color
              // WON'T WORK
              if (p instanceof King) {
                System.out.println("FOUND");
              }
              if (p.getClass() != King.class) { // AND not king
                if (p.isLegalMove(this, col, row, xPos, yPos)) { // AND can attack that square
                  return true;
                }
              }
            }
          }
        }
      }
      return false;
    }
    public int findCheckingPieces (int xPosKing, int yPosKing, boolean isKingWhite){
        int count = 0;
        for (int yPos = 0; yPos < 8; yPos++) {
            for (int xPos = 0; xPos < 8; xPos++) {
                Piece a = board[yPos][xPos];
                if (a != null){
                    if(a.isLegalMove(xPos, yPos, xPosKing, yPosKing) && a.isWhite() != isKingWhite)
                        count++;
                }
            }
        }
        return count;
    }
    public int[] findKing(boolean isWhite){
        int[] result = new int[2];
        for (int yPos = 0; yPos < 8; yPos++) {
            for (int xPos = 0; xPos < 8; xPos++) {
                Piece k = board[yPos][xPos];
                    if (k != null) {
                        if (k.getClass() == King.class && k.isWhite == isWhite) {
                            result[0] = yPos;
                            result[1] = xPos;
                            return result;
                        }
                    }
                }
            }
        }


    // public ArrayList<int[]> findPosCheckingPieces(int xPos, int yPos, boolean whiteSquare) {
    //   ArrayList<int[]> output = new ArrayList<int[]>();
    //   for (int row = 0)
    //   return output;
    // }

    public String toString() {
      String output = "";
      for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
          if (j == 0) {
            output += (8-i + " ");
          }
          if (board[i][j] != null) {
            if (board[i][j].isWhite()) {
              // 34 is blue, 31 is red, 0 is default
              output += "\u001B[34m" + board[i][j].toString() + "\u001B[0m";
              output += " ";
            }
            else {
              output += "\u001B[31m" + board[i][j].toString() + "\u001B[0m";
              output += " ";
            }
          }
          else {
            output += "  ";
          }
        }
          output += "\n";
      }
      output += "  a b c d e f g h";
      return output;
    }
}
