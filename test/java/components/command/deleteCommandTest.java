package components.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.Test;

public class deleteCommandTest {
    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute2() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("delete-title ", deleteCommand.titleName);
        assertEquals("delete-title ", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute3() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("delete-title ", deleteCommand.titleName);
        assertEquals("delete-title ", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute4() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.title = "delete-title ";
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("delete-title ", deleteCommand.titleName);
        assertEquals("delete-title ", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute5() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("delete-title ", deleteCommand.titleName);
        assertEquals("delete-title ", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute6() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.title = "delete-title ";
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertTrue(label.items.get(0).sons.isEmpty());
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute7() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.title = "delete-title ";
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.visited = 1;
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = new ArrayList<>();
        item1.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertEquals(1, label.items.size());
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute8() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.title = "delete-title ";
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.visited = 1;
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = new ArrayList<>();
        item1.visited = 1;
        Item item2 = new Item();
        item2.title = "Dr";
        item2.bookmarkName = "delete-title ";
        item2.hyperlink = "delete-title ";
        item2.sons = new ArrayList<>();
        item2.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item2);
        itemList.add(item1);
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertEquals(2, label.items.size());
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    public void testExecute9() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "delete-title ";
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        deleteCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("delete-title ", deleteCommand.titleName);
        assertEquals("delete-title ", deleteCommand.cmdName);
    }
}

