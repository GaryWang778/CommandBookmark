package components.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class readCommandTest {
    /**
     * Method under test: {@link readCommand#readCommand(String[])}
     */
    @Test
    void testConstructor() {
        readCommand actualReadCommand = new readCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualReadCommand.execute(label);
        assertEquals("List", actualReadCommand.cmdName);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
    }

    /**
     * Method under test: {@link readCommand#readCommand(String[])}
     */
    @Test
    void testConstructor2() {
        readCommand actualReadCommand = new readCommand(new String[]{"List"});
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        actualReadCommand.execute(label);
        assertEquals("List", actualReadCommand.cmdName);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
    }

    /**
     * Method under test: {@link readCommand#readCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor3() {

        readCommand actualReadCommand = new readCommand(new String[]{"read-bookmark "});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        ArrayList<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        itemList.add(2, item);
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;
        itemList.add(item1);
        label.items = itemList;
        actualReadCommand.execute(label);
    }

    /**
     * Method under test: {@link readCommand#readCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor4() {

        readCommand actualReadCommand = new readCommand(new String[]{});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        ArrayList<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        itemList.add(2, item);
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;
        itemList.add(item1);
        label.items = itemList;
        actualReadCommand.execute(label);
    }

    /**
     * Method under test: {@link readCommand#execute(Label)}
     */
    @Test
    void testExecute() {
        readCommand readCommand = new readCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        readCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("List", readCommand.cmdName);
    }

    /**
     * Method under test: {@link readCommand#execute(Label)}
     */
    @Test
    void testExecute2() {
        readCommand readCommand = new readCommand(new String[]{"List"});
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        readCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("List", readCommand.cmdName);
    }
}

