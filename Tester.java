public class Tester {
  public static void main(String args[]) {
    // pawn doesnt work
    Game g = new Game();
    g.getPlayerNames();
    g.assignActivePlayer();
    boolean stop = false;
    while (!stop) {
      System.out.println(g.getBoard());
      g.getMove();
      System.out.println(g.getBoard());
      g.switchTurn();
    }
  }
}
