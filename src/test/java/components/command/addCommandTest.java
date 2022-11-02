package components.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class addCommandTest {
    /**
     * test_01: addCommand(new String[]{""})
     */
    @Test
    void testConstructor1() {
        addCommand actualAddCommand = new addCommand(new String[]{""});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualAddCommand.execute(label);
        assertEquals("", actualAddCommand.cmdName);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());
    }

    /**
     * test_02: addCommand(new String[]{"add-title ", "课程"})
     */
    @Test
    void testConstructor2() {
        addCommand actualAddCommand = new addCommand(new String[]{"add-title ", "课程"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        Item root = new Item();
        label.items.add(root);
        actualAddCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        assertEquals(2, itemList.size());
        Item getResult = itemList.get(1);
        assertEquals(0, getResult.visited);
        assertEquals("课程", getResult.title);
        assertEquals(0, getResult.sons.size());
    }

    /**
     * test_03: addCommand(new String[]{"add-title ","函数式","at","参考资料"})
     */
    @Test
    void testConstructor3() {
        addCommand actualAddCommand = new addCommand(new String[]{"add-title ","函数式","at","参考资料"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();

        //添加根节点
        Item root = new Item();
        label.items.add(root);
        //添加一级标题
        addCommand title_add = new addCommand(new String[]{"add-title ","参考资料"});
        title_add.execute(label);

        //执行测试指令
        actualAddCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        Item getParent = itemList.get(1);
        Item getResult_1 = getParent.sons.get(0);
        Item getResult_2 = itemList.get(2);
        assertEquals("函数式", getResult_1.title);
        assertEquals("函数式", getResult_2.title);
        assertEquals(3, itemList.size());
        assertEquals(1, getParent.sons.size());
        assertEquals(0, getResult_2.sons.size());
    }

    /**
     * test_04: addCommand(new String[]{"add-bookmark ", "elearning", "https://elearning.fudan.edu.cn/courses", "at", "课程"})
     */
    @Test
    void testConstructor4() {
        addCommand actualAddCommand = new addCommand(new String[]{"add-bookmark ", "elearning","@", "https://elearning.fudan.edu.cn/courses", "at", "课程"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();

        //添加根节点
        Item root = new Item();
        label.items.add(root);
        //添加一级标题
        addCommand title_add = new addCommand(new String[]{"add-title ","课程"});
        title_add.execute(label);

        //执行测试指令
        actualAddCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        Item getResult = itemList.get(1);
        assertEquals("课程", getResult.title);
        assertEquals("elearning", getResult.bookmarkName);
        assertEquals("https://elearning.fudan.edu.cn/courses", getResult.hyperlink);
        assertEquals(0, getResult.sons.size());
    }
}

