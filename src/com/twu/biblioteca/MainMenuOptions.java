package com.twu.biblioteca;

import java.util.*;

public class MainMenuOptions {
    private ArrayList<String> mainMenuOptionsList;

    public MainMenuOptions(ArrayList<String> mainMenuOptionsList) {
        this.mainMenuOptionsList = mainMenuOptionsList;
    }

    @Override
    public String toString() {
        String formattedOptionsList = new String();
        int optionNumber = 1;
        Iterator<String> optionsIterator = mainMenuOptionsList.iterator();
        while (optionsIterator.hasNext()) {
            formattedOptionsList += optionNumber + ". " + optionsIterator.next() + "\n";
            optionNumber++;
        }
        return formattedOptionsList;
    }
}
