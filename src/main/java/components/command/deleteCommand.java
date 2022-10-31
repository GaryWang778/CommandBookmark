package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.util.Stack;

public class deleteCommand implements Command{
    public String cmdName;
    public String titleName;
    public String bookmarkname;
//    private static Stack<String> bookmarkNameStack = new Stack<>();
//    private static Stack<String> hyperlinkNameStack = new Stack<>();

    public deleteCommand(String[] list){
        cmdName = list[0];
        if(cmdName.equals("delete-title ")){
            titleName = list[1];
        } else if (cmdName.equals("delete-bookmark ")) {
            bookmarkname = list[1];
        }
    }

    ////根据titleName去Label中查找对应<Item> obj_t
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

    //根据bookmark(描述)去Label中查找对应<Item> obj_t
    public Item find_bookmark(Label bookMark, String bookmarkName){
        if(!bookMark.items.isEmpty()){
            for(Item obj_t : bookMark.items){
                if(bookmarkName.equals(obj_t.bookmarkName)){
                    return obj_t;
                }
            }
        }
        return null;
    }

    @Override
    public void execute(Label bookMark) {
        if (cmdName.equals("delete-title ")){
            //执行delete-title指令
            //根据titleName去查找对应<Item> obj_t,将其从Label中删除
            Item obj_t = find_title(bookMark, titleName);
            bookMark.items.remove(obj_t); //从Label中删除该<Item> obj_t
            for(Item obj_t_son : obj_t.sons){ //从Label中删除该obj_t的子节点
                bookMark.items.remove(find_title(bookMark, obj_t_son.title));
            }

            System.out.print(cmdName+"\n"+titleName+"\n");

        } else if (cmdName.equals("delete-bookmark ")) {
            //执行delete-bookmark指令
            //根据bookmarkname去查找对应<Item> obj_t,先将其bookmarkName和hyperlink压入栈中，然后删除obj_t的相关属性
            Item obj_t = find_bookmark(bookMark, bookmarkname);
//            bookmarkNameStack.push(obj_t.bookmarkName);
//            hyperlinkNameStack.push(obj_t.hyperlink);
            obj_t.bookmarkName = null;
            obj_t.hyperlink = null;

            System.out.print(cmdName+"\n"+bookmarkname+"\n");

        } else {
            System.out.print("this commandline is not exit");
        }
//
    }
}
