package com.kpakozdi.ea3.sax;

import com.kpakozdi.ea3.dom.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // SAX factory, builder
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // Fájl beolvasása a parserrel
        File f = new File("C:\\Users\\User\\IdeaProjects\\java_15_demo\\resources\\books.xml");
        parser.parse(f, new MyHandler());
    }
}

class MyHandler extends DefaultHandler {
    private List<Book> books;
    // milyen elemet olvasok éppen
    private String actualElement = "";
    private String title;
    private int year;
    private double price;
    private String category;

    @Override
    public void startDocument() throws SAXException {
        books = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String tagName, Attributes attributes) throws SAXException {
        actualElement = tagName;
        if(category == null) {
            category = attributes.getValue("category");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String actualValue = new String(ch, start, length);
        switch (actualElement) {
            case "title" -> title = actualValue;
            case "year" -> year = Integer.parseInt(actualValue);
            case "price" -> price = Double.parseDouble(actualValue);
            // TODO: további esetek vizsgálata
        }
        actualElement = "";
    }

    @Override
    public void endElement(String uri, String localName, String tagName) throws SAXException {
        // hogyha a book element olvasását fejeztem be
        if ("book".equals(tagName)) {
            // az eddigi adatok (title, year...) alapján példányosítok egy Book objectet
            Book b = new Book();
            b.setTitle(title);
            b.setYear(year);
            b.setPrice(price);
            b.setCategory(category);
            category = null;
            // TODO: hátravan a többi element hozzáadása
            books.add(b);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}