/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthreell.dvdlibrary.dto;

/**
 * DTO is container for DVD data. The DAO and the DTO comprise the Model
 * All components (Model, View, and Controller) can use DTOs
 * @author lindseylogan
 */
public class Dvd {
    private String title;
    private String releaseDate;
    private String rating;
    private String directorName;
    private String studio;
    private String userRatingOrNote;
    
    public Dvd(String title) {      // do this bc title is how we identify dvd
        this.title = title;
    }

    public String getTitle() {       // read only file
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRatingOrNote() {
        return userRatingOrNote;
    }

    public void setUserRatingOrNote(String userRatingOrNote) {
        this.userRatingOrNote = userRatingOrNote;
    }
    
    
}
