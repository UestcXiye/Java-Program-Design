package pkumooc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuwenchen
 * @create 2020-07-12 11:06
 */
public class RegexHref {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://www.baidu.com");
        URLConnection uc=url.openConnection();
        String charSet=getCharset(uc.getContentType());
        BufferedReader br=new BufferedReader(
                new InputStreamReader(uc.getInputStream(),"UTF-8"));
        String line;
        String mailreg="<a(?:\\s+.)*?\\s+href=\"([^\"]*?)\"";

        Pattern p= Pattern.compile(mailreg);
        while((line=br.readLine())!=null)
        {
            Matcher m=p.matcher(line);
            while(m.find())
            {
                System.out.println(m.group());
            }
        }
    }

    private static String getCharset(String str)
    {
        Pattern pattern = Pattern.compile("charset=.*");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find())
            return matcher.group(0).split("charset=")[1];
        return null;
    }
}
