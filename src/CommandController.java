package src;

import java.util.ArrayList;
import java.util.List;

public class CommandController {
    List<CommandTable> historyCommand = new ArrayList<CommandTable>();

    public void switchCommand(CommandTable commandTable){
        historyCommand.add(commandTable);
        commandTable.execute();
    }
}
