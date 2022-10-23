package com.command;

public class loadCommand implements Command{

    public String cmdName;
    public String filePath;

    public loadCommand(String[] list){
        cmdName = list[0];
        filePath = list[1];
    }
    @Override
    public void execute() {
        System.out.print(cmdName+"\n"+filePath+"\n");
    }

    @Override
    public void undo() {

    }
}
