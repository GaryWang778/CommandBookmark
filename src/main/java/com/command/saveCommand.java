package com.command;

public class saveCommand implements Command{
    public String cmdName;
    public String filePath;

    public saveCommand(String[] list){
        cmdName = list[0];
        filePath = list[1];
    }
    @Override
    public void execute() {
        System.out.print(cmdName+"\n"+filePath+"\n");
//        System.out.println("savaCommand is executed");
    }

    @Override
    public void undo() {
        System.out.println("savaCommand is canceled");
    }
}
