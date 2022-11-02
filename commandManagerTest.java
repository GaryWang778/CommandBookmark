package components.command;

import dataStructure.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class commandManagerTest {
    private String[] list = {""};
    private Label bookmark;
    addCommand addCommand = new addCommand(list);
    deleteCommand deleteCommand = new deleteCommand(list);

    @Test
    void undo1() {
        commandManager.clealAll();
        List<Command> expectedCommand = new ArrayList<>();
        commandManager.executeCommand(addCommand,bookmark);
        expectedCommand.add(addCommand);
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"命令插入失败");

        commandManager.undo();
        expectedCommand.remove(addCommand);
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"undo失败");
    }
    @Test
    void undo2() {
        commandManager.clealAll();
        List<Command> expectedCommand = new ArrayList<>();
        commandManager.executeCommand(addCommand,bookmark);
        commandManager.executeCommand(deleteCommand,bookmark);
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
        commandManager.clealAll();
        List<Command> expectedCommand = new ArrayList<>();
        commandManager.executeCommand(addCommand,bookmark);
        expectedCommand.add(addCommand);
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"命令插入失败");

        commandManager.undo();
        commandManager.redo();
        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"redo失败");
    }

    @Test
    void redo2() {
        commandManager.clealAll();
        List<Command> expectedCommand = new ArrayList<>();
        commandManager.executeCommand(addCommand,bookmark);
        commandManager.executeCommand(deleteCommand,bookmark);
        expectedCommand.add(addCommand);
        expectedCommand.add(deleteCommand);

        commandManager.undo();
        commandManager.undo();
        commandManager.redo();
        expectedCommand.remove(deleteCommand);

        Assertions.assertIterableEquals(expectedCommand,commandManager.getHistoryCommands(),"redo失败");
    }
}
