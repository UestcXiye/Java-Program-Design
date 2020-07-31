import java.util.*;
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.text.*;
import java.awt.event.*;

public class Clock2 extends JApplet implements Runnable {
    Thread timer;                // 线程
    int lastxs, lastys, lastxm,
        lastym, lastxh, lastyh;  // 线的位置 
    SimpleDateFormat formatter;  // 日期格式
    String lastdate;             // 显示的时期
    Font clockFaceFont;          // 字体
    Date currentDate;            // 当前时间
    Color handColor;             // 指针颜色
    Color numberColor;           // 数字颜色

	@Override
    public void init() {
        int x,y;
        lastxs = lastys = lastxm = lastym = lastxh = lastyh = 0;
        formatter = new SimpleDateFormat ("EEE MMM dd hh:mm:ss yyyy", Locale.getDefault());
        currentDate = new Date();
        lastdate = formatter.format(currentDate);
        clockFaceFont = new Font("Serif", Font.PLAIN, 14);
        handColor = Color.blue;
        numberColor = Color.darkGray;

        try {
            setBackground(
				new Color(Integer.parseInt(getParameter("bgcolor"),16)));
        } catch (Exception ex) { ex.printStackTrace();}
        try {
            handColor = new Color(Integer.parseInt(getParameter("fgcolor1"),16));
        } catch (Exception ex) { ex.printStackTrace();}
        try {
            numberColor = new Color(Integer.parseInt(getParameter("fgcolor2"),16));
        } catch (Exception ex) { ex.printStackTrace();}

        resize(300,200);              // Set clock window size
    }

    public void circle(int x0, int y0, int r, Graphics g) {
		g.drawOval( x0-r, y0-r, r*2, r*2 );
    }

    // Paint 是程序的主要部分
	@Override
    public void paint(Graphics g) {
        int xh, yh, xm, ym, xs, ys, s = 0, m = 10, h = 10, xcenter, ycenter;
        String today;

        currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("s",Locale.getDefault());
        try {
            s = Integer.parseInt(formatter.format(currentDate));
        } catch (NumberFormatException n) {
            s = 0;
        }
        formatter.applyPattern("m");
        try {
            m = Integer.parseInt(formatter.format(currentDate));
        } catch (NumberFormatException n) {
            m = 10;
        }    
        formatter.applyPattern("h");
        try {
            h = Integer.parseInt(formatter.format(currentDate));
        } catch (NumberFormatException n) {
            h = 10;
        }
        formatter.applyPattern("EEE MMM dd HH:mm:ss yyyy");
        today = formatter.format(currentDate);
        xcenter=80;
        ycenter=55;
        
        xs = (int)(Math.cos(s * Math.PI/30 - Math.PI/2) * 45 + xcenter);
        ys = (int)(Math.sin(s * Math.PI/30 - Math.PI/2) * 45 + ycenter);
        xm = (int)(Math.cos(m * Math.PI/30 - Math.PI/2) * 40 + xcenter);
        ym = (int)(Math.sin(m * Math.PI/30 - Math.PI/2) * 40 + ycenter);
        xh = (int)(Math.cos((h*30 + m/2) * Math.PI/180 - Math.PI/2) * 30 + xcenter);
        yh = (int)(Math.sin((h*30 + m/2) * Math.PI/180 - Math.PI/2) * 30 + ycenter);
    
		// 画圆及数字
        g.setFont(clockFaceFont);
        g.setColor(handColor);
        circle(xcenter,ycenter,50,g);
        g.setColor(numberColor);
        g.drawString("9",xcenter-45,ycenter+3); 
        g.drawString("3",xcenter+40,ycenter+3);
        g.drawString("12",xcenter-5,ycenter-37);
        g.drawString("6",xcenter-3,ycenter+45);

		// 除去旧线，画新线
    
        g.setColor(getBackground());
        if (xs != lastxs || ys != lastys) {
            g.drawLine(xcenter, ycenter, lastxs, lastys);
            g.drawString(lastdate, 5, 125);
        }
        if (xm != lastxm || ym != lastym) {
            g.drawLine(xcenter, ycenter-1, lastxm, lastym);
            g.drawLine(xcenter-1, ycenter, lastxm, lastym); 
		}
        if (xh != lastxh || yh != lastyh) {
            g.drawLine(xcenter, ycenter-1, lastxh, lastyh);
            g.drawLine(xcenter-1, ycenter, lastxh, lastyh); 
		}
        g.setColor(numberColor);
        g.drawString("", 5, 125);
        g.drawString(today, 5, 125);    
        g.drawLine(xcenter, ycenter, xs, ys);
        g.setColor(handColor);
        g.drawLine(xcenter, ycenter-1, xm, ym);
        g.drawLine(xcenter-1, ycenter, xm, ym);
        g.drawLine(xcenter, ycenter-1, xh, yh);
        g.drawLine(xcenter-1, ycenter, xh, yh);
        lastxs=xs; lastys=ys;
        lastxm=xm; lastym=ym;
        lastxh=xh; lastyh=yh;
        lastdate = today;
        currentDate=null;
    }

	@Override
    public void start() {
        timer = new Thread(this);
        timer.start();
    }

	@Override
    public void stop() {
        timer = null;
    }

    public void run() {
        Thread me = Thread.currentThread();
        while (timer == me) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
            }
			SwingUtilities.invokeLater( ()->{
				repaint();
			});
        }
    }

	@Override
    public void update(Graphics g) {
        paint(g);
    }

	@Override
    public String getAppletInfo() {
        return "Title: A Clock \n";
    }
  
    public String[][] getParameterInfo() {
        String[][] info = {
            {"bgcolor", "hexadecimal RGB ", "The background color. "},
            {"fgcolor1", "hexadecimal RGB ", "The color of the hands and dial. Default is blue."},
            {"fgcolor2", "hexadecimal RGB ", "The color of the seconds hand and numbers. Default is dark gray."}
        };
        return info;
    }

	//为了也能用application的方式运行，加个main函数
	public static void main(String [] args) 
	{
		JFrame f = new JFrame();
		f.setSize(300,200 );
		Clock2 p = new Clock2();
		f.add ( p );
		f.setVisible( true );
		p.init();
		p.start();
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
