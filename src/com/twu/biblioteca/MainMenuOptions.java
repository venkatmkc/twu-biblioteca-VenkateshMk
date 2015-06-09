package com.twu.biblioteca;

import java.util.HashMap;

public class MainMenuOptions {
    private HashMap<String, MainMenuAction> mainMenuOptionsMap;
    
    public MainMenuOptions(HashMap<String, MainMenuAction> mainMenuOptionsMap) {
        this.mainMenuOptionsMap = mainMenuOptionsMap;    
    }


    public MainMenuAction selectOption(String option) {
        return mainMenuOptionsMap.get(option);
    }
}
