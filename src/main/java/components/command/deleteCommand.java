package components.command;

import dataStructure.Item;
import dataStructure.Label;
import java.util.Objects;


public class deleteCommand implements Command{
    public String cmdName;
    public String titleName;
    public String bookmarkname;

    public deleteCommand(String[] list){
        cmdName = list[0];
        if(cmdName.equals("delete-title ")){
            titleName = list[1];
        } else if (cmdName.equals("delete-bookmark ")) {
            bookmarkname = list[1];
        }
    }

    //根据titleName去Label中查找对应<Item> obj_t
    public Item find_title(Label bookMark, String titlename) {
        if(!bookMark.items.isEmpty()){
            for(Item obj_t : bookMark.items){
                if(Objects.equals(obj_t.title, titlename)){
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
                if(Objects.equals(bookmarkName, obj_t.bookmarkName)){
                    return obj_t;
                }
            }
        }
        return null;
    }

    //根据titleName去Label中查找对应其父节点，并维护其父节点的sons字段
    public void adjust_sons(Label bookMark, String titlename){
        if(bookMark.items.isEmpty()){return;}
        for(Item obj_t : bookMark.items){
            for(Item temp : obj_t.sons){
                if(Objects.equals(titlename, temp.title)){
                    obj_t.sons.remove(temp);
                    return ;
                }
            }
        }

    }

    public void delete_item(Label bookMark, Item obj){
        //删除指定titleName的Item,并删除其子节点
        if(bookMark.items.isEmpty()){return;}
        if(obj == null){return;}

        //再删除指定节点
        //此处的i设置为1，跳过根节点
        for(int i=1; i < bookMark.items.size(); i++){
            Item temp = bookMark.items.get(i);
            if(Objects.equals(temp.title, obj.title)){
                bookMark.items.remove(temp);
            }
        }
        //删除子节点
        for(Item son : obj.sons){
            delete_item(bookMark, son);
        }
    }

    @Override
    public void execute(Label bookMark) {
        if (cmdName.equals("delete-title ")){
            //执行delete-title指令

            //根据titleName去查找对应<Item> obj_t,将其从Label中删除
            Item obj_t = find_title(bookMark, titleName);
            delete_item(bookMark, obj_t);
            //维护其父节点的sons字段
            adjust_sons(bookMark, titleName);

        } else if (cmdName.equals("delete-bookmark ")) {
            //执行delete-bookmark指令
            //根据bookmarkname去查找对应<Item> obj_t,然后删除obj_t的相关属性
            Item obj_t = find_bookmark(bookMark, bookmarkname);
            obj_t.bookmarkName = null;
            obj_t.hyperlink = null;

        } else {
            System.out.print("this commandline is not exit");
        }
//
    }
}
