package components.command;

import static org.junit.Assert.assertEquals;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class visionTest {
    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecute() {
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
        //       at components.command.vision.execute(vision.java:27)
        //   In order to prevent execute(Label)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   execute(Label).
        //   See https://diff.blue/R013 to resolve this issue.

        vision vision = new vision("Cmd Name");
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute2() {
        vision vision = new vision("Cmd Name");
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
        vision.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("Cmd Name", vision.cmdName);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute3() {
        vision vision = new vision("Cmd Name");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("Cmd Name", vision.cmdName);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute4() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by execute(Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        vision vision = new vision("ls-tree");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute5() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by execute(Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute6() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by execute(Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        vision vision = new vision("ls-tree");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "ls-tree";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecute7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at components.command.vision.find_title(vision.java:17)
        //       at components.command.vision.ls_tree(vision.java:43)
        //       at components.command.vision.execute(vision.java:31)
        //   In order to prevent execute(Label)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   execute(Label).
        //   See https://diff.blue/R013 to resolve this issue.

        vision vision = new vision("ls-tree");
        Item item = new Item();
        item.title = null;
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute8() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by execute(Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        vision vision = new vision("ls-tree");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "ls-tree";
        item.hyperlink = "ls-tree";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Item item2 = new Item();
        item2.title = "Dr";
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.visited = 1;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        Label label = new Label();
        label.items = itemList2;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecute9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at components.command.vision.find_title(vision.java:17)
        //       at components.command.vision.ls_tree(vision.java:43)
        //       at components.command.vision.ls_tree(vision.java:55)
        //       at components.command.vision.execute(vision.java:31)
        //   In order to prevent execute(Label)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   execute(Label).
        //   See https://diff.blue/R013 to resolve this issue.

        vision vision = new vision("ls-tree");
        Item item = new Item();
        item.title = null;
        item.bookmarkName = "ls-tree";
        item.hyperlink = "ls-tree";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Item item2 = new Item();
        item2.title = "Dr";
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.visited = 1;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        Label label = new Label();
        label.items = itemList2;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute10() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by execute(Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "ls-tree";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute11() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by execute(Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "ls-tree";
        item1.hyperlink = "ls-tree";
        item1.sons = new ArrayList<>();
        item1.visited = 0;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item);
        Item item2 = new Item();
        item2.title = "Dr";
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList;
        item2.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item2);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecute12() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at components.command.vision.find_title(vision.java:17)
        //       at components.command.vision.show_tree(vision.java:64)
        //       at components.command.vision.execute(vision.java:33)
        //   In order to prevent execute(Label)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   execute(Label).
        //   See https://diff.blue/R013 to resolve this issue.

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.title = null;
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute13() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by execute(Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = null;
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    public void testExecute14() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by execute(Label)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "ls-tree";
        item.hyperlink = "ls-tree";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Item item2 = new Item();
        item2.title = "Dr";
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.visited = 1;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        Label label = new Label();
        label.items = itemList2;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecute15() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at components.command.vision.find_title(vision.java:17)
        //       at components.command.vision.show_tree(vision.java:64)
        //       at components.command.vision.show_tree(vision.java:85)
        //       at components.command.vision.execute(vision.java:33)
        //   In order to prevent execute(Label)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   execute(Label).
        //   See https://diff.blue/R013 to resolve this issue.

        vision vision = new vision("show-tree");
        Item item = new Item();
        item.title = null;
        item.bookmarkName = "ls-tree";
        item.hyperlink = "ls-tree";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "Dr";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Item item2 = new Item();
        item2.title = "Dr";
        item2.bookmarkName = "Bookmark Name";
        item2.hyperlink = "Hyperlink";
        item2.sons = itemList1;
        item2.visited = 1;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        Label label = new Label();
        label.items = itemList2;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }

    /**
     * Method under test: {@link vision#execute(Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecute16() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at components.command.vision.execute(vision.java:30)
        //   In order to prevent execute(Label)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   execute(Label).
        //   See https://diff.blue/R013 to resolve this issue.

        vision vision = new vision(null);
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Item item1 = new Item();
        item1.title = "ls-tree";
        item1.bookmarkName = "Bookmark Name";
        item1.hyperlink = "Hyperlink";
        item1.sons = itemList;
        item1.visited = 1;

        ArrayList<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        Label label = new Label();
        label.items = itemList1;
        label.filepath = "/directory/foo.txt";
        vision.execute(label);
    }
}

