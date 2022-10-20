package com.command;

//具体命令接口之——add命令
public class addCommand implements Command {


    @Override
    public void execute() {
        System.out.println("addCommand is executed");
    }

    @Override
    public void undo() {
        System.out.println("addCommand is canceled");
    }
}