import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ChessBoardComponent extends JComponent {
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    ChessBoard cb = new ChessBoard(0, 0, 50);

    cb.draw(g2);
  }
}
