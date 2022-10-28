package components.command;
import java.util.ArrayList;
import dataStructure.Label;
import dataStructure.Item;

//实现show-tree和ls-tree功能
public class vision implements Command{
    // @Override
    public Label label = new Label();
    public vision(){
        System.out.print("this is the tree" + '\n');
    }
    public void showitem(Item item){
        if(item == null)
            return;
        ArrayList<Item> temp1 = item.sons;
        for(int num=1;num<item.level;num++) 
            System.out.print('\t');
        for(int num=1;num<=item.level;num++) 
            System.out.print("#");
        System.out.println(item.title);
        //System.out.println(item.level);
        if (temp1 != null)
            for(Item i : temp1){
                showitem(i);
            }
    }

    public void execute(Label bookMark) {
        //执行show-tree和ls-tree指令
        ArrayList<Item> temp = bookMark.items;
        for(Item i : temp){
            showitem(i);
        System.out.println("visionCommand is executed");
    }
    }

    // @Override
    public void undo(Label bookMark) {
        System.out.println("visionCommand is canceled");
    }

}
