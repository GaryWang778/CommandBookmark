package components.command;
import java.util.ArrayList;
import dataStructure.Label;
import dataStructure.Item;
import java.io.File;

//实现show-tree和ls-tree功能
public class vision implements Command {
    public String cmdName;
    public vision(String cmdName){
        this.cmdName = cmdName;
    }

    //根据titleName去Label中查找对应<Item> obj_t
    public Item find_title(Label bookMark, String titlename) {
        if(!bookMark.items.isEmpty()){
            for(Item obj_t : bookMark.items){
                if(titlename.equals(obj_t.title)){
                    return obj_t;
                }
            }
        }
        return null;
    }

    @Override
    public void execute(Label bookMark) {
        Item root = bookMark.items.get(0);
        //依次遍历一级标题
//        for (Item i : root.sons) {
//            if(cmdName.equals("ls-tree")){
//                ls_tree(bookMark, i, 1);
//            }else if(cmdName.equals("show-tree")){
//                show_tree(bookMark, i, 1);
//            }
//        }
        if(cmdName.equals("ls-tree")){
            ls_tree(bookMark);
        } else if (cmdName.equals("show-tree")) {
            for (Item i : root.sons) {
                show_tree(bookMark, i, 1);
            }
        }

    }

    public void ls_tree (Label bookMark){
//        if (item == null){
//            return;
//        }
//        int next_level = level + 1;
//        Item temp1 = find_title(bookMark, item.title);
//        ArrayList<Item> item_son = item.sons;
//        for (int num = 1; num < level; num++){
//            System.out.print("\t|");
//        }
//        System.out.print("-" + item.title +'\n');
//
//        if (temp1 != null)
//            for (Item i : item_son) {
//                ls_tree(bookMark, i, next_level);
//            }

        File f = new File(bookMark.filepath);
        printFile(f.getParentFile(), 0);
    }

    private void printFile(File file, int level) {
        //输出层次数
        for (int i = 0; i < level; i++) {
            System.out.print("\t|");
        }
        //输出文件名
        System.out.println("-"+file.getName());
        //如果file是目录，则获取子文件列表，并对每个子文件进行相同的操作
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                //递归调用该方法：注意等+1
                printFile(temp, level + 1);
            }
        }
    }

    public void show_tree (Label bookMark, Item item, int level){
//        if (item == null){
//            return;
//        }
//        int next_level = level + 1;
//        Item temp1 = find_title(bookMark, item.title);
//        ArrayList<Item> item_son = item.sons;
//        for (int num = 1; num <= level; num++){
//            System.out.print("#");
//        }
//        System.out.print(item.title + '\n');
//        if(item.bookmarkName != null){
//            System.out.print("[");
//            if (item.visited != 0){ System.out.print("*"); }
//            System.out.print(item.bookmarkName);
//            if (item.visited != 0){ System.out.print("["+item.visited+"]"); }
//            System.out.print("]");
//
//            System.out.print("(");
//            System.out.print(item.hyperlink);
//            System.out.print(")");
//            System.out.print('\n');
//        }
//
//        if (temp1 != null)
//            for (Item i : item_son) {
//                show_tree(bookMark, i, next_level);
//            }

        if (item == null){
            return;
        }
        int next_level = level + 1;
        Item temp1 = find_title(bookMark, item.title);
        ArrayList<Item> item_son = item.sons;
        for (int num = 1; num < level; num++){
            System.out.print("\t|");
        }
        System.out.print("-" + item.title +'\n');

        if (temp1 != null)
            for (Item i : item_son) {
                show_tree(bookMark, i, next_level);
            }
    }
}

