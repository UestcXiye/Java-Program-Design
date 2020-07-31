package pkumooc;

import org.apache.hc.client5.http.fluent.Request;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * @author liuwenchen
 * @create 2020-07-30 13:53
 */

public class HttpClientStock {
    public static void main(String... args) throws Exception {
        String stockCode = "sz000837";
        String str = Request.get("http://hq.sinajs.cn/list="+stockCode)
                .execute().returnContent().asString();
        System.out.println(str);

        String chartType = "min";
        String imageURL = "http://image.sinajs.cn/newchart/" + chartType + "/n/" + stockCode + ".gif";
        BufferedImage img = ImageIO.read(new URL(imageURL));
        ImageIO.write(img, "gif", new File("C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\aaa.gif"));
    }
}