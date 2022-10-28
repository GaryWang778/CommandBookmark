package components.command;

import dataStructure.Label;

public class deleteCommand implements Command{
    public String cmdName;
    public String titleName;
    public String bookmarkname;
    public deleteCommand(String[] list){
        cmdName = list[0];
        if(cmdName.equals("delete-title ")){
            titleName = list[1];
        } else if (cmdName.equals("delete-bookmark ")) {
            bookmarkname = list[1];
        }
    }
    @Override
    public void execute(Label bookMark) {
        if (cmdName.equals("delete-title ")){
            //执行delete-title指令
            System.out.print(cmdName+"\n"+titleName+"\n");


        } else if (cmdName.equals("delete-bookmark ")) {
            //执行delete-bookmark指令
            System.out.print(cmdName+"\n"+bookmarkname+"\n");


        }
//
    }

//    @Override
//    public void undo(Label bookMark) {
//        System.out.println("deleteCommand is canceled");
//    }
}
