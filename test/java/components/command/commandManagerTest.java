package components.command;

import static org.junit.Assert.assertEquals;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class commandManagerTest {
    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecuteCommand() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //       at java.util.Objects.checkIndex(Objects.java:372)
        //       at java.util.ArrayList.get(ArrayList.java:459)
        //       at components.command.saveCommand.execute(saveCommand.java:57)
        //       at components.command.commandManager.executeCommand(commandManager.java:35)
        //   In order to prevent executeCommand(Command, Label)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   executeCommand(Command, Label).
        //   See https://diff.blue/R013 to resolve this issue.

        saveCommand command = new saveCommand();
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(command, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    public void testExecuteCommand2() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by executeCommand(Command, Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        addCommand command = new addCommand(new String[]{"List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(command, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    public void testExecuteCommand3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by executeCommand(Command, Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        deleteCommand command = new deleteCommand(new String[]{"List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(command, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecuteCommand4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at components.command.commandManager.executeCommand(commandManager.java:37)
        //   In order to prevent executeCommand(Command, Label)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   executeCommand(Command, Label).
        //   See https://diff.blue/R013 to resolve this issue.

        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(null, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecuteCommand5() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file '\directory\foo.txt', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        saveCommand command = new saveCommand();
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(command, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    public void testExecuteCommand6() {
        readCommand readCommand = new readCommand(new String[]{"add-title "});
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(readCommand, label);
        assertEquals("add-title ", readCommand.cmdName);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecuteCommand7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //       at java.util.Objects.checkIndex(Objects.java:372)
        //       at java.util.ArrayList.get(ArrayList.java:459)
        //       at components.command.saveCommand.execute(saveCommand.java:57)
        //       at components.command.commandManager.executeCommand(commandManager.java:35)
        //   In order to prevent executeCommand(Command, Label)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   executeCommand(Command, Label).
        //   See https://diff.blue/R013 to resolve this issue.

        saveCommand command = new saveCommand();
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(command, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    public void testExecuteCommand8() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by executeCommand(Command, Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        addCommand command = new addCommand(new String[]{"List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(command, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    public void testExecuteCommand9() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by executeCommand(Command, Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        deleteCommand command = new deleteCommand(new String[]{"List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(command, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecuteCommand10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at components.command.commandManager.executeCommand(commandManager.java:37)
        //   In order to prevent executeCommand(Command, Label)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   executeCommand(Command, Label).
        //   See https://diff.blue/R013 to resolve this issue.

        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(null, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecuteCommand11() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file '\directory\foo.txt', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        saveCommand command = new saveCommand();
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(command, label);
    }

    /**
     * Method under test: {@link commandManager#executeCommand(Command, Label)}
     */
    @Test
    public void testExecuteCommand12() {
        readCommand readCommand = new readCommand(new String[]{"add-title "});
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        commandManager.executeCommand(readCommand, label);
        assertEquals("add-title ", readCommand.cmdName);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
    }

    /**
     * Method under test: {@link commandManager#undo()}
     */
    @Test
    public void testUndo() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        commandManager.undo();
    }

    /**
     * Method under test: {@link commandManager#undo()}
     */
    @Test
    public void testUndo2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        commandManager.undo();
    }

    /**
     * Method under test: {@link commandManager#undo()}
     */
    @Test
    public void testUndo3() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        commandManager.undo();
    }

    /**
     * Method under test: {@link commandManager#redo()}
     */
    @Test
    public void testRedo() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        commandManager.redo();
    }

    /**
     * Method under test: {@link commandManager#redo()}
     */
    @Test
    public void testRedo2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        commandManager.redo();
    }
}

