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
    @Override
    public void undo(Label bookMark, Stack<Item> trashItem) {
        System.out.println("readCommand is canceled");
    }
}
