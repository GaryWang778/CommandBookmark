package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.io.*;
import java.util.ArrayList;

//saveCommand：将Label中的数据刷新到文件中
public class saveCommand implements Command{
    public String filePath = "src/main/java/个人收藏.md";


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

    public void inputItem (Label bookMark,FileWriter fileWriter, Item item, int level) throws IOException {
        if (item == null){
            return;
        }
        int next_level = level + 1;
        Item temp1 = find_title(bookMark, item.title);
        ArrayList<Item> item_son = item.sons;
        for (int num = 1; num <= level; num++){
            fileWriter.write("#");
        }
        fileWriter.write(" " + item.title + "    " + '\n');
        if(item.bookmarkName != null){
            fileWriter.write("[");
            if (item.visited != 0){ fileWriter.write("*"); }
            fileWriter.write(item.bookmarkName);
            fileWriter.write("]");

            fileWriter.write("(");
            fileWriter.write(item.hyperlink);
            fileWriter.write(")");
            fileWriter.write('\n');
        }

        if (temp1 != null)
            for (Item i : item_son) {
                inputItem(bookMark, fileWriter, i, next_level);
            }
    }
    @Override
    public void execute(Label bookMark) {
        File file = new File(filePath);

        Item root = bookMark.items.get(0);

        try {
            //使用FileWriter不需要考虑原文件不存在的清空
            //当该文件不存在时，new FileWriter(file)会自动创建一个真实存在的空文件
            FileWriter fileWriter = new FileWriter(file);
            //往文件重写内容
            fileWriter.write("");
            fileWriter.flush(); //强制刷出缓冲池中的数据

            //依次遍历一级标题
            for (Item i : root.sons){
                inputItem(bookMark, fileWriter, i, 1);
            }
            fileWriter.flush();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
