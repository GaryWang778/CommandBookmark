package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.util.Stack;

//抽象命令接口
public interface Command {
    /*
     * execute this command
     */
<<<<<<< HEAD
    void execute(Label bookMark);
    /*
     * revoke this command
     */
//    public void undo(Label bookMark);
=======
    public void execute(Label bookMark, Stack<Item> trashItem);
    /**
     * revoke this command
     */
    public void undo(Label bookMark, Stack<Item> trashItem);
>>>>>>> deb93f26e8b7c44433fcb39a9a2fec6c2397c489
}
