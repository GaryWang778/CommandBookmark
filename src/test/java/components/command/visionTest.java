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

class visionTest {
    /**
     * Method under test: {@link vision#vision(String)}
     */
    @Test
    void testConstructor() {
        assertEquals("Cmd Name", (new vision("Cmd Name")).cmdName);
    }

    /**
     * Method under test: {@link vision#find_title(Label, String)}
     */
    @Test
    void testFind_title() {
        vision vision = new vision("Cmd Name");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        assertNull(vision.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link vision#find_title(Label, String)}
     */
    @Test
    void testFind_title2() {
        vision vision = new vision("Cmd Name");
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
        assertSame(item, vision.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link vision#find_title(Label, String)}
     */
    @Test
    void testFind_title3() {
        vision vision = new vision("Cmd Name");
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
        assertNull(vision.find_title(label, "Dr"));
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute() {

        vision vision = new vision("Cmd Name");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute2() {
        vision vision = new vision("Cmd Name");
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
        vision.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("Cmd Name", vision.cmdName);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute3() {
        vision vision = new vision("Cmd Name");
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
        vision.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("Cmd Name", vision.cmdName);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute4() {

        vision vision = new vision("ls-tree");
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
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute5() {

        vision vision = new vision("show-tree");
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
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute6() {

        vision vision = new vision("ls-tree");
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

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute7() {

        vision vision = new vision("ls-tree");
        Item item = new Item();
        item.bookmarkName = "ls-tree";
        item.hyperlink = "ls-tree";
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
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "Dr";
        item2.visited = 1;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList2;
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute8() {

        vision vision = new vision("ls-tree");
        Item item = new Item();
        item.bookmarkName = "ls-tree";
        item.hyperlink = "ls-tree";
        item.sons = new ArrayList<>();
        item.title = null;
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
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "Dr";
        item2.visited = 1;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList2;
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute9() {

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

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute10() {

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
        item1.title = "Dr";
        item1.visited = 0;

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

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute11() {

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.bookmarkName = null;
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
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    void testExecute12() {

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.bookmarkName = "ls-tree";
        item.hyperlink = "ls-tree";
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
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "Dr";
        item2.visited = 1;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList2;
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute13() {

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.bookmarkName = "ls-tree";
        item.hyperlink = "ls-tree";
        item.sons = new ArrayList<>();
        item.title = null;
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
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "Dr";
        item2.visited = 1;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = itemList2;
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute14() {

        vision vision = new vision(null);
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

    /**
     * Method under test: {@link vision#ls_tree(Label, Item, int)}
     */
    @Test
    void testLs_tree() {

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
        vision.ls_tree(label, item, 1);
    }

    /**
     * Method under test: {@link vision#ls_tree(Label, Item, int)}
     */
    @Test
    void testLs_tree2() {
        vision vision = new vision("Cmd Name");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        vision.ls_tree(label, null, 1);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("Cmd Name", vision.cmdName);
    }

    /**
     * Method under test: {@link vision#ls_tree(Label, Item, int)}
     */
    @Test
    void testLs_tree3() {

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
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;
        vision.ls_tree(label, item1, 1);
    }

    /**
     * Method under test: {@link vision#ls_tree(Label, Item, int)}
     */
    @Test
    void testLs_tree4() {

        vision vision = new vision("Cmd Name");
        Item item = new Item();
        item.bookmarkName = "#";
        item.hyperlink = "#";
        item.sons = new ArrayList<>();
        item.title = "#";
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
        vision.ls_tree(label, item1, 1);
    }

    /**
     * Method under test: {@link vision#ls_tree(Label, Item, int)}
     */
    @Test
    void testLs_tree5() {

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
        vision.ls_tree(label, item, 2);
    }

    /**
     * Method under test: {@link vision#ls_tree(Label, Item, int)}
     */
    @Test
    void testLs_tree6() {

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
        item1.bookmarkName = "Dr";
        item1.hyperlink = "Dr";
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
        vision.ls_tree(label, item2, 1);
    }

    /**
     * Method under test: {@link vision#ls_tree(Label, Item, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLs_tree7() {

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
        item1.bookmarkName = "Dr";
        item1.hyperlink = "Dr";
        item1.sons = new ArrayList<>();
        item1.title = null;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "Dr";
        item2.visited = 1;
        vision.ls_tree(label, item2, 1);
    }

    /**
     * Method under test: {@link vision#show_tree(Label, Item, int)}
     */
    @Test
    void testShow_tree() {

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

    /**
     * Method under test: {@link vision#show_tree(Label, Item, int)}
     */
    @Test
    void testShow_tree2() {
        vision vision = new vision("Cmd Name");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        vision.show_tree(label, null, 1);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("Cmd Name", vision.cmdName);
    }

    /**
     * Method under test: {@link vision#show_tree(Label, Item, int)}
     */
    @Test
    void testShow_tree3() {

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
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = new ArrayList<>();
        item1.title = "Dr";
        item1.visited = 1;
        vision.show_tree(label, item1, 1);
    }

    /**
     * Method under test: {@link vision#show_tree(Label, Item, int)}
     */
    @Test
    void testShow_tree4() {

        vision vision = new vision("Cmd Name");
        Item item = new Item();
        item.bookmarkName = "#";
        item.hyperlink = "#";
        item.sons = new ArrayList<>();
        item.title = "#";
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
        vision.show_tree(label, item1, 1);
    }

    /**
     * Method under test: {@link vision#show_tree(Label, Item, int)}
     */
    @Test
    void testShow_tree5() {

        vision vision = new vision("Cmd Name");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        Item item = new Item();
        item.bookmarkName = null;
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 1;
        vision.show_tree(label, item, 1);
    }

    /**
     * Method under test: {@link vision#show_tree(Label, Item, int)}
     */
    @Test
    void testShow_tree6() {

        vision vision = new vision("Cmd Name");
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        Item item = new Item();
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.title = "Dr";
        item.visited = 0;
        vision.show_tree(label, item, 1);
    }

    /**
     * Method under test: {@link vision#show_tree(Label, Item, int)}
     */
    @Test
    void testShow_tree7() {

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
        item1.bookmarkName = "Dr";
        item1.hyperlink = "Dr";
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
        vision.show_tree(label, item2, 1);
    }

    /**
     * Method under test: {@link vision#show_tree(Label, Item, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testShow_tree8() {

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
        item1.bookmarkName = "Dr";
        item1.hyperlink = "Dr";
        item1.sons = new ArrayList<>();
        item1.title = null;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.title = "Dr";
        item2.visited = 1;
        vision.show_tree(label, item2, 1);
    }
}

