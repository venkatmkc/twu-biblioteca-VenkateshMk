import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.model.MainMenu;
import com.twu.biblioteca.view.ConsoleInputOutput;
import com.twu.biblioteca.view.Messages;
import org.junit.*;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class BibliotecaTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Mock
    private MainMenu mainMenu;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void welcomeMessageShouldBeDisplayed() {
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu);

        biblioteca.start();

        verify(consoleInputOutput).displayOutputToUser(Messages.WELCOME_MESSAGE);
    }

    @Test
    public void mainMenuShouldBeDispatched() {
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput, mainMenu);

        biblioteca.start();
        
        verify(mainMenu).dispatch();
    }
}
