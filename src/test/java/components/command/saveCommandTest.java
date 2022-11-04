package components.command;

import dataStructure.Item;
import dataStructure.Label;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class saveCommandTest {


    @Test
    void test_01() {
        saveCommand actualSaveCommand = new saveCommand();

        Item item1 = new Item();
        item1.bookmarkName = "Bookmark Name1";
        item1.hyperlink = "Hyperlink1";
        item1.sons = new ArrayList<>();
        item1.title = "title1";
        item1.visited = 1;

        Item item2 = new Item();
        item2.bookmarkName = "Bookmark Name2";
        item2.hyperlink = "HyperLink2";
        item2.sons = new ArrayList<>();
        item2.title = "title2";
        item2.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);

        Item total = new Item();
        total.bookmarkName = "Bookmark Name total";
        total.hyperlink = "HyperLink total";
        total.sons = itemList;
        total.title = "title total";
        total.visited = 0;

        ArrayList<Item> itemListTotal = new ArrayList<>();
        itemListTotal.add(total);

        Label label = new Label();
        label.filepath = "E:/test1.txt";
        label.items = itemListTotal;
        actualSaveCommand.execute(label);
    }

    @Test
    void test_02() {
        saveCommand actualSaveCommand2 = new saveCommand();

        Item total = new Item();
        total.bookmarkName = "Bookmark Name total";
        total.hyperlink = "HyperLink total";
        total.sons = new ArrayList<>();
        total.title = "title total";
        total.visited = 0;

        ArrayList<Item> itemList2 = new ArrayList<>();
        itemList2.add(total);

        Item root = new Item();
        root.sons = itemList2;

        ArrayList<Item> itemList3 = new ArrayList<>();
        itemList3.add(root);


        Label label = new Label();
        label.filepath = "E:/test2.txt";
        label.items = itemList3;


        actualSaveCommand2.execute(label);
    }
}

