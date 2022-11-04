package components.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class visionTest {
    @Test
    public void testConstructor() {
        assertEquals("Cmd Name", (new vision("Cmd Name")).cmdName);
    }

    @Test
    public void testExecute() {
        vision vision = new vision("show-tree");
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        Item item1 = new Item();
        item1.bookmarkName = "ls-tree";
        item1.hyperlink = "ls-tree";
        item1.sons = new ArrayList<>();
        item1.title = "foo";
        item1.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item);
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList;
        item2.title = "Dr";
        item2.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item2);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList1;
        vision.execute(label);
    }


    @Test
    public void testLs_tree() {
        vision vision = new vision("Cmd Name");
        Item item = new Item();
        item.bookmarkName = "-";
        item.hyperlink = "-";
        item.sons = new ArrayList<>();
        item.title = "root";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        Item item1 = new Item();
        item1.bookmarkName = "Dr";
        item1.hyperlink = "Dr";
        item1.sons = new ArrayList<>();
        item1.title = "son";
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList.add(item);
        itemList1.add(item1);
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "father";
        item2.visited = 1;
        itemList.add(item2);
        vision.ls_tree(label, item2, 1);
    }


    @Test
    public void testShow_tree() {
        vision vision = new vision("Cmd Name");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        vision.show_tree(label, item, 1);
    }



    @Test
    public void testShow_tree2() {
        vision vision = new vision("Cmd Name");
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
        item1.bookmarkName = "son's bookmarkname";
        item1.hyperlink = "son's hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "sons";
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "father";
        item2.visited = 1;
        itemList.add(item1);
        itemList.add(item2);
        vision.show_tree(label, item2, 1);
    }
}
