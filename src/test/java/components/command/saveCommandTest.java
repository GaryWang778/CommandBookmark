package components.command;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import dataStructure.Item;
import dataStructure.Label;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class saveCommandTest {
    /**
     * Method under test: {@link saveCommand#find_title(Label, String)}
     */
    @Test
    void testFind_title() {
        saveCommand saveCommand = new saveCommand();
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        assertNull(saveCommand.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link saveCommand#find_title(Label, String)}
     */
    @Test
    void testFind_title2() {
        saveCommand saveCommand = new saveCommand();
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
        assertSame(item, saveCommand.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link saveCommand#find_title(Label, String)}
     */
    @Test
    void testFind_title3() {
        saveCommand saveCommand = new saveCommand();
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "foo";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        assertNull(saveCommand.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link saveCommand#inputItem(Label, FileWriter, Item, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInputItem() throws IOException {

        saveCommand saveCommand = new saveCommand();
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        saveCommand.inputItem(label, null, item, 1);
    }

    /**
     * Method under test: {@link saveCommand#inputItem(Label, FileWriter, Item, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInputItem2() throws IOException {
        saveCommand saveCommand = new saveCommand();
        Item item = new Item();
        item.bookmarkName = "#";
        item.hyperlink = "#";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;
        saveCommand.inputItem(label, null, item1, 1);
    }

    /**
     * Method under test: {@link saveCommand#execute(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute() {

        saveCommand saveCommand = new saveCommand();
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        saveCommand.execute(label);
    }

    /**
     * Method under test: {@link saveCommand#execute(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute2() {

        saveCommand saveCommand = new saveCommand();
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
        saveCommand.execute(label);
    }
}

