package pkumooc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author liuwenchen
 * @create 2020-07-30 20:04
 */

public class JpegCreate {
    public static void main(String[] args) throws Exception{
        int width=400, height=200;
        BufferedImage image
                = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        drawInBufferedImage(image);

        java.net.URL path = JpegCreate.class.getResource(".");
        System.out.println(path);
        File file = new File(new File(path.toURI()), "t.jpg");
        ImageIO.write(image, "JPEG", file );
    }

    public static void drawInBufferedImage( BufferedImage image )
    {
        java.util.List<Integer> data = java.util.Arrays.asList(20,50,150,130,170);
        int count=data.size();
        int width=image.getWidth();
        int height=image.getHeight();
        int padding = 10;
        int w = width - 2 * padding;
        int h = height - 2 * padding;
        int y0 = h+padding;

        //get Graphics object
        Graphics g = image.getGraphics();
        // draw axes
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.blue);
        g.drawLine(padding, y0, padding, h-y0);
        g.drawLine(padding, y0, padding +w ,y0);
        // draw data
        int old = data.get(0);
        for (int i=1;i<count; i++)
        {
            int cur = data.get(i);
            g.drawLine(padding +i*w/count, y0, padding +i*w/count, y0-5);
            g.drawLine(padding +(i-1)*w/count,y0-old, padding +i*w/count, y0-cur);
            old = cur;
        }
    }
}