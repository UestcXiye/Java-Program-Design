import java.util.*;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class SAXParser {
    class BookHandler extends DefaultHandler {
        private List<String> nameList;
        private boolean title = false;

        public List<String> getNameList() {
            return nameList;
        }
        // 当遇到文档开始
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start parsing document...");
            nameList = new ArrayList<String>();
        }
        // 当遇到文档结束
        @Override
        public void endDocument() throws SAXException {
            System.out.println("End");
        }

        /**
         * 当遇到文档元素开始.
         * @param namespaceURI  名称空间
         * @param localName  本地名
         * @param qName  带前缀的名字
         * @param atts  属性
         */
        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes atts) throws SAXException {
            // 进行处理
            if (qName.equals("title")) {
                title = true;
            }
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName)
        throws SAXException {
            // 处理元素结束
            if (title) {
                title = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // 处理一个元素内部的字符
            if (title) {
                String bookTitle = new String(ch, start, length);
                System.out.println("Book title: " + bookTitle);
                nameList.add(bookTitle);
            }
        }
    }

    public static void main(String[] args) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        BookHandler bookHandler = (new SAXParser()).new BookHandler();
        parser.setContentHandler(bookHandler);
        parser.parse("books.xml");
        System.out.println(bookHandler.getNameList());
    }
}