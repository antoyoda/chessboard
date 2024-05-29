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
        board[0][4] = new King(false);
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

    public String toString() {
      String output = "";
      for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
          if (j == 0) {
            output += (8-i + " ");
          }
          if (board[i][j] != null) {
            output += board[i][j].toString();
            output += " ";
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
    // no numbers
    // public String toString() {
    //   String output = "";
    //   for (int i = 0; i < length; i++) {
    //     for (int j = 0; j < length; j++) {
    //       if (board[i][j] != null) {
    //         output += board[i][j].toString();
    //         output += " ";
    //       }
    //       else {
    //         output += "  ";
    //       }
    //     }
    //     if (i < 7) {
    //       output += "\n";
    //     }
    //   }
    //   return output;
    // }
}