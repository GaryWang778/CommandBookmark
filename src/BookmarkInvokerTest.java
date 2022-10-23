import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkInvokerTest {

    private
    @org.junit.jupiter.api.Test
    void clearCommand() {
    }

    //测试addCommands函数
    @org.junit.jupiter.api.Test
    void addCommands() {
        BookmarkInvoker invoker = new BookmarkInvoker();

        //生成add和delete命令
        ReceiverCont receiverCont = new ReceiverCont();
        AddCommand addCommand = new AddCommand(receiverCont);
        DeleteCommand deleteCommand = new DeleteCommand(receiverCont);

        UndoCommand undoCommand = new UndoCommand(receiverCont);
        RedoCommand redoCommand = new RedoCommand(receiverCont);

        //标准输出
        List<Command> expectedCommand = new ArrayList<>();

        // 插入命令
        invoker.addCommands(addCommand);
        expectedCommand.add(addCommand);
        Assertions.assertIterableEquals(expectedCommand, invoker.getBookmarkCommands(), "命令插入失败！");

        invoker.addCommands(addCommand);
        expectedCommand.add(addCommand);
        Assertions.assertIterableEquals(expectedCommand, invoker.getBookmarkCommands(), "命令插入失败！");

        invoker.addCommands(deleteCommand);
        expectedCommand.add(deleteCommand);
        Assertions.assertIterableEquals(expectedCommand, invoker.getBookmarkCommands(), "命令插入失败！");

        invoker.addCommands(undoCommand);
        expectedCommand.remove(expectedCommand.size() - 1);
        Assertions.assertIterableEquals(expectedCommand, invoker.getBookmarkCommands(), "undo命令插入失败！");

        invoker.addCommands(redoCommand);
        expectedCommand.add(deleteCommand);
        Assertions.assertIterableEquals(expectedCommand, invoker.getBookmarkCommands(), "redo命令插入失败！");

    }

    @org.junit.jupiter.api.Test
    void execute_AddDel_Command() {
    }

    @org.junit.jupiter.api.Test
    void execute_Else_Command() {
    }
}