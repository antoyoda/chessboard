import java.util.Scanner;

public class Game {
  private Board board = new Board();
  private Player white;
  private Player black;
  private Player activePlayer;

  public Game() {
    // nothing needed, could maybe switch start to static
  }

  // initializes player names
  private void getPlayerNames() {
    Scanner in = new Scanner(System.in);
    System.out.print("Welcome, Player 1. You are playing with the white pieces. ");
    String name1 = "";
    // check to make sure name isn't empty
    while (name1.trim().isEmpty()) {
      System.out.println("What is your name?");
      name1 = in.nextLine().trim();
      if (name1.isEmpty()) {
        System.out.println("Your name can't be empty, try again.");
      }
    }

    System.out.print("Welcome, Player 2. You are playing with the black pieces. ");
    String name2 = "";
    while (name2.trim().isEmpty()) {
      System.out.println("What is your name?");
      name2 = in.nextLine().trim();
      if (name2.isEmpty()) {
        System.out.println("Your name can't be empty, try again.");
      }
    }

    white = new Player(name1, true);
    black = new Player(name2, false);

    in.close();
  }

  public void start() {
    getPlayerNames();
    activePlayer = white;

    System.out.println("Game started between " + white.getName() + " and "+ black.getName());

   /* while (!isGameOver()) {
      System.out.println(board);
      //getMove();
      switchTurn();
    }
*/
    System.out.println("The game is over!");
  }

  private boolean isGameOver() {
    // logic to check checkmate, stalemate, draw by repetition?, 50 move rule?

      return false;
  }

  private boolean isCheckMate() {

      return false;
  }

  private boolean isStaleMate() {

      return false;
  }

  // gets valid chess notation move and makes sure it can be played
  private void getMove(boolean isWhite) {
    // Scanner in = new Scanner(System.in);
    // // print: name, it's your move.
    // System.out.println(activePlayer.getName() + ", it is your move");
    // String input = "";
    // while (input.trim().isEmpty()) {
    //   System.out.println("Enter the piece you want to move (use chess notation).");
    //   input = in.nextLine.trim();
    // }

    // input piece you want to move
    // check if piece is there and right color
    // input where you want to move piece
    // check if it's possible to move there
  }
  // returns [-1] if the chessNotation does not exist
  public static int[] convertChessNotationToArray(String chessNotation) {
    int[] arrayNotation = {-1, -1};
    chessNotation = chessNotation.trim().toLowerCase();
    if (chessNotation.length() != 2) {
      return arrayNotation;
    }
    int col = chessNotation.charAt(0) - 'a';
    int row = chessNotation.charAt(1) - '0';
    if (col > 7 || col < 0) {
      return arrayNotation;
    }
    if (row > 8 || row < 1) {
      return arrayNotation;
    }
    arrayNotation[0] = col;
    arrayNotation[1] = 8 - row;
    return arrayNotation;
  }

  private void switchTurn() {
    activePlayer = (activePlayer == white) ? black : white;
  }
}
