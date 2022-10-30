//接收命令行的输入


import java.util.Scanner;

public class commandLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 接收指令
        System.out.println("please input order: ");

        while (scan.hasNextLine()) {
            String order = scan.nextLine();

            //exit退出指令
            if (order.equals("exit")){
                break;
            }

            //调用指令解析模块
            commandParse comParse = new commandParse(order);
            comParse.comParser();

            //依次输入指令
            System.out.println("\n");
            System.out.println("please input order:  ");
        }
        scan.close();
    }
}
