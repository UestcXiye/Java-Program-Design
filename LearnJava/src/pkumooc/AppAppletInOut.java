package pkumooc;
/**
 * @author liuwenchen
 * @create 2020-07-01 0:33
 */
import javax.swing.*;
import java.awt.*;

public class AppAppletInOut extends JApplet {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        AppAppletInOut app = new AppAppletInOut();
        app.init();
        frame.getContentPane().add(app);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    JTextField in = new JTextField(10);
    JButton btn = new JButton("求平方根");
    JLabel out = new JLabel();

    public void init()
    {
        setLayout(new FlowLayout());
        add(in);
        add(btn);
        add(out);
        btn.addActionListener( e->{
            String s = in.getText();
            double d =Double.parseDouble(s);
            double sq = Math.sqrt(d);
            out.setText(d + "的平方根是"+sq);
        });
    }
}