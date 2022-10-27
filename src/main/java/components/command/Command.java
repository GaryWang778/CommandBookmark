package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.util.Stack;

//抽象命令接口
public interface Command {
    /**
     * execute this command
     */
    public void execute(Label bookMark, Stack<Item> trashItem);
    /**
     * revoke this command
     */
    public void undo(Label bookMark, Stack<Item> trashItem);
}
