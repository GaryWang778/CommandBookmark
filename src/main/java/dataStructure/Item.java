package dataStructure;

import java.util.ArrayList;


public class Item {
    public Item(){
        this.sons = new ArrayList<Item>();
    }
    public String title;//书签的标题
    public String bookmarkName;//书签的描述，例如elearning Markdown Guide
    public String hyperlink;//书签的链接
    public ArrayList<Item> sons;//子书签
    public int visited = 0;//是否已被访问,先置零，每访问一次，就++
}