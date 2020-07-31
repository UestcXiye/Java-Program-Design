import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.fluent.*;

public class HttpClientDemo {

    public static void main(String... args) throws Exception {
        String str = Request.Get("http://www.baidu.com")
                .execute().returnContent().asString();
        System.out.println(str);
        
    }

}