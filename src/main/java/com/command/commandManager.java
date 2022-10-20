package com.command;
import java.util.Stack;

//命令管理器，存储执行过的命令，同时实现redo与undo功能
public class commandManager {
    private Stack<Command> undoCommands = new Stack<>();
    private Stack<Command> redoCommands = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        undoCommands.push(command);

        //当新的指令执行后，清除redo列表
        if(!redoCommands.isEmpty()) {
            redoCommands.clear();
        }
    }

    public void undo() {
        if(!undoCommands.isEmpty()) {
            Command command = undoCommands.pop();
            command.undo();
            redoCommands.push(command);
        }
    }

    public void redo() {
        if(!redoCommands.isEmpty()) {
            Command command = redoCommands.pop();
            command.execute();
        }
    }

}
