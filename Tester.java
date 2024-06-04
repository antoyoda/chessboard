public class Tester {
  public static void main(String args[]) {
    // pawn doesnt work
    Game g = new Game();
    System.out.println(g.getBoard());
    g.getPlayerNames();
    g.assignActivePlayer();
    g.getMove();
    System.out.println(g.getBoard());
  }

}
