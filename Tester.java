public class Tester {
  public static void main(String args[]) {
    // Game g = new Game();
    // g.getPlayerNames();
    // g.assignActivePlayer();
    // boolean stop = false;
    // while (!stop) {
    //   System.out.println(g.getBoard());
    //   g.getMove();
    //   System.out.println(g.getBoard());
    //   g.switchTurn();
    // }

    Board b = new Board();
    b.movePiece(1, 7, 3, 2);
    System.out.println(b);
    Board clone = new Board(b);
    System.out.println(clone);
  }
}
