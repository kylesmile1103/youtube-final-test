package com.finaltest.youtube;

public class Video {
    private String title;
    private double id;

    public Video(double id, String title) {
        this.id = id;
        this.title = title;
    }

    public double getId() {
        return this.id;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
