package components.command;
import dataStructure.Item;
import dataStructure.Label;


public class bookmarkCommand implements Command{

    public String cmdName;
    public String filePath;

    public  bookmarkCommand(String[] list){
        cmdName = list[0];
        filePath = list[1];
    }
    @Override
    public void execute(Label bookMark){
        //执行load
        bookMark.filepath = filePath;
//

    }
}

