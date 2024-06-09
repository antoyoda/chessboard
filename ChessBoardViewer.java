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
      JLabel labelTop = new JLabel("A      B      C      D      E      F      G      H ");
      labelTop.setFont(new Font("Arial", Font.BOLD, 20));
      labelTop.setBounds(67,15,400,50);
      labelTop.setForeground(Color.white);
      frame.add(labelTop);

    
    for (int i = 1; i <= 8; i++) {
        JLabel verticalLabel = new JLabel(String.valueOf(i));
        verticalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        verticalLabel.setForeground(Color.white);
        // Adjust the x, y coordinates and size to place the labels vertically
        verticalLabel.setBounds(35, 50 * (8 - i) + 50, 50, 50); // Adjust y-coordinate to move the labels down
        frame.add(verticalLabel);
    }
      for (int i = 1; i <= 8; i++) {
          JLabel verticalLabel = new JLabel(String.valueOf(i));
          verticalLabel.setFont(new Font("Arial", Font.BOLD, 20));
          verticalLabel.setForeground(Color.white);
          // Adjust the x, y coordinates and size to place the labels vertically
          verticalLabel.setBounds(455, 50 * (8 - i) + 50, 50, 50); // Adjust y-coordinate to move the labels down
          frame.add(verticalLabel);
      }

    
    frame.setSize(500, 500);
    frame.setTitle("CHESS GAME");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ChessBoardComponent component = new ChessBoardComponent();
    frame.add(component);

    frame.setVisible(true);
  }
}
