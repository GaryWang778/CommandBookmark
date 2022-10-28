package components.command;

import dataStructure.Label;

//抽象命令接口
public interface Command {
    /*
     * execute this command
     */
    void execute(Label bookMark);
    /*
     * revoke this command
     */
//    public void undo(Label bookMark);
}
