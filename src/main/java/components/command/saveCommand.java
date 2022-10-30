package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.io.*;
import java.util.Stack;

//saveCommand：将Label中的数据刷新到文件中
public class saveCommand implements Command{
    public String cmdName;
    public String filePath = "src/main/java/个人收藏.md";

    public saveCommand(String[] list){
        cmdName = list[0];
    }
    //使用FileWriter不需要考虑原文件不存在的清空
    //当该文件不存在时，new FileWriter(file)会自动创建一个真实存在的空文件

    public void inputItem(Item a, String path, FileWriter fileWriter){
        //将Item a以及其子节点写入到md文件中
        try {
            fileWriter.write(a.title+"\n"+"["+a.bookmarkName+"]"+a.hyperlink);
            fileWriter.flush();

        }catch (IOException e){
            e.printStackTrace();

        }


        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));


        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void execute(Label bookMark) {
        //采用深度优先搜索算法
        //申请一个栈存储访问过的节点
        Stack<Item> DFS = new Stack<>();
        if(!bookMark.items.isEmpty()){
            DFS.push(bookMark.items.get(0));
        }

        File file = new File("src/main/java/个人收藏.md");
        try {
            FileWriter fileWriter = new FileWriter(file);
            //往文件重写内容
            fileWriter.write("");
            fileWriter.flush(); //强制刷出缓冲池中的数据,清空

            while (!DFS.isEmpty()){
                Item node = DFS.pop();
                inputItem(node, filePath, fileWriter);
                //然后考虑子节点
                for(Item son:node.sons){
                    DFS.push(son);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.print(cmdName+"\n"+filePath+"\n");
    }
}
