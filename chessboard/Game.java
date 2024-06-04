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
    // print: name, it's your move.
    // input piece you want to move
    // check if piece is there and right color, and if it has legal moves
    // input where you want to move piece
    // check if it's possible to move there
  }

  private void switchTurn() {
    activePlayer = (activePlayer == white) ? black : white;
  }
}
