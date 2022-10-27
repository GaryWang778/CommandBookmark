package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.util.Stack;

//实现show-tree和ls-tree功能
public class vision implements Command{
    @Override
    public void execute(Label bookMark, Stack<Item> trashItem) {
        //执行show-tree和ls-tree指令
        System.out.println("visionCommand is executed");
    }

    @Override
    public void undo(Label bookMark, Stack<Item> trashItem) {
        System.out.println("visionCommand is canceled");
    }

}
