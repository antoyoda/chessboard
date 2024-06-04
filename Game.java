import java.util.Scanner;
import java.util.Arrays;

public class Game {
  private Board board = new Board();
  private Player white;
  private Player black;
  private Player activePlayer;

  public Game() {
    // nothing needed, could maybe switch start to static
  }

  // returns [-1, -1] if the chessNotation does not exist
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

  // initializes player names
  public void getPlayerNames() {
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

  // for testing purposes
  public void assignActivePlayer() {
    activePlayer = white;
  }

  // gets valid chess notation move and makes sure it can be played
  public void getMove() {
    Scanner in = new Scanner(System.in);
    String c = "black";
    if (activePlayer.isWhite()) {
      c = "white";
    }
    System.out.println(activePlayer.getName() + ", you are playing with the " + c + "pieces, it is your move.");
    String input1 = "";
    boolean isGoodInput = false;
    int[] arrayNotation1 = new int[2];
    int[] arrayNotation2 = new int[2];

    while (!isGoodInput) {
      System.out.println("Enter the piece you want to move (use chess notation).");
      if (in.hasNextLine()) {
        input1 = in.nextLine();
      }
      arrayNotation1 = Game.convertChessNotationToArray(input1);
      // check notation
      if (Arrays.equals(arrayNotation1, new int[] {-1, -1})) {
        System.out.println("You used the wrong notation! Please check your input!");
        continue;
      }
      // check if piece type is correct/if it is null
      Piece p = board.getPiece(arrayNotation1[0], arrayNotation1[1]);
      if (p == null) {
        System.out.println("There is no piece there! Please check your input!");
        continue;
      }
      if (!(activePlayer.isWhite() == p.isWhite())) {
        System.out.println("You are playing with the " + c + " pieces, you cannot move that piece! Please check your input!");
        continue;
      }

      String input2 = "";
      boolean isGoodSecondaryInput = false;
      while (!isGoodSecondaryInput) {
        System.out.println("Enter where you want to move the piece (use chess notation).");
        if (in.hasNextLine()) {
          input2 = in.nextLine();
        }
        arrayNotation2 = Game.convertChessNotationToArray(input2);
        // check notation
        if (Arrays.equals(arrayNotation2, new int[] {-1, -1})) {
          System.out.println("You used the wrong notation! Please check your input!");
          continue;
        }
        // if everything is good, move the piece
        if (p.isLegalMove(board, arrayNotation1[0], arrayNotation1[1], arrayNotation2[0], arrayNotation2[1])) {
          board.movePiece(arrayNotation1[0], arrayNotation1[1], arrayNotation2[0], arrayNotation2[1]);
          isGoodInput = true;
          isGoodSecondaryInput = true;
        }
        else {
          System.out.println("That is not a legal move. Please try again.");
          break;
        }
      }
    }
    in.close();
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

  private void switchTurn() {
    activePlayer = (activePlayer == white) ? black : white;
  }
}
