package dataStructure;

import java.util.ArrayList;


public class Item {
    public Item(){
        this.sons = new ArrayList<Item>();
    }
	public String title;//书签的标题
    public String bookmark;//书签的描述，例如elearning Markdown Guide
    public String hyperlink;//书签的链接
    public ArrayList<Item> sons;//子书签
    public int visited;//是否已被访问
}
