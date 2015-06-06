package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {
    private ArrayList<String> bookList;

    public Books(ArrayList<String> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        String formattedString = new String();
        for (String book : bookList) {
            formattedString += book + "\n";
        }
        return formattedString;
    }
}
