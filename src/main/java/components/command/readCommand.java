package components.command;
import dataStructure.Label;

public class readCommand implements Command {
    public String cmdName;
    public String boookmarkName;

    public readCommand(String[] list){
        cmdName = list[0];
        boookmarkName = list[1];
    }
    @Override
    public void execute(Label bookMark) {
        //执行read-bookmark指令
        System.out.print(cmdName+"\n"+boookmarkName+"\n");

    }

}
