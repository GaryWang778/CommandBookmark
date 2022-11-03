package components.command;
import dataStructure.Item;
import dataStructure.Label;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


//命令管理器，存储执行过的命令，同时实现redo与undo功能
public class commandManager {

    private static final List<Command> historyCommand = new ArrayList<>();
    private static int commandPointer = 0;//指向的是下个command存储的位置


    public static void executeCommand(Command command, Label bookMark) {

        if ((command instanceof addCommand) || (command instanceof deleteCommand)) {
            //新添加指令时，删除commandPointer及其之后的所有历史命令
            for (int i = 0; i < historyCommand.size() - commandPointer; ) {
                historyCommand.remove(commandPointer);
            }
            historyCommand.add(command);
            commandPointer += 1;
        }else if (command instanceof saveCommand){
//            bookMark.items.add(root);

            //只有输入save指令时才会执行所有指令
            for(int i = 0; i < commandPointer; i++){
                Command commandtoExecute = historyCommand.get(i);
                commandtoExecute.execute(bookMark);
            }
            commandPointer = 0;
            historyCommand.clear();
            command.execute(bookMark);
        }else{
            command.execute(bookMark);
        }
    }

    public static void undo() {
        //检查数组不能越下界
        if(commandPointer==0) {
            System.out.print("已经undo所有命令，无法继续");
        }else{
            commandPointer--;
            System.out.print("undo success!\n");
        }
    }

    public static void redo() {
        if(commandPointer==historyCommand.size()){
            System.out.print("已经redo所有命令，无法继续");
        }else{
            commandPointer++;
            System.out.print("redo success!\n");
        }
    }
    public static List<Command> getHistoryCommands(){
        return historyCommand.subList(0,commandPointer);
    }
    public static void clealAll(){
        historyCommand.clear();
        commandPointer = 0;
    }

}
