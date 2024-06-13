import java.util.ArrayList;

public class Tester {
  public static void main(String args[]) {
    Game g = new Game();
    g.getPlayerNames();
    g.assignActivePlayer();
    boolean stop = false;
    while (!stop) {
      System.out.println(g.getBoard());
      g.getMove();
      // g.promotion();
      // g.switchTurn();
    }

    // check troubleshooting

    // Board b = new Board();
    // b.movePiece(1, 7, 3, 2);
    // b.movePiece(0, 6, 3, 1);
    // System.out.println(b);
    // System.out.println(b.isSquareInCheck(4, 0, true));
    // System.out.println(b.findNumCheckingPieces(4, 0, false));
    // ArrayList<int[]> cords = b.findPosCheckingPieces(4, 0, false);
    // for (int[] pos : cords) {
    //   System.out.println("x: " + pos[0] + ", y: " + pos[1]);
    // }
  }
}
