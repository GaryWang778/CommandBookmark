package com.command;

public class savaCommand implements Command{
    @Override
    public void execute() {
        System.out.println("savaCommand is executed");
    }

    @Override
    public void undo() {
        System.out.println("savaCommand is canceled");
    }
}
