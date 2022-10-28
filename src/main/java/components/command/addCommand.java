package components.command;

import dataStructure.Label;

//具体命令接口之——add命令
public class addCommand implements Command {
    public String cmdName;
    public String titleName = null;
    public String parentTitleName = null;
    public String url = null;
    public String bookmarkName = null;


    public addCommand(String[] list){
        cmdName = list[0];
        if(cmdName.equals("add-title ")){
            titleName = list[1];
            if(list.length > 2){
                parentTitleName = list[3];
            }
        }else if(cmdName.equals("add-bookmark ")){
            bookmarkName = list[1];
            url = list[3];
            titleName = list[5];
        }
    }

    @Override
    public void execute(Label bookMark) {
        if(cmdName.equals("add-title ")){
            //执行add-title命令
            System.out.print(cmdName+"\n"+titleName+"\n"+parentTitleName+"\n");

        }else{
            //执行add-bookmark命令
            System.out.print(cmdName+"\n"+bookmarkName+"\n"+url+"\n"+titleName+"\n");

        }
//
    }

//    @Override
//    public void undo(Label bookMark) {
//        System.out.println("addCommand is canceled");
//    }
}