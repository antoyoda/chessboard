import javax.swing.JFrame;

public class ChessBoardViewer {
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    frame.setSize(500, 500);
    frame.setTitle("Ajedrez");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ChessBoardComponent component = new ChessBoardComponent();
    frame.add(component);

    frame.setVisible(true);
  }
}
