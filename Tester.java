public class Tester {
  public static void main(String args[]) {
    // testing movePiece
    // Board b = new Board();
    // b.movePiece(0, 0, 0, 7);
    // System.out.println(b);
    int[] xy = Game.chessNotationToArray("b8");
    System.out.println(xy[0] + " " + xy[1]);
  }
}
