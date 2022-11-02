package components.command;
import dataStructure.Item;
import dataStructure.Label;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class openCommand implements Command{

    public String cmdName;
    public String filePath;

    public openCommand(String[] list){
        cmdName = list[0];
        filePath = list[1];
    }
    @Override
    public void execute(Label bookMark){
        //执行load
        bookMark.filepath = filePath;
        BufferedReader reader;
        //维护路径
        Stack<String> path = new Stack<>();
        try {
            reader = new BufferedReader(new FileReader(bookMark.filepath));
            String line = reader.readLine();
            while (line != null) {
                Item tempitem = new Item();
                int level = countLevel(line);
                String title = getTitle(line);
                if (line.charAt(0) == '#'){
                    tempitem.title = title;
                    tempitem.visited = 0;
                }
                // 读取下一行
                line = reader.readLine();
                if (line != null && line.charAt(0) == '[') {
                    String bookmark = getBookmarktitle(line);
                    String url = getURL(line);
                    tempitem.bookmarkName = bookmark;
                    tempitem.hyperlink = url;
                    line = reader.readLine();
                }
                bookMark.items.add(tempitem);
                findparent(path, level, bookMark, tempitem);
            }
            reader.close();
        } catch (IOException e) {
            System.out.print("new file\n");
        }
    }

    private String getURL(String line) {
        return line.substring(line.indexOf('(')+1, line.indexOf(')'));
    }

    private String getBookmarktitle(String line) {
        return line.substring(line.indexOf('[')+1, line.indexOf(']'));
    }

    private void findparent(Stack<String> path, int level, Label templable, Item tempitem) {
        if(path.empty()) {
            templable.items.get(0).sons.add(tempitem);
            path.push(tempitem.title);
        } else if (path.size() < level){
            for (Item p : templable.items){
                if(p.title.equals(path.peek())){
                    p.sons.add(tempitem);
                }
            }
            path.push(tempitem.title);
        } else {
            int n = path.size() - level + 1;
            while(n-- != 0) path.pop();
            if (path.empty()){
                templable.items.get(0).sons.add(tempitem);
            }else{
                for (Item p : templable.items){
                    if(p.title.equals(path.peek())){
                        p.sons.add(tempitem);
                    }
                }
            }
            path.push(tempitem.title);
        }
    }

    private String getTitle(String line) {
        return line.substring(line.lastIndexOf("#")+2);
    }

    private int countLevel(String line) {
        int level = 0;
        int index = 0;
        while (line.charAt(index) == '#'){
            level++;
            index++;
        }
        return level;
    }
}
