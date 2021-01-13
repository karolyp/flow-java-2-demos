package com.kpakozdi.ea3.dom;

import java.util.List;

public class Book {
    private String title;
    private List<String> authors;
    private int year;
    private double price;
    private String category;

    public Book() {
    }

    public Book(String title, List<String> authors, int year, double price, String category) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
