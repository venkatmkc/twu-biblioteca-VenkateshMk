package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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
            formattedOptionsList += (String) optionsIterator.next() + "\n";
        }
        return formattedOptionsList;
    }
}
