public class Tester {
  public static void main(String args[]) {
    Game g = new Game();
    g.getPlayerNames();
    boolean stop = false;
    while (!stop) {
      System.out.println(g.getBoard());
      g.assignActivePlayer();
      g.getMove();
      System.out.println(g.getBoard());
    }
  }
}
