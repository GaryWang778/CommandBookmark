//接收命令行的输入


import dataStructure.Item;
import dataStructure.Label;

import java.util.Scanner;

public class commandLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 接收指令
//      todo：添加使用说明
        System.out.println("please input order: ");

        //创建Label对象，和根节点root
        Label bookMark = new Label();
        Item root = new Item();
        root.title = "根节点连接到所有一级标题并保存打开文件的绝对路径";
        bookMark.items.add(root);

        while (scan.hasNextLine()) {
            String order = scan.nextLine();

            //exit退出指令
            if (order.equals("exit")){
                break;
            }

            //调用指令解析模块
            commandParse comParse = new commandParse(order);
            comParse.comParser(bookMark);

            //依次输入指令
            System.out.println("please input order:  ");
        }
        scan.close();
    }
}