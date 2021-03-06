package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.library.Section;
import com.twu.biblioteca.item.ItemPresenter;
import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class ListCheckedOutItemsOption implements MainMenuAction {
    private ConsoleInputOutput consoleInputOutput;
    private Section section;

    public ListCheckedOutItemsOption(ConsoleInputOutput consoleInputOutput, Section section) {
        this.consoleInputOutput = consoleInputOutput;
        this.section = section;
    }

    @Override
    public void obtainOptionResult(User user) {
        ItemPresenter itemPresenter = new ItemPresenter("");
        consoleInputOutput.displayOutputToUser(section.checkedOutItems(itemPresenter));
    }
}
