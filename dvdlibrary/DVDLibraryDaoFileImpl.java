package com.company.dvdlibrary;

import java.io.*;
import java.util.*;

/**
 * This class provides the implementations for the methods defined
 * in the DVDLibraryDao interface.
 */

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    // Create the constant delimiter for reading files
    public static final String DELIMITER = "\\,";

    // Create the library HashMap which will store DVD objects with the title as the key
    private Map<String, DVD> library = new HashMap<>();

    // Add a DVD to the library
    @Override
    public DVD addDVD(String dvdTitle, DVD dvd) throws IOException {
        loadDVD();
        DVD newDVD = library.put(dvdTitle, dvd);
        saveDVD();
        return newDVD;
    }

    // Remove a DVD from the library
    @Override
    public DVD removeDVD(String dvdTitle) throws IOException {
        loadDVD();
        DVD removedDVD = library.remove(dvdTitle);
        saveDVD();
        return removedDVD;
    }

    // Edit an existing DVD
    @Override
    public DVD editDVD(String dvdTitle, DVD dvd) throws IOException {
        loadDVD();
        DVD editedDVD = library.put(dvdTitle, dvd);
        saveDVD();
        return editedDVD;
    }

    // Get a list of DVDs
    @Override
    public List<DVD> getDVDs() throws IOException {
        loadDVD();
        return new ArrayList<DVD>(library.values());
    }

    // Display the information for a DVD
    @Override
    public DVD displayDVD(String dvdTitle) throws IOException {
        loadDVD();
        DVD displayedDVD = library.get(dvdTitle);
        return displayedDVD;
    }

    // Search the library for a DVD title
    @Override
    public DVD searchDVD(String dvdTitle) throws IOException {
        loadDVD();
        DVD searchedDVD = library.get(dvdTitle);
        return searchedDVD;
    }

    private DVD unmarshallDVD (String DVDAsText) {
        String[] dvdProperties;
        DVD DVDFromFile;
        // Split string into array
        dvdProperties = DVDAsText.split(DELIMITER);
        // Get DVD title from array
        String dvdTitle = dvdProperties[0];
        // Create DVD object
        DVDFromFile = new DVD(dvdTitle);
        // Set each property of the DVD object
        DVDFromFile.setReleaseDate(dvdProperties[1]);
        DVDFromFile.setRating(dvdProperties[2]);
        DVDFromFile.setDirector(dvdProperties[3]);
        DVDFromFile.setStudio(dvdProperties[4]);
        DVDFromFile.setUserNotes(dvdProperties[5]);
        return DVDFromFile;
    }
    // Read from DVDlibrary file
    @Override
    public void loadDVD() throws IOException {
        // Initialise Scanner object
        Scanner scanner = null;
        try {
            // Create BufferedReader for reading the file
            scanner = new Scanner(new BufferedReader(
                    new FileReader("DVDLibrary/DVDlibrary.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        // Declare the currentLine variable and dvdProperties array
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // Unmarshall line into a DVD
            currentDVD = unmarshallDVD(currentLine);
            // Add the DVD object to the library
            library.put(currentDVD.getDvdTitle(), currentDVD);
        }
        // close reader
        scanner.close();
    }

    // Write to DVDlibrary file
    @Override
    public void saveDVD() throws IOException {
        // Declare PrintWriter variable
        PrintWriter out = null;
        try {
            // Use PrintWriter to open file
            out = new PrintWriter(new FileWriter("DVDLibrary/DVDlibrary.txt"));
        } catch (IOException e) {
            System.out.println("Could not save DVD data");
        }
        // Declare String variable
        String DVDAsText;
        // Get list of DVD objects
        List<DVD> DVDList = this.getDVDs();
        for (DVD dvd : DVDList) {
            // Get DVD properties one by one and add each property to a
            // String with the delimiter ","
            DVDAsText = (dvd.getDvdTitle() + DELIMITER);
            DVDAsText += (dvd.getReleaseDate() + DELIMITER);
            DVDAsText += (dvd.getRating() + DELIMITER);
            DVDAsText += (dvd.getDirector() + DELIMITER);
            DVDAsText += (dvd.getStudio() + DELIMITER);
            DVDAsText += (dvd.getUserNotes());
            out.println(DVDAsText);
            // Force buffered data to be written to file
            out.flush();
        }
        // Close file
        out.close();
    }
}
