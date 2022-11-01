package dataStructure;

import java.util.ArrayList;

public class Label {
    public Label() {//构造函数
        this.items = new ArrayList<>();
        this.filepath = null;
    }

    public ArrayList<Item> items;//当前Label下的所有一级书签
    public String filepath;

}
