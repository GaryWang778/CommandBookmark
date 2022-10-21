import java.util.ArrayList;
class Label {
    public Label(){
        this.items = new ArrayList<Item>();
    }
    public void add_title(Item item,String titlename) {
        Item temp = new Item();
        temp.title = titlename;
        if(item != null)
		    item.sons.add(temp);
        else
            this.items.add(temp);
    }
    public void add_bookmark(Item item,String bookmarkname) {
        if(item.bookmark != null)
            System.out.println("already has a bookmark");
        else
		    item.bookmark = bookmarkname;
    }
	public ArrayList<Item> items;
	}


class Item {
    public Item(){
        this.sons = new ArrayList<Item>();
    }
	public String title;
    public String bookmark;
    public ArrayList<Item> sons;
	}


class LabelTree {
    public static void showtree(Label label) {
		ArrayList<Item> temp = label.items;
        for(Item i : temp){
            showitem(i);
        }
    }

    public static void showitem(Item item){
        ArrayList<Item> temp1 = item.sons;
        System.out.println(item.title);
        if (temp1 != null)
            for(Item i : temp1){
                System.out.print('\t');
                showitem(i);
            }
    }
}

public class add_test{
    public static void main(String args[]){
        Label label = new Label();
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        Item item5 = new Item();
        item1.title = "father1";
        item2.title = "son1";
        item3.title = "father2";
        item4.title = "son2";
        item5.title = "son21";
        item1.sons.add(item2);
        item3.sons.add(item4);
        item3.sons.add(item5);
        label.items.add(item1);
        label.items.add(item3);
        LabelTree.showtree(label);
        label.add_title(null,"newfather");
        LabelTree.showtree(label);
    }
}