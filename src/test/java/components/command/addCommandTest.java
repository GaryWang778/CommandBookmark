package components.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class addCommandTest {

//     Method under test: {@link addCommand#addCommand(String[])}

    @Test
    void testConstructor() {
        addCommand actualAddCommand = new addCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualAddCommand.execute(label);
        assertEquals("List", actualAddCommand.cmdName);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
    }


//     Method under test: {@link addCommand#addCommand(String[])}

    @Test
    void testConstructor2() {
        addCommand actualAddCommand = new addCommand(new String[]{"add-title ", "add-title "});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualAddCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        assertEquals(1, itemList.size());
        Item getResult = itemList.get(0);
        assertEquals(0, getResult.visited);
        assertEquals("add-title ", getResult.title);
        assertEquals(1, getResult.sons.size());
    }


//     Method under test: {@link addCommand#addCommand(String[])}

    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor3() {

        addCommand actualAddCommand = new addCommand(new String[]{"add-title "});
        Label label = null;
        label.filepath = "/directory/foo.txt";
        Label label1 = null;
        label1.items = new ArrayList<>();
        actualAddCommand.execute(null);
    }

    /**
     * Method under test: {@link addCommand#addCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor4() {

        addCommand actualAddCommand = new addCommand(new String[]{});
        Label label = null;
        label.filepath = "/directory/foo.txt";
        Label label1 = null;
        label1.items = new ArrayList<>();
        actualAddCommand.execute(null);
    }

    /**
     * Method under test: {@link addCommand#addCommand(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor5() {

        addCommand actualAddCommand = new addCommand(new String[]{"add-title ", "add-title ", "add-title "});
        Label label = null;
        label.filepath = "/directory/foo.txt";
        Label label1 = null;
        label1.items = new ArrayList<>();
        actualAddCommand.execute(null);
    }

    /**
     * Method under test: {@link addCommand#execute(Label)}
     */
    @Test
    void testExecute() {
        addCommand addCommand = new addCommand(new String[]{"List"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        addCommand.execute(label);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
        assertEquals("List", addCommand.cmdName);
    }

    /**
     * Method under test: {@link addCommand#execute(Label)}
     */
    @Test
    void testExecute2() {
        addCommand addCommand = new addCommand(new String[]{"add-title ", "add-title "});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        addCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        assertEquals(1, itemList.size());
        Item getResult = itemList.get(0);
        assertEquals(0, getResult.visited);
        assertEquals("add-title ", getResult.title);
        assertEquals(1, getResult.sons.size());
    }
}

