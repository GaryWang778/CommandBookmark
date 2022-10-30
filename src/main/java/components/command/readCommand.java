package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.util.Stack;

public class readCommand implements Command {
    public String cmdName;
    public String boookmarkName;

    public readCommand(String[] list){
        cmdName = list[0];
        boookmarkName = list[1];
    }
    @Override
    public void execute(Label bookMark, Stack<Item> trashItem) {
        //执行read-bookmark指令
        System.out.print(cmdName+"\n"+boookmarkName+"\n");

    }
<<<<<<< HEAD
//    @Override
//    public void undo(Label bookMark) {
//        System.out.println("readCommand is canceled");
//    }
=======
    @Override
    public void undo(Label bookMark, Stack<Item> trashItem) {
        System.out.println("readCommand is canceled");
    }
>>>>>>> deb93f26e8b7c44433fcb39a9a2fec6c2397c489
}
