package components.command;
import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;
import java.util.List;


//命令管理器，存储执行过的命令，同时实现redo与undo功能
public class commandManager {

    private static final List<Command> historyCommand = new ArrayList<>();
    private static int commandPointer = 0;

    //创建Label对象，存储数据
    static Label bookMark = new Label();
    private static Stack<Item> trashItem = new Stack<>();

    public static void executeCommand(Command command) {
<<<<<<< HEAD
        if((command instanceof addCommand) || (command instanceof deleteCommand)){
            //新添加指令时，删除commandPointer之后的所有历史命令
            for(int i=0;i<historyCommand.size()-commandPointer;i++){
                historyCommand.remove(commandPointer+1);
            }
            historyCommand.add(command);
            commandPointer += 1;
=======
        command.execute(bookMark, trashItem);
        undoCommands.push(command);

        //当新的指令执行后，清除redo列表
        if(!redoCommands.isEmpty()) {
            redoCommands.clear();
>>>>>>> deb93f26e8b7c44433fcb39a9a2fec6c2397c489
        }
        command.execute(data);

    }

    public static void undo() {
<<<<<<< HEAD
        //检查数组不能越下界
        if(commandPointer==0) {
            System.out.print("已经undo所有命令，无法继续");
        }else{
            commandPointer--;
            System.out.print("undo success!");
=======
        if(!undoCommands.isEmpty()) {
            Command command = undoCommands.pop();
            command.undo(bookMark, trashItem);
            redoCommands.push(command);
>>>>>>> deb93f26e8b7c44433fcb39a9a2fec6c2397c489
        }
    }

    public static void redo() {
<<<<<<< HEAD
        if(commandPointer==historyCommand.size()-1){
            System.out.print("已经redo所有命令，无法继续");
        }else{
            commandPointer++;
            System.out.print("redo success!");
=======
        if(!redoCommands.isEmpty()) {
            Command command = redoCommands.pop();
            command.execute(bookMark,trashItem);
>>>>>>> deb93f26e8b7c44433fcb39a9a2fec6c2397c489
        }
    }

}
