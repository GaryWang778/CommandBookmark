package components.command;
import dataStructure.Label;

import java.util.Stack;

//命令管理器，存储执行过的命令，同时实现redo与undo功能
public class commandManager {
    private static Stack<Command> undoCommands = new Stack<>();
    private static Stack<Command> redoCommands = new Stack<>();

    //创建Label对象，存储数据
    static Label data = new Label();

    public static void executeCommand(Command command) {
        command.execute(data);
        undoCommands.push(command);

        //当新的指令执行后，清除redo列表
        if(!redoCommands.isEmpty()) {
            redoCommands.clear();
        }
    }

    public static void undo() {
        if(!undoCommands.isEmpty()) {
            Command command = undoCommands.pop();
            command.undo(data);
            redoCommands.push(command);
        }
    }

    public static void redo() {
        if(!redoCommands.isEmpty()) {
            Command command = redoCommands.pop();
            command.execute(data);
        }
    }

}
