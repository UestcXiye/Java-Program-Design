import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;

public class DOMParser {
    DocumentBuilderFactory builderFactory = 
		DocumentBuilderFactory.newInstance();
    
	//载入XML到DOM
    public Document parse(String filePath) {
        Document document = null;
        try {
            //DOM parser 实例
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            //载入XML到DOM
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static void main(String[] args) {
        DOMParser parser = new DOMParser();
        Document document = parser.parse("books.xml");
        //得到根元素
        Element rootElement = document.getDocumentElement();

        //遍历
        NodeList nodes = rootElement.getChildNodes();
        for (int i=0; i < nodes.getLength(); i++)
        {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                //这里可以进一步处理
				System.out.println( node.getTextContent() );
            }
        }
		//按标记查找到元素
        NodeList nodeList = rootElement.getElementsByTagName("book");
        if(nodeList != null)
        {
            for (int i = 0 ; i < nodeList.getLength(); i++)
            {
                Element element = (Element)nodeList.item(i);
                String id = element.getAttribute("id");
            }
        }
    }
}