package com.kpakozdi.ea3.dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // DOM Parser - factory és builder létrehozása
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringComments(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

//        // XML olvasás - stringből
        String myXml = """
                <cars count="1">
                    <car id="1">
                        <type>Volkswagen</type>
                        <engine>2.0 CR</engine>
                    </car>
                </cars>
                """;
//
//        byte[] myXmlBytes = myXml.getBytes();
//
//        InputStream is = new ByteArrayInputStream(myXmlBytes);
//
//        Document document = builder.parse(is);
//
//        // root lekérése
//        Element root = document.getDocumentElement();
//
//        NamedNodeMap map = root.getAttributes();
//
//        for (int i = 0; i < map.getLength(); i++) {
//            System.out.println(map.item(i));
//        }


        File f = new File("C:\\Users\\User\\IdeaProjects\\java_15_demo\\resources\\books.xml");

        Document doc = builder.parse(f);

        // legvégén azt szeretném, hogy egy ilyen listában *objektumként* szerepeljenek
        // ezt a listát szeretnénk feltölteni az XML alapján
        List<Book> books = new ArrayList<>();

        // gyökérelem elkérése
        Element root = doc.getDocumentElement();

        // a gyökérelem (bookstore) alatti összes bookot szeretném elkérni
        NodeList bookNodeList = root.getElementsByTagName("book");

        // iterálok a book tagek között
//        for (int i = 0; i < bookNodeList.getLength(); i++) {
//            Book book = new Book();
//            Node bookNode = bookNodeList.item(i);
//            NamedNodeMap bookNodeAttributes = bookNode.getAttributes();
//
//            // elkérjük a category attribútumot
//            Node categoryNode = bookNodeAttributes.getNamedItem("category");
//            if(categoryNode != null ) {
//                book.setCategory(categoryNode.getNodeValue());
//            }
//
//            Element bookElement = (Element) bookNode;
//
//            List<String> authors = new ArrayList<>();
//
//            String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
//            NodeList authorNodes = bookElement.getElementsByTagName("author");
//
//            for (int j = 0; j < authorNodes.getLength(); j++) {
//                authors.add(authorNodes.item(j).getTextContent());
//            }
//
//            String year = bookElement.getElementsByTagName("year").item(0).getTextContent();
//            String price = bookElement.getElementsByTagName("price").item(0).getTextContent();
//
//            book.setTitle(title);
//            book.setAuthor(authors);
//            book.setYear(Integer.parseInt(year));
//            book.setPrice(Double.parseDouble(price));
//
//            books.add(book);
//        }

        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < bookNodeList.getLength(); i++) {
            System.out.println(bookNodeList.item(i).getClass().getName());
            elements.add((Element) bookNodeList.item(i));
        }

    }
}
