package src;

import java.util.List;


class BookMarkNode{
    public String nodeid;
    public String parentid;
    public String bookmarkcontent;
    List<BookMarkNode> childnodes=null;
}

public class BookMarkTree{
    private BookMarkNode bookmarknode=null;
}