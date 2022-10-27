package dataStructure;

import java.util.ArrayList;

public class Label {
    public Label() {//构造函数
        this.items = new ArrayList<Item>();
        this.all_items = new ArrayList<Item>();
    }

    public ArrayList<Item> items;//一级书签，方便用于showtree
    public ArrayList<Item> all_items;//所有书签，方便add与delete操作

}
