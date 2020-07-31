package pkumooc;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuwenchen
 * @create 2020-07-10 0:40
 */
public class CayleyTree extends JFrame {
    public static void main(String[] args) {
        CayleyTree frm=new CayleyTree("CayleyTree");
        frm.setVisible(true);
        SwingUtilities.invokeLater(()->{
            frm.init();
            frm.drawTree(10,200,400,100,-Math.PI/2);
        });
    }

    private Frame frm;
    private Graphics graphics;
    private int width;
    private int height;
    private final double PI=Math.PI;
    private final double t1=30*PI/180;
    private final double t2=20*PI/180;
    private final double p1=0.6;
    private final double p2=0.7;

    public CayleyTree(String title)
    {
        super(title);
        setSize(400,440);
        setBackground(Color.lightGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void init()
    {
        width=getSize().width;
        height=getSize().height;
        graphics=this.getGraphics();
    }

    void drawTree(int n, double x0, double y0, double l, double t)
    {
        if(n==0) {
            return;
        }

        double x1=x0+l*Math.cos(t);
        double y1=y0+l*Math.sin(t);

        drawLine(x0,y0,x1,y1);

        drawTree(n-1,x1,y1,p1*l,t+t1);
        drawTree(n-1,x1,y1,p2*l,t-t2);
    }

    void drawLine(double x0, double y0, double x1, double y1)
    {
        graphics.drawLine((int) x0,(int) y0,(int) x1,(int) y1);
    }
}