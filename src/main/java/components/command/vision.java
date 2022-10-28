package components.command;

import dataStructure.Label;

//实现show-tree和ls-tree功能
public class vision implements Command{
    @Override
    public void execute(Label bookMark) {
        //执行show-tree和ls-tree指令
        System.out.println("visionCommand is executed");
    }

//    @Override
//    public void undo(Label bookMark) {
//        System.out.println("visionCommand is canceled");
//    }

}
