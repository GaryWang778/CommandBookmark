package components.command;

import dataStructure.Label;

import dataStructure.Item;


//具体命令接口之——add命令
public class addCommand implements Command {
    public String cmdName;
    public String titleName = null;
    public String parentTitleName = null;
    public String url = null;
    public String bookmarkName = null;

    public addCommand(String[] list){
        cmdName = list[0];
        if (cmdName.equals("add-title ")){
            titleName = list[1];
            if(list.length > 2){
                parentTitleName = list[3];
            }
        } else if (cmdName.equals("add-bookmark ")){
            bookmarkName = list[1];
            url = list[3];
            titleName = list[5];
        }
    }

    @Override
    public void execute(Label bookMark) {
        if(cmdName.equals("add-title ")){
            //执行add-title命令
            Item obj_t = new Item();
            obj_t.title = titleName;
            bookMark.items.add(obj_t);

            //处理父标题
            if(parentTitleName != null){
                obj_t.parent_tit = parentTitleName;
                //定位父标题，并将obj_a插入到父标题的son列表中
                for(Item p : bookMark.items){
                    if(parentTitleName.equals(p.title)){
                        //p为obj_a的父标题
                        p.sons.add(obj_t);
                        break;
                    }
                }
            }
            System.out.print(cmdName+"  "+titleName+"  "+parentTitleName+"  ");

        }else if(cmdName.equals("add-bookmark ")){
            //执行add-bookmark命令
            //根据titleName去查找对应<Item> obj_b，然后在obj_b中添加相关属性
            for(Item obj_b : bookMark.items){
                if(titleName.equals(obj_b.title)){
                    obj_b.bookmarkName = bookmarkName;
                    obj_b.hyperlink = url;
                }
            }
            System.out.print(cmdName+"\n"+bookmarkName+"\n"+url+"\n"+titleName+"\n");

        }else{
            System.out.print("this commandline is not exit");
        }
//
    }


}