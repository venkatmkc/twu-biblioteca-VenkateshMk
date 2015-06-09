package com.twu.biblioteca.model;

import java.util.*;

public class MainMenuOptions {
    private HashMap<String, MainMenuAction> mainMenuOptionsMap;

    public MainMenuOptions(HashMap<String, MainMenuAction> mainMenuOptionsMap) {
        this.mainMenuOptionsMap = mainMenuOptionsMap;
    }


    public MainMenuAction selectOption(String option) {
        return mainMenuOptionsMap.get(option);
    }

    @Override
    public String toString() {
        String formattedOptionsList = new String();
        Set options = mainMenuOptionsMap.keySet();
        Iterator<String> optionsIterator = options.iterator();
        while (optionsIterator.hasNext()) {
            formattedOptionsList += optionsIterator.next() + "\n";
        }
        return formattedOptionsList;
    }
}
