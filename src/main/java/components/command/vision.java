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

<<<<<<< HEAD
//    @Override
//    public void undo(Label bookMark) {
//        System.out.println("visionCommand is canceled");
//    }
=======
    @Override
    public void undo(Label bookMark, Stack<Item> trashItem) {
        System.out.println("visionCommand is canceled");
    }
>>>>>>> deb93f26e8b7c44433fcb39a9a2fec6c2397c489

}
