public class Tester {
  public static void main(String args[]) {
    Game game1 = new Game();
    game1.start();
    System.out.println("white's name: " + game1.getNameWhite());
    System.out.println("black's name: " + game1.getNameBlack());
  }
}
