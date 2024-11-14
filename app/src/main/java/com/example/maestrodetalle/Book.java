package com.example.maestrodetalle;

public class Book {
    private String title;
    private String authorId;

    public Book(String title, String authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
        return authorId;
    }
}
