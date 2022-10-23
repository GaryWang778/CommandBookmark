import java.util.ArrayList;
import java.util.List;

public class BookmarkInvoker {
    //维护BookmarkCommands最终执行命令列表
    private final List<Command> BookmarkCommands = new ArrayList<>();
    private static int index=-1; //指向当前位置

    public void clearCommand(){
        BookmarkCommands.clear();
    }

    //设置加减命令，传参command
    public void addCommands(Command command){
        if(command instanceof UndoCommand && index >= 0){
            index--;
        }else if(command instanceof RedoCommand && index < BookmarkCommands.size() - 1){
            index++;
        }else if(command instanceof AddCommand || command instanceof DeleteCommand){
            if(index + 1 == BookmarkCommands.size()){
                BookmarkCommands.add(command);
                index++;
            }else{
                BookmarkCommands.add(++index, command);
            }
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

    public List<Command> getBookmarkCommands() {
        return BookmarkCommands.subList(0, index + 1);
    }
}
