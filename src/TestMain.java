package src;

public class TestMain {
    public static void main(String[] args){
        BookMark bookmark=new BookMark();
        CommandController commandcontroller = new CommandController();
        commandcontroller.switchCommand(new CommandAdd(bookmark));
        commandcontroller.switchCommand(new CommandDelete(bookmark));
        commandcontroller.switchCommand(new CommandLoad(bookmark));
        commandcontroller.switchCommand(new CommandSave(bookmark));
        commandcontroller.switchCommand(new CommandShow(bookmark));
    }
}