//命令解析模块
import components.command.*;
import components.command.bookmarkCommand;
import dataStructure.Label;

public class commandParse {

    public String commandline;
    public commandParse(String commandline){
        this.commandline = commandline;
    }

    //根据引号对commandline进行划分
    public String[] split(String commandline) {
        return commandline.split("\"");
    }
    public String[] splitopencommand(String commandline){return commandline.split(" ");}

    //对commandline的命令符进行判断
    public void comParser(Label bookMark){
        if(commandline.contains("add")) {
            //add指令
            String[] list = split(commandline);
            commandManager.executeCommand(new addCommand(list), bookMark);

        }else if(commandline.contains("delete")){
            //delete指令
            String[] list = split(commandline);
            commandManager.executeCommand(new deleteCommand(list), bookMark);

        }else if(commandline.contains("save")){
            //save指令
            commandManager.executeCommand(new saveCommand(), bookMark);

        }else if(commandline.contains("undo")){
            //undo指令
            commandManager.undo();

        }else if(commandline.contains("redo")){
            //redo指令
            commandManager.redo();

        }else if(commandline.contains("tree")){
            //show-tree指令和ls-tree指令
            commandManager.executeCommand(new vision(commandline), bookMark);

        }else if(commandline.contains("read")){
            //read-bookmark指令
            String[] list = split(commandline);
            commandManager.executeCommand(new readCommand(list), bookMark);
        }else if(commandline.contains("open")){
            //open指令
            String[] list = splitopencommand(commandline);
            commandManager.executeCommand(new openCommand(list), bookMark);

        } else if(commandline.contains("bookmark")){
            //open指令
            String[] list = splitopencommand(commandline);
            commandManager.executeCommand(new bookmarkCommand(list), bookMark);

        }else{
            System.out.println("this commandline is not exit");
        }
    }



}
