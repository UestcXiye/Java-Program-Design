package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-04 21:12
 */
import java.awt.*;
import java.awt.event.*;
public class TestInnerClass {
    private Frame f;
    private TextField tf;
    public void launchFrame() {
        f=new Frame("Inner classes example");
        tf=new TextField(30);
        Label label=new Label("Click and drag the mouse");
        f.add(label,BorderLayout.NORTH);
        f.add(tf,BorderLayout.SOUTH);
        f.addMouseMotionListener(new MyMouseMotionListener());
        f.addWindowListener(new MyWindowListener());
        f.setSize(300,200);
        f.setVisible(true);
    }
    class MyMouseMotionListener extends MouseMotionAdapter{//内部类开始
        public void mouseDragged(MouseEvent e) {
            String s="Mouse dragging:x="+e.getX()+"Y="+e.getY();
            tf.setText(s);
        }
    }//内部类结束
    class MyWindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestInnerClass tic=new TestInnerClass();
        tic.launchFrame();
    }
}