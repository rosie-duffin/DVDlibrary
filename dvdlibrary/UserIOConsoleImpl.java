package com.company.dvdlibrary;

import java.util.Scanner;

/**
 * This class implements the methods from the UserIO interface
 * that deal with reading user input and printing output.
 */

public class UserIOConsoleImpl implements UserIO {

    // Create Scanner object
    final private Scanner console = new Scanner(System.in);

    // Print to console
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    // Read String from console
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        console.nextLine();
        return console.nextLine();
    }

    // Read int from console
    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return console.nextInt();
    }

}
