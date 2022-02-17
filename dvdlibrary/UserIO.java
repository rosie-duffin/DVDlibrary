package com.company.dvdlibrary;

/**
 * This interface contains the abstract methods that deal with reading user input
 * and printing output.
 */

public interface UserIO {

    // Print string to console
    void print(String msg);
    // Read string from user
    String readString(String prompt);
    // Read int from user
    int readInt(String prompt);

}
