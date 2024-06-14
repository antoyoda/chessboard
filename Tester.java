import java.util.ArrayList;

public class Tester {
  public static void main(String args[]) {
    Game g = new Game();
    g.start();
    // Game g = new Game();
    // g.getPlayerNames();
    // g.assignActivePlayer();
    // boolean stop = false;
    // while (!stop) {
    //   System.out.println(g.getBoard());
    //   g.getMove();
    //   // g.promotion();
    //   // g.switchTurn();
    // }
    //
    // Board s = new Board();
    // s.movePiece(3, 7, 5, 1);
    // s.movePiece(6, 7, 4, 3);
    // System.out.println(s);
    // System.out.println(s.getPiece(4, 1).isLegalMove(s, 4, 1, 5, 1));
    //
    // check troubleshooting
    //
    // // TEST ONE KNIGHT CHECKMATE
    // Game g1 = new Game();
    // Board b = new Board();
    // b.movePiece(1, 7, 3, 2);
    // b.movePiece(6, 7, 5, 2);
    // System.out.println(b);
    // g1.switchBoard(b);
    // System.out.println(g1.isCheckmate(false));
    //
    // // TEST TWO ADVANCED KNIGHT CHECKMATE
    // Game g2 = new Game();
    // Board b1 = new Board();
    // b1.movePiece(6, 7, 5, 2);
    // b1.movePiece(3, 6, 3, 1);
    // System.out.println(b1);
    // g2.switchBoard(b1);
    // System.out.println(g2.isCheckmate(false));
    //
    // // TEST THREE KNIGHT CHECKS WITH FLEEING SQUARE
    // Game g3 = new Game();
    // Board b2 = new Board();
    // b2.movePiece(1, 7, 3, 2);
    // b2.movePiece(6, 7, 5, 2);
    // b2.movePiece(5, 0, 6, 1);
    // System.out.println(b2);
    // g3.switchBoard(b2);
    // System.out.println(g3.isCheckmate(false));
    //
    // // TEST FOUR QUEEN CHECKMATE
    // Game g4 = new Game();
    // Board b3 = new Board();
    // b3.movePiece(3, 7, 5, 1);
    // b3.movePiece(6, 7, 4, 3);
    // System.out.println(b3);
    // g4.switchBoard(b3);
    // System.out.println(g4.isCheckmate(false));
    //
    // // TEST FIVE ROOK BACKRANK
    // Game g5 = new Game();
    // Board b4 = new Board();
    // b4.movePiece(4, 0, 1, 0);
    // b4.movePiece(2, 0, 3, 0);
    // b4.movePiece(0, 7, 3, 0);
    // System.out.println(b4);
    // g5.switchBoard(b4);
    // System.out.println(g5.isCheckmate(false));
    //
    // // TEST SIX ROOK BACKRANK WITH INTERPOSITION
    // Game g6 = new Game();
    // Board b5 = new Board();
    // b5.movePiece(4, 0, 1, 0);
    // b5.movePiece(2, 0, 3, 0);
    // b5.movePiece(0, 7, 3, 0);
    // b5.movePiece(6, 0, 1, 2);
    // System.out.println(b5);
    // g6.switchBoard(b5);
    // System.out.println(g6.isCheckmate(false));
    //
    // // TEST SEVEN BISHOP CHECKMATE
    // Game g7 = new Game();
    // Board b6 = new Board();
    // b6.movePiece(5, 1, 5, 2);
    // b6.movePiece(6, 1, 6, 3);
    // b6.movePiece(2, 7, 7, 3);
    // System.out.println(b6);
    // g7.switchBoard(b6);
    // System.out.println(g7.isCheckmate(false));
    //
    // // TEST EIGHT BISHOP CHECKMATE WITH INTERPOSITION
    // Game g8 = new Game();
    // Board b7 = new Board();
    // b7.movePiece(5, 1, 5, 2);
    // b7.movePiece(2, 7, 7, 3);
    // System.out.println(b7);
    // g8.switchBoard(b7);
    // System.out.println(g8.isCheckmate(false));
  }
}
