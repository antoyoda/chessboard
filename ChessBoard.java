import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class ChessBoard {
  private int x;
  private int y;
  private int len;

  public ChessBoard(int xPos, int yPos, int squareDimensions) {
    x = xPos;
    y = yPos;
    len = squareDimensions;
  }

  public void draw(Graphics2D g2) {

    Color beige = new Color(234, 221, 202);
    Color black = new Color(111, 78, 55);
    Rectangle border = new Rectangle(len-10,len-10,(len)*8+20,(len)*8+20);
    g2.setColor(Color.BLACK);
    g2.fill(border);
    for (int i = 1; i <= 8; i++) {
      for (int j = 1; j <= 8; j++) {
        if ((i + j) % 2 == 0)
          g2.setColor(beige);
        else
          g2.setColor(black);
        Rectangle square = new Rectangle(len * j, len * i, len, len);
        g2.fill(square);
      }
    }
    g2.setColor(Color.BLACK);
    g2.drawLine(len,len,len,len*9);
    g2.drawLine(len,len,len*9,len);
    g2.drawLine(len,len*9,len*9,len*9);
    g2.drawLine(len*9,len,len*9,len*9);
  }
}
