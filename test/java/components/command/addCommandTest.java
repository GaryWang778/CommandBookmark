package components.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.Test;

public class addCommandTest {
    /**
     * Method under test: {@link addCommand#execute(Label)}
     */
    @Test
    public void testExecute() {
        addCommand addCommand = new addCommand(new String[]{"List"});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        addCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("List", addCommand.cmdName);
    }

    /**
     * Method under test: {@link addCommand#execute(Label)}
     */
    @Test
    public void testExecute2() {
        addCommand addCommand = new addCommand(new String[]{"add-title ", "add-title "});
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        addCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        assertEquals(1, itemList.size());
        Item getResult = itemList.get(0);
        assertEquals(0, getResult.visited);
        assertEquals("add-title ", getResult.title);
        ArrayList<Item> itemList1 = getResult.sons;
        assertEquals(itemList, itemList1);
        assertEquals(1, itemList1.size());
    }
}

