package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int count, String author) {
        super(id, name, count);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }


}
