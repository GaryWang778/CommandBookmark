package components.command;
import java.util.ArrayList;
import dataStructure.Label;
import dataStructure.Item;

//实现show-tree和ls-tree功能
public class vision implements Command {
    public String cmdName;
    public vision(String cmdName){
        this.cmdName = cmdName;
    }
    @Override
    public void execute(Label bookMark) {
            Item root = bookMark.items.get(0);
            //先打印根节点信息
            System.out.print("#");
            System.out.print(root.title);
            //然后深度遍历
            for (Item i : root.sons) {
                showitem(i, 1);
            }
            System.out.println("visionCommand is executed");

    }

    public static void showitem (Item item, int level){
        if (item == null)
            return;
        int next_level = level + 1;
        ArrayList<Item> temp1 = item.sons;
        for (int num = 1; num < level; num++)
            System.out.print('\t');
        for (int num = 1; num <= level; num++)
            System.out.print("#");
        System.out.print(item.title + '\t');
        if (item.visited != 0)
            System.out.print("*");
        System.out.println(item.bookmarkName);
        if (temp1 != null)
            for (Item i : temp1) {
                showitem(i, next_level);
            }
    }
}


