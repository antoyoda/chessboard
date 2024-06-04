import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class ChessBoardViewer {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    // 6 spaces between character (ik its aids dw abt it)
    JLabel label = new JLabel("A      B      C      D      E      F      G      H ");
    label.setFont(new Font("Arial", Font.BOLD, 20));
    label.setBounds(67,435,400,50);
    label.setForeground(Color.white);
    frame.add(label);


    frame.setSize(500, 500);
    frame.setTitle("PENISCUM");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ChessBoardComponent component = new ChessBoardComponent();
    frame.add(component);

    frame.setVisible(true);
  }
}
