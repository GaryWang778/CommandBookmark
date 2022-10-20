package com.command;

public class readCommand implements Command {
    @Override
    public void execute() {
        System.out.println("addCommand is executed");
    }

    @Override
    public void undo() {
        System.out.println("addCommand is canceled");
    }
}
