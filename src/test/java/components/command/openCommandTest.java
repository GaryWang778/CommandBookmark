package components.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dataStructure.Label;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class openCommandTest {
    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor() {

        openCommand actualOpenCommand = new openCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualOpenCommand.execute(label);
    }

    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor2() {

        openCommand actualOpenCommand = new openCommand(new String[]{"foo"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualOpenCommand.execute(label);
    }

    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    void testConstructor3() {
        openCommand actualOpenCommand = new openCommand(new String[]{"List", "List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualOpenCommand.execute(label);
        assertEquals("List", label.filepath);
    }

    /**
     * Method under test: {@link openCommand#execute(Label)}
     */
    @Test
    void testExecute() {
        openCommand openCommand = new openCommand(new String[]{"List", "List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        openCommand.execute(label);
        assertEquals("List", label.filepath);
    }
}

