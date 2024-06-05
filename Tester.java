public class Tester {
  public static void main(String args[]) {
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
  }

}
