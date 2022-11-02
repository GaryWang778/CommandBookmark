package components.command;

import dataStructure.Item;
import dataStructure.Label;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class saveCommandTest {
    /**
     * Method under test: {@link saveCommand#execute(Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecute() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //       at java.util.Objects.checkIndex(Objects.java:372)
        //       at java.util.ArrayList.get(ArrayList.java:459)
        //       at components.command.saveCommand.execute(saveCommand.java:57)
        //   In order to prevent execute(Label)
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   execute(Label).
        //   See https://diff.blue/R013 to resolve this issue.

        saveCommand saveCommand = new saveCommand();
        Label label = new Label();
        label.items = new ArrayList<>();
        label.filepath = "/directory/foo.txt";
        saveCommand.execute(label);
    }

    /**
     * Method under test: {@link saveCommand#execute(Label)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testExecute2() {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access files outside the temporary directory (file '\directory\foo.txt', permission 'write').
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        saveCommand saveCommand = new saveCommand();
        Item item = new Item();
        item.title = "Dr";
        item.bookmarkName = "Bookmark Name";
        item.hyperlink = "Hyperlink";
        item.sons = new ArrayList<>();
        item.visited = 1;

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        Label label = new Label();
        label.items = itemList;
        label.filepath = "/directory/foo.txt";
        saveCommand.execute(label);
    }
}

