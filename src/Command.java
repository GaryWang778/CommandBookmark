public class Command {

    void execute() {

    }

}

//add
class AddCommand extends Command{
    private ReceiverCont receiverCont;
    public AddCommand(ReceiverCont receiverCont){
        this.receiverCont = receiverCont;
    }
    @Override
    public void execute() {
        receiverCont.add();
    }

}

//delete
class DeleteCommand extends Command{
    private ReceiverCont receiverCont;
    public DeleteCommand(ReceiverCont receiverCont){
        this.receiverCont = receiverCont;
    }
    @Override
    public void execute() {
        receiverCont.delete();
    }
}

class UndoCommand extends Command{
    private ReceiverCont receiverCont;
    public UndoCommand(ReceiverCont receiverCont){
        this.receiverCont = receiverCont;
    }
}

class RedoCommand extends Command{
    private ReceiverCont receiverCont;
    public RedoCommand(ReceiverCont receiverCont){
        this.receiverCont = receiverCont;
    }
}


//Load
class LoadCommand extends Command{
    private ReceiverStruc receiverStruc;
    public LoadCommand(ReceiverStruc receiverStruc){
        this.receiverStruc = receiverStruc;
    }
    @Override
    public void execute() {
        receiverStruc.load();
    }
}

//showTree
class ShowTreeCommand extends Command{
    private ReceiverStruc receiverStruc;
    public ShowTreeCommand(ReceiverStruc receiverStruc){
        this.receiverStruc = receiverStruc;
    }
    @Override
    public void execute() {
        receiverStruc.showTree();
    }
}
