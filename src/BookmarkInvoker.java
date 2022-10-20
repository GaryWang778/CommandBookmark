import java.util.ArrayList;
import java.util.List;

public class BookmarkInvoker {
    //维护BookmarkCommands最终执行命令列表
    //后续维护undo redo两个命令栈，保存undo，redo后的命令
    private final List<Command> BookmarkCommands = new ArrayList<>();
    public void clearCommand(){
        BookmarkCommands.clear();
    }

    //设置加减命令
    //命令为undo则移除（后续用两个栈保存）
    public void addCommands(Command command){
        if(command instanceof UndoCommand){
            BookmarkCommands.remove(BookmarkCommands.size() - 1);
        }else {
            BookmarkCommands.add(command);
        }
    }

    //save之后执行加减
    public void execute_AddDel_Command(){
        for(Command command : BookmarkCommands){
            command.execute();
        }
        clearCommand();
    }

    public void execute_Else_Command(Command command){
        command.execute();
    }

}
