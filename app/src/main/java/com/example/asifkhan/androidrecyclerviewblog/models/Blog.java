package com.example.asifkhan.androidrecyclerviewblog.models;

public class Blog {
    private String title,author;
    private int likes,comments,shares,photo;

    public Blog(String title, String author, int likes, int comments, int shares, int photo) {
        this.title = title;
        this.author = author;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public int getShares() {
        return shares;
    }

    public int getPhoto() {
        return photo;
    }
}
