package com.company.dvdlibrary;

import java.io.IOException;
import java.util.List;

/**
 * This interface contains the abstract methods for each action
 * the user may want to perform.
 */

public interface DVDLibraryDao {

    // Add a DVD to the library
    DVD addDVD(String dvdTitle, DVD newDVD) throws IOException;
    // Remove a DVD from the library
    DVD removeDVD(String dvdTitle) throws IOException;
    // Edit an existing DVD
    DVD editDVD(String dvdTitle, DVD newTitle) throws IOException;
    // List all DVDs in library
    List<DVD> getDVDs() throws IOException;
    // Display DVD details
    DVD displayDVD(String dvdTitle) throws IOException;
    // Searches for a title
    DVD searchDVD(String searchTitle) throws IOException;
    // Load from file
    void loadDVD() throws IOException;
    // Save to file
    void saveDVD() throws IOException;

}
