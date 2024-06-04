public class Tester {
  public static void main(String args[]) {
    int[] test1 = Game.convertChessNotationToArray("e4");
    System.out.println("e4 should be 4, 4");
    System.out.println(test1[0] + " " + test1[1]);
    int[] test2 = Game.convertChessNotationToArray("g2");
    System.out.println("g2 should be 6, 6");
    System.out.println(test2[0] + " " + test2[1]);
    int[] test3 = Game.convertChessNotationToArray("b3");
    System.out.println("b3 should be 1, 5");
    System.out.println(test3[0] + " " + test3[1]);
    int[] test4 = Game.convertChessNotationToArray("a1");
    System.out.println("a1 should be 0, 7");
    System.out.println(test4[0] + " " + test4[1]);
  }
}
