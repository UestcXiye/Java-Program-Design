package pkumooc;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuwenchen
 * @create 2020-07-29 14:09
 */
public class BlockMoveGame extends JFrame {
    final int RC=4;
    final int N=RC*RC;
    int[] num=new int[N];
    JButton[] jButtons=new JButton[N];
    JButton startButton=new JButton("Start Game!");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BlockMoveGame());
    }

    public BlockMoveGame()
    {
        setTitle("BlockMoveGame");
        setSize(300,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        p1.setLayout(new GridLayout(RC,RC));
        p2.add(startButton);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p1,BorderLayout.CENTER);
        getContentPane().add(p2,BorderLayout.SOUTH);

        for(int i=0;i<N;i++)
        {
            num[i]=i;
            jButtons[i]=new JButton("" + num[i]+1);
            jButtons[i].setFont(new Font("Time New Rome",Font.PLAIN,24));
            p1.add(jButtons[i]);
            jButtons[i].setVisible(true);
        }
        jButtons[N-1].setVisible(false);

        startButton.addActionListener(e -> startButtonClick());
        for(int i=0;i<N;i++)
        {
            jButtons[i].addActionListener(e -> {
                for(int j=0;j<N;j++)
                {
                    if(e.getSource() == jButtons[j])
                    {
                        jButtonsClick(j);
                    }
                }
            });
        }
    }

    public void startButtonClick()
    {
        // 打乱顺序，开始游戏
        int i,j,k,temp;
        // 随机找j,k两个下标，交换其对应的num数组元素
        for(i=1;i<500;i++)
        {
            j=(int)(Math.random()*N);
            k=(int)(Math.random()*N);
            temp=num[j];
            num[j]=num[k];
            num[k]=temp;
        }
        // 显示按钮
        for(i=0;i<N;i++)
        {
            jButtons[i].setText("" + (num[i]+1));
            jButtons[i].setVisible(true);

        }
        // 隐藏一个空位按钮
        jButtons[findBlank()].setVisible(false);
    }

    int findBlank()
    {
        int i;
        for(i=0;i<N;i++)
        {
            if(num[i] == N-1) {
                break;
            }
        }
        return i;
    }

    void jButtonsClick(int index)
    {
        int blank=findBlank();
        int temp;
        // 如果相邻，一个隐藏，一个显示，并交换数字
        if(isNeighbor(blank,index))
        {
            jButtons[index].setVisible(false);
            jButtons[blank].setVisible(true);
            // 交换数字
            temp=num[blank];
            num[blank]=num[index];
            num[index]=temp;
            // 设置按钮内容
            jButtons[blank].setText("" + (num[blank]+1));
            jButtons[index].setText("" + (num[index]+1));
            // 焦点移到原按钮，让用户看清
            jButtons[blank].requestFocus();
        }
        // 调用过程，检查是否完成
        checkResult();
    }

    boolean isNeighbor(int a, int b)
    {
        boolean result=false;
        // 上下相邻
        if(a == b-RC || a == b+RC) {
            result=true;
        }
        // 在同一排，左右相邻
        if(a/RC == b/RC) {
            if(a == b-1 || a == b+1) {
                result=true;
            }
        }
        return result;
    }

    void checkResult()
    {
        for(int i=0;i<N;i++)
        {
            if(num[i] != i) {
                return;
            }
        }
        JOptionPane.showMessageDialog(this,
        "You win!Please click \"Start Game!\" to try again!");
    }
}
