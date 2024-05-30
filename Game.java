import java.util.Scanner;

public class Game {
  private Player white;
  private Player black;
  private Board board = new Board();

  public Game() {
    white = null;
    black = null;
  }

  public String getNameWhite() {
    if (white != null) {
      return white.getName();
    }
    else {
      return null;
    }
  }

  public String getNameBlack() {
    if (black != null) {
      return black.getName();
    }
    else {
      return null;
    }
  }

  // initializes player names
  public void start() {
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
  // gets valid chess notation move and makes sure it can be played
  public void getMove() {
  }

}
