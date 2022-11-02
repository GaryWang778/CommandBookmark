package components.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.Test;

public class readCommandTest {
    /**
     * Method under test: {@link readCommand#execute(Label)}
     */
    @Test
    public void testExecute() {
        readCommand readCommand = new readCommand(new String[]{"List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        readCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("List", readCommand.cmdName);
    }

    /**
     * Method under test: {@link readCommand#execute(Label)}
     */
    @Test
    public void testExecute2() {
        readCommand readCommand = new readCommand(new String[]{"List"});
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
        readCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertEquals(1, label.items.size());
        assertEquals("List", readCommand.cmdName);
    }
}

