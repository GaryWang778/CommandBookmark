package src;

public abstract class CommandTable {
    protected BookMark bookmark;
    public CommandTable(BookMark bookmark){
        this.bookmark=bookmark;
    }

    abstract void execute();
}

class CommandAdd extends CommandTable {

    public CommandAdd(BookMark bookmark) {
        super(bookmark);
    }

    @Override
    void execute() {
        bookmark.add();
    }
}

class CommandDelete extends CommandTable {

    public CommandDelete(BookMark bookmark) {
        super(bookmark);
    }

    @Override
    void execute(){
        bookmark.delete();
    }
}

class CommandLoad extends CommandTable{
    public CommandLoad(BookMark bookmark){
        super(bookmark);
    }
    @Override
    void execute(){
        bookmark.load();
    }
}

class CommandSave extends CommandTable{
    public CommandSave(BookMark bookmark){
        super(bookmark);
    }
    @Override
    void execute(){
        bookmark.save();
    }
}

class CommandShow extends CommandTable{
    public CommandShow(BookMark bookmark){
        super(bookmark);
    }
    @Override
    void execute(){
        bookmark.show();
    }
}