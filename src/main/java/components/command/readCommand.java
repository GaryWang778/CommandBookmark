package components.command;
import dataStructure.Item;
import dataStructure.Label;

//实现read-bookMark功能
public class readbookMark implements Command{
    @Override
    public void execute(Label bookMark, String url) {//url是待读取的bookmark
        ArrayList<Item> temp = bookMark.items;
        for(Item i : temp){
            read_mark(i, url);
        }
        System.out.println("readCommand is executed");
    }

    public static void read_mark(Item item,String url){
        if(item == null)
            return;
        if(item.bookmark == url){
            item.visited++;
            return;}
        ArrayList<Item> temp1 = item.sons;
        if (temp1 != null)
            for(Item i : temp1){
                read_mark(i,url);
            }
    }
    
}