package com.kpakozdi.ea3.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws Exception {
        // XML fájl
        File f = new File("C:\\Users\\User\\IdeaProjects\\java_15_demo\\resources\\books.xml");

        // Factory, builder létrehozása
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse-olás
        Document document = builder.parse(f);

        List<Book> books = new ArrayList<>();

        // átmeneti tömb, amibe egyelőre betöltöm a book Elementeket
        List<Element> bookElements = new ArrayList<>();

        Element rootElement = document.getDocumentElement();

        NodeList bookNodeList = rootElement.getElementsByTagName("book");

        for (int i = 0; i < bookNodeList.getLength(); i++) {
            bookElements.add((Element) bookNodeList.item(i));
        }

        bookElements
                .stream()
                .map(element -> {
                    String category = element.getAttribute("category");
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String yearStr = element.getElementsByTagName("year").item(0).getTextContent();
                    String priceStr = element.getElementsByTagName("price").item(0).getTextContent();
                    int year = Integer.parseInt(yearStr);
                    double price = Double.parseDouble(priceStr);

                    List<String> authors = new ArrayList<>();
                    NodeList authorNodeList = element.getElementsByTagName("author");

                    for (int i = 0; i < authorNodeList.getLength(); i++) {
                        String author = authorNodeList.item(i).getTextContent();
                        authors.add(author);
                    }

                    return new Book(title, authors, year, price, category);
                })
                .forEach(b -> {
                    System.out.println(b);
                });
    }
}
