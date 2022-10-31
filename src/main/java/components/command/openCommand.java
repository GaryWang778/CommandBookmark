package components.command;
import dataStructure.Label;

public class openCommand implements Command{

    public String cmdName;
    public String filePath;

    public openCommand(String[] list){
        cmdName = list[0];
        filePath = list[1];
    }
    @Override
    public void execute(Label bookMark) {
        //执行load
        System.out.print(cmdName+"\n"+filePath+"\n");
    }


}
