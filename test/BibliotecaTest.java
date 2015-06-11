import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.view.ConsoleInputOutput;
import com.twu.biblioteca.view.Messages;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

public class BibliotecaTest {
    @Mock
    private ConsoleInputOutput consoleInputOutput;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void welcomeMessageShouldBeDisplayed() {
        Biblioteca biblioteca = new Biblioteca(consoleInputOutput);

        biblioteca.start();

        verify(consoleInputOutput).displayOutputToUser(Messages.WELCOME_MESSAGE);
    }
}
