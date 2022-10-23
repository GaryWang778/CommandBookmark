package com.command;

//实现show-tree和ls-tree功能
public class vision implements Command{
    @Override
    public void execute() {
        System.out.println("visionCommand is executed");
    }

    @Override
    public void undo() {
        System.out.println("visionCommand is canceled");
    }

}
