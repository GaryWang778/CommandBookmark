package components;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readfile {
    // 按行存储 markdown 文件
    public ArrayList<String> mdList = new ArrayList();
    // 存储 markdown 文件的每一行对应类型
    public ArrayList<String> mdListType = new ArrayList();
    // 存储 markdown文件的每一行对应的状态
    public ArrayList<Boolean> isDeleted = new ArrayList();
    // 存储读取次数
    public ArrayList<Integer> readTimes = new ArrayList();
    //存储正在阅读标记
    public ArrayList<Boolean> isReading = new ArrayList();

    //文件绝对路径
    private String filepath;

    public readfile(String filepath){
        this.filepath = filepath;

    }

    public void loadfile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            while (line != null) {
                mdList.add(line);
                if (line.charAt(0) == '#'){
                    mdListType.add("title");

                } else if (line.charAt(0) == '[') {
                    mdListType.add("url");

                }
                isDeleted.add(false);
                isReading.add(false);
                readTimes.add(0);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

