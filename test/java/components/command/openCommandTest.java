package components.command;

import static org.junit.Assert.assertEquals;

import dataStructure.Label;

import java.util.ArrayList;

import org.junit.Ignore;

import org.junit.Test;

public class openCommandTest {
    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   In order to prevent <init>(String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   <init>(String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        openCommand actualOpenCommand = new openCommand(new String[]{"List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        actualOpenCommand.execute(label);
    }

    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   In order to prevent <init>(String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   <init>(String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        openCommand actualOpenCommand = new openCommand(new String[]{"foo"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        actualOpenCommand.execute(label);
    }

    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    public void testConstructor3() {
        openCommand actualOpenCommand = new openCommand(new String[]{"List", "List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        actualOpenCommand.execute(label);
        assertEquals("List", label.filepath);
    }

    /**
     * Method under test: {@link openCommand#execute(Label)}
     */
    @Test
    public void testExecute() {
        openCommand openCommand = new openCommand(new String[]{"List", "List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        openCommand.execute(label);
        assertEquals("List", label.filepath);
    }

    /**
     * Method under test: {@link openCommand#execute(Label)}
     */
    @Test
    public void testExecute2() {
        openCommand openCommand = new openCommand(new String[]{"List", "List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        openCommand.execute(label);
        assertEquals("List", label.filepath);
    }
}

