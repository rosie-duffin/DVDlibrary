package com.company.dvdlibrary;

import java.io.IOException;
import java.util.List;

/**
 * This is the controller class - it provides the methods for running the menu
 * and methods that call the display methods from DVDLibraryView and action methods
 * from DVDLibraryDaoImpl.
 */

public class DVDLibraryController {

    // Declare dao object and view object
    private DVDLibraryDao dao;
    private DVDLibraryView view;

    // Constructor that takes dao and view objects as parameters
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    // run method displays menu options and points to relevant methods
    public void run() throws IOException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();
            // switch statement to choose relevant method for user choice
            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    deleteDVD();
                    break;
                case 3:
                    changeDVD();
                    break;
                case 4:
                    listOfDVDs();
                    break;
                case 5:
                    showDVDInfo();
                    break;
                case 6:
                    findDVD();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 8:
                    saveToFile();
                    break;
                case 9:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    // Gets user menu choice (int)
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    // Calls methods to display banners and add a new DVD
    private void createDVD() throws IOException {
        view.displayAddDVDBanner();
        DVD newDVD = view.getDVDInfo();
        dao.addDVD(newDVD.getDvdTitle(), newDVD);
        view.displayAddSuccessBanner();
    }

    // Calls methods to display banners, remove a DVD and display the removed result
    private void deleteDVD() throws IOException {
        view.displayRemoveDVDBanner();
        String DVDToRemove = view.getDVD();
        DVD removedDVD = dao.removeDVD(DVDToRemove);
        view.displayRemoveResult(removedDVD);
    }

    // Calls methods to display banners and edit DVD properties
    private void changeDVD() throws IOException {
        view.displayEditDVDBanner();
        DVD editedDVD = view.editDVDInfo();
        dao.editDVD(editedDVD.getDvdTitle(), editedDVD);
        view.displayEditDVDSuccessBanner();
    }

    // Calls methods to display banners, get a DVD list and display it
    private void listOfDVDs() throws IOException {
        view.displayListAllBanner();
        List<DVD> dvdList = dao.getDVDs();
        view.displayDVDList(dvdList);
    }

    // Calls methods to display banners, get DVD properties and display them
    private void showDVDInfo() throws IOException {
        view.displayDVDInfoBanner();
        String showDVD = view.getDVD();
        DVD dvd = dao.displayDVD(showDVD);
        view.displayDVDInfo(dvd);
    }

    // Calls methods to display banners, search for a DVD and display result
    private void findDVD() throws IOException {
        view.displaySearchDVDBanner();
        String searchDVD = view.getDVD();
        DVD dvd = dao.searchDVD(searchDVD);
        view.displaySearchDVDResult(dvd);
    }

    // Calls method to display banners and load a file
    private void loadFromFile() throws IOException {
        view.displayLoadDVDBanner();
        dao.loadDVD();
        view.displayLoadDVDSuccessBanner();
    }

    // Calls method to display banners and save to a file
    private void saveToFile() throws IOException {
        view.displaySaveDVDBanner();
        dao.saveDVD();
        view.displaySaveDVDSuccessBanner();
    }

    // Display a banner when there is an unknown command (incorrect choice for menu options)
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    // Display a banner when exiting the menu
    private void exitMessage() {
        view.displayExitBanner();
    }

}
