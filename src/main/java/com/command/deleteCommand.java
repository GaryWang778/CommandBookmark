package com.command;

public class deleteCommand implements Command{
    public String cmdName;
    public String titleName;
    public String bookmarkname;
    public deleteCommand(String[] list){
        cmdName = list[0];
        if(cmdName.equals("delete-title")){
            titleName = list[1];
        } else if (cmdName.equals("delete-bookmark")) {
            bookmarkname = list[1];
        }
    }
    @Override
    public void execute() {
        if (cmdName.equals("delete-title")){
            System.out.print(cmdName+"\n"+titleName+"\n");
        } else if (cmdName.equals("delete-bookmark")) {
            System.out.print(cmdName+"\n"+bookmarkname+"\n");
        }
//        System.out.println("addCommand is executed");
    }

    @Override
    public void undo() {
        System.out.println("addCommand is canceled");
    }
}
