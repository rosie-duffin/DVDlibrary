package com.company.dvdlibrary;

import java.util.List;

/**
 * This is the view class - it is the only class that the user
 * can directly interact with. It contains the menu method and
 * the getDVDInfo method, as well as methods to display banners
 * so that the user knows their chosen action has been performed.
 */

public class DVDLibraryView {

    // Declare private UserIO object
    private UserIO io;

    // Initialise User IO object
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    // Method to print menu to console and get user selection
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. Get DVD list");
        io.print("5. Get DVD information");
        io.print("6. Search DVD library");
        io.print("7. Load DVD library from file");
        io.print("8. Save DVD library to file");
        io.print("9. Exit");

        return io.readInt("Please select from the above choices.");
    }

    // Get DVD properties from user and set to current DVD object
    public DVD getDVDInfo() {
        String dvdTitle = io.readString("Enter DVD title");
        String releaseDate = io.readString("Enter release date");
        String rating = io.readString("Enter DVD rating (e.g. 12A)");
        String director = io.readString("Enter director's name");
        String studio = io.readString("Enter producing studio e.g. Warner Bros");
        String userNotes = io.readString("Enter any personal notes");
        DVD currentDVD = new DVD(dvdTitle);
        currentDVD.setDvdTitle(dvdTitle);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setRating(rating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNotes(userNotes);
        return currentDVD;
    }

    // Banner to display to user
    public void displayAddDVDBanner() {
        io.print("=== Add DVD ===");
    }

    // Banner to display to user
    public void displayAddSuccessBanner() {
        io.readString("DVD successfully added to library! Hit enter to continue");
    }

    // Banner to display to user
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    // Banner to display to user
    public void displayRemoveResult(DVD removedDVD) {
        if (removedDVD != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    // Asks user for DVD title
    public String getDVD() {
        return io.readString("Enter DVD title");
    }

    // Banner to display to user
    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    // Get edited DVD properties from user and set to current DVD object
    public DVD editDVDInfo() {
        String dvdTitle = io.readString("Enter DVD title");
        String releaseDate = io.readString("Enter release date");
        String rating = io.readString("Enter DVD rating (e.g. 12A)");
        String director = io.readString("Enter director's name");
        String studio = io.readString("Enter producing studio e.g. Warner Bros");
        String userNotes = io.readString("Enter any personal notes");
        DVD currentDVD = new DVD(dvdTitle);
        currentDVD.setDvdTitle(dvdTitle);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setRating(rating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNotes(userNotes);
        return currentDVD;
    }

    // Banner to display to user
    public void displayEditDVDSuccessBanner() {
        io.readString("DVD successfully edited! Hit enter to continue");
    }

    // Banner to display to user
    public void displayListAllBanner() {
        io.print("=== List of DVDs ===");
    }

    // Displays a list of DVDs by iterating over the List
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getDvdTitle());
        }
        io.readString("Please hit enter to continue");
    }

    // Banner to display to user
    public void displayDVDInfoBanner() {
        io.print("=== DVD Details ===");
    }

    // Displays the DVD properties for the user
    public void displayDVDInfo(DVD dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getDvdTitle());
            io.print("Release date: " + dvd.getReleaseDate());
            io.print("Rating: " + dvd.getRating());
            io.print("Director: " + dvd.getDirector());
            io.print("Studio: " + dvd.getStudio());
            io.print("Notes: " + dvd.getUserNotes());
        } else {
            io.print("DVD not in library");
        }
        io.readString("Please hit enter to continue");
    }

    // Banner to display to user
    public void displaySearchDVDBanner() {
        io.print("=== Search for DVD ===");
    }

    // Searches for matching DVD object
    public void displaySearchDVDResult(DVD dvd) {
        if (dvd != null) {
            io.print("Found: " + dvd.getDvdTitle());
        } else {
            io.print("DVD not in library");
        }
        io.readString("Please hit enter to continue");
    }

    // Banner to display to user
    public void displayLoadDVDBanner() {
        io.print("=== Load DVD From File ===");
    }

    // Banner to display to user
    public void displayLoadDVDSuccessBanner() {
        io.print("=== Successfully loaded DVD from file! ===");
    }

    // Banner to display to user
    public void displaySaveDVDBanner() {
        io.print("=== Save DVD To File ===");
    }

    // Banner to display to user
    public void displaySaveDVDSuccessBanner() {
        io.print("=== Successfully saved DVD to file! ===");
    }

    // Banner to display to user
    public void displayUnknownCommandBanner() {
        io.print("Unknown command");
    }

    // Banner to display to user
    public void displayExitBanner() {
        io.print("Goodbye!");
    }

}
