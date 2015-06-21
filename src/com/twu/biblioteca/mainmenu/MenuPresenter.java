package com.twu.biblioteca.mainmenu;

import java.util.*;

public class MenuPresenter {
    private String formattedOptionsList;

    public MenuPresenter(String formattedOptionsList) {
        this.formattedOptionsList = formattedOptionsList;
    }

    @Override
    public String toString() {
        return formattedOptionsList;
    }

    public void addMenu(Set<String> options) {
        int optionNumber = 1;
        Iterator<String> optionsIterator = options.iterator();
        while (optionsIterator.hasNext()) {
            formattedOptionsList += optionNumber + ". " + optionsIterator.next() + "\n";
            optionNumber++;
        }
    }

    public void flush() {
        formattedOptionsList = "";
    }
}
