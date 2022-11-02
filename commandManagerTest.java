package components.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class commandManagerTest {
    private String[] list = {""};
    addCommand addCommand = new addCommand(list);
    deleteCommand deleteCommand = new deleteCommand(list);

    @Test
    void undo1() {
        List<Command> expectedCommand = new ArrayList<>();
        commandManager.executeCommand(addCommand);
        expectedCommand.add(addCommand);
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"命令插入失败");

        commandManager.undo();
        expectedCommand.remove(addCommand);
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"undo失败");
    }
    @Test
    void undo2() {
        List<Command> expectedCommand = new ArrayList<>();
        commandManager.executeCommand(addCommand);
        commandManager.executeCommand(deleteCommand);
        expectedCommand.add(addCommand);
        expectedCommand.add(deleteCommand);

        commandManager.undo();
        commandManager.undo();
        expectedCommand.remove(addCommand);
        expectedCommand.remove(deleteCommand);
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"undo失败");
    }

    @Test
    void redo1() {
        List<Command> expectedCommand = new ArrayList<>();
        commandManager.executeCommand(addCommand);
        expectedCommand.add(addCommand);
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"命令插入失败");

        commandManager.undo();
        commandManager.redo();
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"redo失败");
    }

    @Test
    void redo2() {
        List<Command> expectedCommand = new ArrayList<>();
        commandManager.executeCommand(addCommand);
        commandManager.executeCommand(deleteCommand);
        expectedCommand.add(addCommand);
        expectedCommand.add(deleteCommand);

        commandManager.undo();
        commandManager.undo();
        commandManager.redo();
        expectedCommand.remove(deleteCommand);

        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"redo失败");
    }
}
