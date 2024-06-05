public class Tester {
  public static void main(String args[]) {
<<<<<<< HEAD
    Board b = new Board();

    b.movePiece(0, 0, 0, 7);
    System.out.println(b);
    System.out.println(b.getPiece(3, 6));
    System.out.println(b.getPiece(3, 6).isLegalMove(b, 3, 6, 3, 4));
    // Board b = new Board();
    // System.out.println(b);
    // System.out.println(b.getPiece(1, 6).isLegalMove(b, 1, 6, 1, 5));

    /*Game g = new Game();
    g.getPlayerNames();
    g.assignActivePlayer();
    g.getMove();*/
=======
    // pawn doesnt work
    Game g = new Game();
    g.getPlayerNames();
    boolean stop = false;
    while (!stop) {
      System.out.println(g.getBoard());
      g.assignActivePlayer();
      g.getMove();
      System.out.println(g.getBoard());
    }
>>>>>>> 73290f0af74a5733674e9fde43bd7bc69dba8a23
  }
}
