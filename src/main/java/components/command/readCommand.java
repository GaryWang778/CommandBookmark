
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
        if(bookMark.items.size() > 0){
            for(Item i : bookMark.items.subList(1,bookMark.items.size())){
                if(i.bookmarkName.equals(bookmarkname)){
                    i.visited++;
                }
            }
        }

    }

}