package com.example.movieapp;

public class Movie {

  private   String image;
   private String Title;

   private String videoURL;


    public Movie(String image, String title, String videoURL) {
        this.image = image;
        Title = title;
        this.videoURL = videoURL;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
