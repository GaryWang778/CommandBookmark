package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.util.Stack;

public class saveCommand implements Command{
    public String cmdName;
    public String filePath;

    public saveCommand(String[] list){
        cmdName = list[0];
        filePath = list[1];
    }
    @Override
    public void execute(Label bookMark, Stack<Item> trashItem) {
        System.out.print(cmdName+"\n"+filePath+"\n");
    }

    @Override
    public void undo(Label bookMark, Stack<Item> trashItem) {
        System.out.println("saveCommand is canceled");
    }
}
