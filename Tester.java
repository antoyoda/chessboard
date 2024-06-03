public class Tester {
  public static void main(String args[]) {
    Board b = new Board();
    System.out.println(b.getPiece(3, 6));
    System.out.println(b.getPiece(3, 6).isLegalMove(b, 3, 6, 3, 4));
  }
}
