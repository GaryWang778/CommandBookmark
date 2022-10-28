package dataStructure;

import java.util.ArrayList;


public class Item {
    public Item(){
        this.sons = new ArrayList<Item>();
        this.title = new String;
        this.level = new int;
        this.bookmark = new String;
        this.hyperlink = new String;
        this.visited = new int;
    }
    public String title;//书签的标题
    public int level;//书签的级别
    public String bookmark;//书签的描述，例如elearning Markdown Guide
    public String hyperlink;//书签的链接
    public ArrayList<Item> sons;//子书签
    public int visited;//是否已被访问
}
