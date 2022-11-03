package components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import components.command.addCommand;
import components.command.readCommand;
import dataStructure.Item;
import dataStructure.Label;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class readCommandTest {
    /**
     * test_01: readCommand(new String[]{""})
     */
    @Test
    void test_01() {
        readCommand actualReadCommand = new readCommand(new String[]{""});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualReadCommand.execute(label);
        assertEquals("", actualReadCommand.cmdName);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());

    }

    /**
     * test_02: readCommand(new String[]{"read-bookmark ", "课程"})
     */
    @Test
    void test_02() {
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();

        //添加根节点
        Item root = new Item();
        label.items.add(root);
        //添加一级标题
        addCommand title_add = new addCommand(new String[]{"add-title ","课程"});
        title_add.execute(label);
        addCommand bookmark_add = new addCommand(new String[]{"add-bookmark ", "elearning","@", "https://elearning.fudan.edu.cn/courses", "at", "课程"});
        bookmark_add.execute(label);
        //添加指令


        readCommand actualReadCommand = new readCommand(new String[]{"read-bookmark ", "elearning"});
        actualReadCommand.execute(label);


        ArrayList<Item> itemList = label.items;
        Item getResult = itemList.get(1);

        assertEquals("课程", getResult.title);
        assertEquals(1, getResult.visited);






    }



}

