public class Tester {
  public static void main(String args[]) {
    Game g = new Game();
    g.getPlayerNames();
    g.assignActivePlayer();
    boolean stop = false;
    while (!stop) {
      System.out.println(g.getBoard());
      g.getMove();
      // g.switchTurn();
    }

    // check troubleshooting

    // Board b = new Board();
    // b.movePiece(1, 7, 3, 2);
    // b.movePiece(0, 7, 0, 3);
    // System.out.println(b);
    // System.out.println(b.isSquareInCheck(4, 0, true));
  }
}
