package com.twu.biblioteca.mainmenu.options;

import com.twu.biblioteca.io.ConsoleInputOutput;
import com.twu.biblioteca.user.User;

public class UserInformationOption implements MainMenuAction{
    private ConsoleInputOutput consoleInputOutput;

    public UserInformationOption(ConsoleInputOutput consoleInputOutput) {
        this.consoleInputOutput = consoleInputOutput;
    }


    @Override
    public void obtainOptionResult(User user) {
        String userInformation = user.userInformation();
        consoleInputOutput.displayOutputToUser(userInformation);
    }
}
