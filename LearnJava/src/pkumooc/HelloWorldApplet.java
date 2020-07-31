package pkumooc;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuwenchen
 * @create 2020-07-29 18:12
 */
public class HelloWorldApplet extends JApplet {
    @Override
    public void paint(Graphics graphics)
    {
        graphics.drawString("Hello World!",20,20);
    }
}
