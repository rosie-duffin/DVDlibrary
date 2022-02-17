package com.company.dvdlibrary;

/**
 * This is the data transfer object (DTO). It contains all the properties of DVDs,
 * along with getters/setters for each property. It also contains a constructor
 * with the title parameter.
 */

public class DVD {
    // Declare DVD object properties
    private String dvdTitle; //Title
    private String releaseDate; //Release date
    private String rating; //Rating
    private String director; //Director's name
    private String studio; //Studio
    private String userNotes; //User rating or note

    // Constructor with title parameter
    public DVD(String title) {
        this.dvdTitle = title;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }

    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }
}
