public class Tester {
  public static void main(String args[]) {
    Board b = new Board();
<<<<<<< HEAD
    b.movePiece(0, 1, 0, 7);
    System.out.println(b);
=======
    System.out.println(b.getPiece(3, 6));
    System.out.println(b.getPiece(3, 6).isLegalMove(b, 3, 6, 3, 4));
>>>>>>> refs/remotes/origin/main
  }
}
