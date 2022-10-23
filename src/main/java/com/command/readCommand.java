package com.command;

public class readCommand implements Command {
    public String cmdName;
    public String boookmarkName;

    public readCommand(String[] list){
        cmdName = list[0];
        boookmarkName = list[1];
    }
    @Override
    public void execute() {
        System.out.print(cmdName+"\n"+boookmarkName+"\n");
//        System.out.println("readCommand is executed");
    }
    @Override
    public void undo() {
        System.out.println("readCommand is canceled");
    }
}
