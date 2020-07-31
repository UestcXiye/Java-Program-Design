package pkumooc;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-12 19:09
 */

public class InvokeLaterDemo extends JFrame {
    JButton btn=new JButton("Start the countdown!");
    JLabel lbl=new JLabel("",JLabel.CENTER);

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please enter the countdown time: ");
        int time=scanner.nextInt();
        SwingUtilities.invokeLater(()-> new InvokeLaterDemo(time));

        // SwingUtilities.invokeLater(()-> {
        //    new InvokeLaterDemo(time);
        // });
    }

    public InvokeLaterDemo(int Time)
    {
        lbl.setFont(new Font("黑体",Font.BOLD,40));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(btn,BorderLayout.NORTH);
        getContentPane().add(lbl,BorderLayout.CENTER);

        btn.addActionListener(e -> new Thread(() -> {
            for(int i=Time;i>=0;i--)
            {
                final int j=i;
                SwingUtilities.invokeLater(() -> lbl.setText("" + j));

                try {
                    Thread.sleep(1000);
                }catch(Exception ignored){}
            }
        }).start());

        setSize(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}