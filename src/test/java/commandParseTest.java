import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class commandParseTest {
    /**
     * Method under test: {@link commandParse#commandParse(String)}
     */
    @Test
    void testConstructor() {
        assertEquals("Commandline", (new commandParse("Commandline")).commandline);
    }

    /**
     * Method under test: {@link commandParse#split(String)}
     */
    @Test
    void testSplit() {
        String[] actualSplitResult = (new commandParse("Commandline")).split("Commandline");
        assertEquals(1, actualSplitResult.length);
        assertEquals("Commandline", actualSplitResult[0]);
    }

    /**
     * Method under test: {@link commandParse#splitopencommand(String)}
     */
    @Test
    void testSplitopencommand() {
        String[] actualSplitopencommandResult = (new commandParse("Commandline")).splitopencommand("Commandline");
        assertEquals(1, actualSplitopencommandResult.length);
        assertEquals("Commandline", actualSplitopencommandResult[0]);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    void testComParser() {
        commandParse commandParse = new commandParse("Commandline");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("Commandline", commandParse.commandline);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    void testComParser2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        commandParse commandParse = new commandParse("add");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    void testComParser3() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        commandParse commandParse = new commandParse("delete");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testComParser4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        //       at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //       at java.util.ArrayList.get(ArrayList.java:435)
        //       at components.command.saveCommand.execute(saveCommand.java:57)
        //       at components.command.commandManager.executeCommand(commandManager.java:35)
        //       at commandParse.comParser(commandParse.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        commandParse commandParse = new commandParse("save");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    void testComParser5() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        commandParse commandParse = new commandParse("undo");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    void testComParser6() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        commandParse commandParse = new commandParse("redo");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testComParser7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        //       at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //       at java.util.ArrayList.get(ArrayList.java:435)
        //       at components.command.vision.execute(vision.java:27)
        //       at components.command.commandManager.executeCommand(commandManager.java:37)
        //       at commandParse.comParser(commandParse.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        commandParse commandParse = new commandParse("tree");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    void testComParser8() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        commandParse commandParse = new commandParse("read");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testComParser9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 1
        //       at components.command.openCommand.<init>(openCommand.java:18)
        //       at commandParse.comParser(commandParse.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        commandParse commandParse = new commandParse("open");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    void testComParser10() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        commandParse commandParse = new commandParse("tree");
        Item item = new Item();
        item.bookmarkName = "add";
        item.hyperlink = "add";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        commandParse.comParser(label);
    }

    /**
     * Method under test: {@link commandParse#comParser(Label)}
     */
    @Test
    void testComParser11() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        commandParse commandParse = new commandParse("read");
        Item item = new Item();
        item.bookmarkName = "add";
        item.hyperlink = "add";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        commandParse.comParser(label);
    }
}

