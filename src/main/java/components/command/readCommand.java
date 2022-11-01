package components.command;
import dataStructure.Item;
import dataStructure.Label;
import java.util.ArrayList;

//实现read-bookMark功能
public class readCommand implements Command{
    public String bookmarkname = null;
    public String cmdName;

    public readCommand(String[] list){
        cmdName = list[0];
        if(cmdName.equals("read-bookmark "))
            bookmarkname = list[1];
    }

    @Override
    public void execute(Label bookMark) {
        for(Item i : bookMark.items){
            if(i.bookmarkName.equals(bookmarkname)){
                i.visited++;
            }
        }
    }

}