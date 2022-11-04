package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class openCommand implements Command {

    private String cmdName;
    private String filePath;

    public openCommand(String[] list) {
        if(list.length == 0){
            cmdName = "open";
            filePath = null;
        }
        else if (list.length < 2) {
            cmdName = list[0];
            filePath = null;
        } else {
            cmdName = list[0];
            filePath = list[1];
        }
    }

    @Override
    public void execute(Label bookMark) {
//      将md文件读入数据结构
        if (!isNull(filePath)) return;
        bookMark.filepath = filePath;
        try {
            openfile(bookMark);
            System.out.print("open success!\n");
        } catch (IOException e) {
            if (e instanceof FileNotFoundException){
                System.out.print(filePath+" is not found!\nopen a new file\n");
            }
        }
    }

    private void openfile(Label bookMark) throws IOException{
        BufferedReader reader;
//          维护根节点到当前节点的路径
        Stack<String> path = new Stack<>();
        reader = new BufferedReader(new FileReader(bookMark.filepath));
        String line = reader.readLine();
        while (line != null) {
            Item tempitem = new Item();
            int level = level(line);
            tempitem.title = getTitle(line);
            tempitem.visited = 0;
//              读取下一行
            line = reader.readLine();
//              如果下一行含有书签信息
            if (line != null && line.charAt(0) == '[') {
                tempitem.bookmarkName = getBookmarktitle(line);
                tempitem.hyperlink = getURL(line);
                line = reader.readLine();
            }
            bookMark.items.add(tempitem);
            findParent(path, level, bookMark, tempitem);
        }
        reader.close();
    }

    private boolean isNull(String filePath) {
        if (filePath == null) {
            System.out.print("filepath is required\n");
            return false;
        } else return true;
    }

    private String getURL(String line) {
        return line.substring(line.indexOf('(') + 1, line.indexOf(')'));
    }

    private String getBookmarktitle(String line) {
        return line.substring(line.indexOf('[') + 1, line.indexOf(']'));
    }

    private void findParent(Stack<String> path, int level, Label templable, Item tempitem) {
        if (path.empty()) {
//          当第一次添加一级节点时，路径为空
            templable.items.get(0).sons.add(tempitem);
            path.push(tempitem.title);
        } else if (path.size() < level) {
            insertIntoParent(templable, path, tempitem);
            path.push(tempitem.title);
        } else {
            int n = path.size() - level + 1;
            while (n-- != 0) path.pop();
            if (path.empty()) {
                templable.items.get(0).sons.add(tempitem);
            } else {
                insertIntoParent(templable, path, tempitem);
            }
            path.push(tempitem.title);
        }
    }

    private void insertIntoParent(Label templable, Stack<String> path, Item tempitem) {
        for (Item p : templable.items) {
            if (p.title.equals(path.peek())) {
                p.sons.add(tempitem);
            }
        }
    }

    private String getTitle(String line) {
        return line.substring(line.lastIndexOf("#") + 2);
    }

    private int level(String line) {
        int level = 0, index = 0;
        while (line.charAt(index) == '#') {
            level++;
            index++;
        }
        return level;
    }
}
