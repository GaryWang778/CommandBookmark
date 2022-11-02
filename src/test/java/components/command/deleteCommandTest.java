package components.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class deleteCommandTest {
    /**
     * Method under test: {@link deleteCommand#deleteCommand(String[])}
     */
    @Test
    void testConstructor() {
        assertEquals("List", (new deleteCommand(new String[]{"List"})).cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#deleteCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor2() {

        new deleteCommand(new String[]{"delete-title "});
    }

    /**
     * Method under test: {@link deleteCommand#deleteCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor3() {

        new deleteCommand(new String[]{"delete-bookmark "});
    }

    /**
     * Method under test: {@link deleteCommand#deleteCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor4() {

        new deleteCommand(new String[]{});
    }

    /**
     * Method under test: {@link deleteCommand#deleteCommand(String[])}
     */
    @Test
    void testConstructor5() {
        deleteCommand actualDeleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        assertEquals("delete-title ", actualDeleteCommand.titleName);
        assertEquals("delete-title ", actualDeleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#find_title(Label, String)}
     */
    @Test
    void testFind_title() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        assertNull(deleteCommand.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link deleteCommand#find_title(Label, String)}
     */
    @Test
    void testFind_title2() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
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
        assertSame(item, deleteCommand.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link deleteCommand#find_title(Label, String)}
     */
    @Test
    void testFind_title3() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
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
        assertNull(deleteCommand.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link deleteCommand#find_bookmark(Label, String)}
     */
    @Test
    void testFind_bookmark() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        assertNull(deleteCommand.find_bookmark(label, "Bookmark Name"));
    }

    /**
     * Method under test: {@link deleteCommand#find_bookmark(Label, String)}
     */
    @Test
    void testFind_bookmark2() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
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
        assertSame(item, deleteCommand.find_bookmark(label, "Bookmark Name"));
    }

    /**
     * Method under test: {@link deleteCommand#find_bookmark(Label, String)}
     */
    @Test
    void testFind_bookmark3() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Item item = new Item();
        item.bookmarkName = "foo";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        assertNull(deleteCommand.find_bookmark(label, "Bookmark Name"));
    }

    /**
     * Method under test: {@link deleteCommand#adjust_sons(Label, String)}
     */
    @Test
    void testAdjust_sons() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        deleteCommand.adjust_sons(label, "Dr");
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#adjust_sons(Label, String)}
     */
    @Test
    void testAdjust_sons2() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
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
        deleteCommand.adjust_sons(label, "Dr");
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#adjust_sons(Label, String)}
     */
    @Test
    void testAdjust_sons3() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.title = "Dr";
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList1;
        deleteCommand.adjust_sons(label, "Dr");
        assertTrue(label.items.get(0).sons.isEmpty());
    }

    /**
     * Method under test: {@link deleteCommand#adjust_sons(Label, String)}
     */
    @Test
    void testAdjust_sons4() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "foo";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.title = "Dr";
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList1;
        deleteCommand.adjust_sons(label, "Dr");
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#delete_item(Label, Item)}
     */
    @Test
    void testDelete_item() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        deleteCommand.delete_item(label, item);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("Bookmark Name", item.bookmarkName);
        assertEquals(1, item.visited);
        assertEquals("Dr", item.title);
        assertTrue(item.sons.isEmpty());
        assertEquals("Hyperlink", item.hyperlink);
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#delete_item(Label, Item)}
     */
    @Test
    void testDelete_item2() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
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
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;
        deleteCommand.delete_item(label, item1);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("Bookmark Name", item1.bookmarkName);
        assertEquals(1, item1.visited);
        assertEquals("Dr", item1.title);
        assertTrue(item1.sons.isEmpty());
        assertEquals("Hyperlink", item1.hyperlink);
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#delete_item(Label, Item)}
     */
    @Test
    void testDelete_item3() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = new ArrayList<>();
        item2.title = "Dr";
        item2.visited = 1;
        deleteCommand.delete_item(label, item2);
        assertEquals(1, label.items.size());
    }

    /**
     * Method under test: {@link deleteCommand#delete_item(Label, Item)}
     */
    @Test
    void testDelete_item4() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
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
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "Dr";
        item2.visited = 1;
        deleteCommand.delete_item(label, item2);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("Bookmark Name", item2.bookmarkName);
        assertEquals(1, item2.visited);
        assertEquals("Dr", item2.title);
        assertEquals(1, item2.sons.size());
        assertEquals("Hyperlink", item2.hyperlink);
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#delete_item(Label, Item)}
     */
    @Test
    void testDelete_item5() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "foo";
        item.visited = 1;
        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = new ArrayList<>();
        item2.title = "Dr";
        item2.visited = 1;
        deleteCommand.delete_item(label, item2);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(2, label.items.size());
        assertEquals("Bookmark Name", item2.bookmarkName);
        assertEquals(1, item2.visited);
        assertEquals("Dr", item2.title);
        assertTrue(item2.sons.isEmpty());
        assertEquals("Hyperlink", item2.hyperlink);
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#delete_item(Label, Item)}
     */
    @Test
    void testDelete_item6() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
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
        deleteCommand.delete_item(label, null);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    void testExecute() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        deleteCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("List", deleteCommand.cmdName);
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    void testExecute2() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
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
    void testExecute3() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
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
    void testExecute4() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.title = "delete-title ";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
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
    void testExecute5() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = itemList;
        item1.title = "Dr";
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList1;
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
    void testExecute6() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.title = "delete-title ";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = itemList;
        item1.title = "Dr";
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList1;
        deleteCommand.execute(label);
        assertTrue(label.items.get(0).sons.isEmpty());
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    void testExecute7() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.title = "delete-title ";
        item.visited = 1;
        Item item1 = new Item();
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        deleteCommand.execute(label);
        assertEquals(1, label.items.size());
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    void testExecute8() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.title = "delete-title ";
        item.visited = 1;
        Item item1 = new Item();
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;
        Item item2 = new Item();
        item2.bookmarkName = "delete-title ";
        item2.hyperlink = "delete-title ";
        item2.sons = new ArrayList<>();
        item2.title = "Dr";
        item2.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item2);
        itemList.add(item1);
        itemList.add(item);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList;
        deleteCommand.execute(label);
        assertEquals(2, label.items.size());
    }

    /**
     * Method under test: {@link deleteCommand#execute(Label)}
     */
    @Test
    void testExecute9() {
        deleteCommand deleteCommand = new deleteCommand(new String[]{"delete-title ", "delete-title "});
        Item item = new Item();
        item.bookmarkName = "delete-title ";
        item.hyperlink = "delete-title ";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.bookmarkName = "delete-title ";
        item1.hyperlink = "delete-title ";
        item1.sons = itemList;
        item1.title = "delete-title ";
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList1;
        deleteCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("delete-title ", deleteCommand.titleName);
        assertEquals("delete-title ", deleteCommand.cmdName);
    }
}

