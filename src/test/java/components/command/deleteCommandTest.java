package components.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dataStructure.Item;
import dataStructure.Label;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class deleteCommandTest {
    /**
     * test_01: delateCommand(new String[]{""})
     */
    @Test
    void testConstructor1() {
        deleteCommand actualDeleteCommand = new deleteCommand(new String[]{""});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();
        actualDeleteCommand.execute(label);
        assertEquals("", actualDeleteCommand.cmdName);
        assertEquals("/directory/foo.txt", label.filepath);
        assertTrue(label.items.isEmpty());

    }

    /**
     * test_02: delateCommand(new String[]{"delete-title ", "课程"})
     */
    @Test
    void testConstructor2() {
        deleteCommand actualDeleteCommand = new deleteCommand(new String[]{"delete-title ", "课程"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();

        //添加根节点
        Item root = new Item();
        label.items.add(root);
        //添加指令
        addCommand title_add = new addCommand(new String[]{"add-title ","课程"});
        title_add.execute(label);

        //执行测试指令
        actualDeleteCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        Item getResult = itemList.get(0);
        assertEquals(1, itemList.size());
        assertEquals(null, getResult.title);
        assertEquals(null, getResult.hyperlink);
        assertEquals(0, getResult.sons.size());
        assertEquals(null, getResult.bookmarkName);

    }

    /**
     * test_03: delateCommand(new String[]{"delete-title ", "参考资料"})
     */
    @Test
    void testConstructor3() {
        deleteCommand actualDeleteCommand = new deleteCommand(new String[]{"delete-title ", "参考资料"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();

        //添加根节点
        Item root = new Item();
        label.items.add(root);
        //添加指令
        addCommand title_add_1 = new addCommand(new String[]{"add-title ","参考资料"});
        addCommand title_add_2 = new addCommand(new String[]{"add-title ","函数式","at","参考资料"});
        title_add_1.execute(label);
        title_add_2.execute(label);

        //执行测试指令
        actualDeleteCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        Item getResult = itemList.get(0);
        assertEquals(1, itemList.size());
        assertEquals(null, getResult.title);
        assertEquals(null, getResult.hyperlink);
        assertEquals(0, getResult.sons.size());
        assertEquals(null, getResult.bookmarkName);
    }

    /**
     * test_04: delateCommand(new String[]{"delete-bookmark ", "elearning"})
     */
    @Test
    void testConstructor4() {
        deleteCommand actualDeleteCommand = new deleteCommand(new String[]{"delete-bookmark ", "elearning"});
        Label label = new Label();
        label.filepath = "/directory/foo.txt";
        label.items = new ArrayList<>();

        //添加根节点
        Item root = new Item();
        label.items.add(root);
        //添加指令
        addCommand title_add = new addCommand(new String[]{"add-title ","课程"});
        addCommand bookMark_add = new addCommand(new String[]{"add-bookmark ", "elearning","@", "https://elearning.fudan.edu.cn/courses", "at", "课程"});
        title_add.execute(label);
        bookMark_add.execute(label);

        //执行测试指令
        actualDeleteCommand.execute(label);
        ArrayList<Item> itemList = label.items;
        Item getResult = itemList.get(1);
        assertEquals("课程", getResult.title);
        assertEquals(null, getResult.bookmarkName);
        assertEquals(null, getResult.hyperlink);

    }

}

