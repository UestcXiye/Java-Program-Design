package pkumooc; /**
 * @author liuwenchen
 * @create 2020-07-01 13:14
 */
import javax.swing.*;
import java.awt.*;

public class Circle99Frame extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new Circle99Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawString("Circle 99", 20, 20);
        int x0 = getSize().width/2;
        int y0 = getSize().height/2;
        for(int r=0;r<getSize().height/2;r+=10) {
            g.setColor(getRandomColor());
            g.drawOval(x0-r, y0-r, r*2, r*2);
            //g.drawOval(x0-r, y0-r/2, r*2, r*2);
        }
    }

    private Color getRandomColor() {
        return new Color(
                (int) (Math.random()*255),
                (int) (Math.random()*255),
                (int) (Math.random()*255)
        );
    }
}