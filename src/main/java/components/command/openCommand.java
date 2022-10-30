package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.util.Stack;

public class openCommand implements Command{

    public String cmdName;
    public String filePath;

    public openCommand(String[] list){
        cmdName = list[0];
        filePath = list[1];
    }
    @Override
    public void execute(Label bookMark, Stack<Item> trashItem) {
        //执行load
        System.out.print(cmdName+"\n"+filePath+"\n");
    }

<<<<<<< HEAD
//    @Override
//    public void undo(Label bookMark) {
//
//    }
=======
    @Override
    public void undo(Label bookMark, Stack<Item> trashItem) {

    }
>>>>>>> deb93f26e8b7c44433fcb39a9a2fec6c2397c489
}
