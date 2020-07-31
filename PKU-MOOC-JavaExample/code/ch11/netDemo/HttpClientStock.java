import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.fluent.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class HttpClientStock {

    public static void main(String... args) throws Exception {
    	String stockCode = "sz000837";  //sh600509
        String str = Request.Get("http://hq.sinajs.cn/list="+stockCode)
                .execute().returnContent().asString();
        System.out.println(str);
        
        String chartType = "min"; //daily, weekly, monthly
        String imageURL = "http://image.sinajs.cn/newchart/" + chartType + "/n/" + stockCode + ".gif";
        
        //BufferedImage img = ImageIO.read(Request.Get(imageURL)
        //        .execute().returnContent().asStream());
        BufferedImage img = ImageIO.read(new URL(imageURL));
        ImageIO.write(img, "gif", new File("d:\\aaa.gif"));
    }

}