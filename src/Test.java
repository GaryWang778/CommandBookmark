public class Test {
    public static void main(String[] args) {
        BookmarkInvoker invoker = new BookmarkInvoker();

        //生成add和delete命令
        ReceiverCont receiverCont = new ReceiverCont();
        AddCommand addCommand = new AddCommand(receiverCont);
        DeleteCommand deleteCommand = new DeleteCommand(receiverCont);
        //生成load和showTree命令
        ReceiverStruc receiverStruc = new ReceiverStruc();
        LoadCommand loadCommand = new LoadCommand(receiverStruc);
        ShowTreeCommand showTreeCommand = new ShowTreeCommand(receiverStruc);

        //生成undo命令
        UndoCommand undoCommand = new UndoCommand(receiverCont);


        //根据功能要求，命令为save,load,tree（除加减法）则直接执行，若为加减法或undo/redo则加入执行列
        //加入执行列表
        invoker.addCommands(addCommand);
        invoker.addCommands(deleteCommand);
        invoker.addCommands(undoCommand);

        //直接执行命令
        invoker.execute_Else_Command(loadCommand);
        invoker.execute_Else_Command(showTreeCommand);

        //若为save命令，则执行
        invoker.execute_AddDel_Command();

    }
}
