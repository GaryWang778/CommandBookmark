package components.command;
import dataStructure.Item;
import dataStructure.Label;

//实现read-bookMark功能
public class readCommand implements Command{
    public String bookmarkName = null;
    public String cmdName;
    
    public readCommand(String[] list){
        cmdName = list[0];
        if(cmdName.equals("read-bookMark "))
            bookMarkName = list[1];
    }
    
    @Override
    public void execute(Label bookMark) {
        ArrayList<Item> temp = bookMark.items;
        String tempstring = this.bookmarkName;
        for(Item i : temp){
            read_mark(i, tempstring);
        }
        System.out.println("readCommand is executed");
    }

    public static void read_mark(Item item,String name){//name是待读取的bookmarkName
        if(item == null)
            return;
        if(item.bookmark == name){
            item.visited++;
            return;}
        ArrayList<Item> temp1 = item.sons;
        if (temp1 != null)
            for(Item i : temp1){
                read_mark(i,name);
            }
    }
    
}
