package com.command;

//抽象命令接口
public interface Command {
    /**
     * execute this command
     */
    public void execute();
    /**
     * revoke this command
     */
    public void undo();
}
