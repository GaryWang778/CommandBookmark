package src;


public class BookMark {

    protected BookMarkTree bookmarktree;

    BookMark(){

    }


    public void add(){
        System.out.println("add command received!");
    }

    public void delete(){
        System.out.println("delete command received!");
    }

    public void load(){
        System.out.println("load command received!");
    }

    public void save(){
        System.out.println("save command received!");
    }

    public void show(){
        System.out.println("show command received!");
    }

}
