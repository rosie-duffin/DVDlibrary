package com.company.dvdlibrary;

import java.io.IOException;

/**
 * The main class is the runner class, it instantiates the objects
 * of the other classes and calls the method to run the menu from
 * the controller.
 */

/*
This project was created using https://academy.engagelms.com/mod/book/view.php?id=60172 as a template.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        // Instantiate objects for each class and call the run method
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
