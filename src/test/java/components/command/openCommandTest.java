package components.command;

import dataStructure.Item;
import dataStructure.Label;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class openCommandTest {
    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    void testopenCommand01() {
        openCommand actualOpenCommand = new openCommand(new String[]{"open", "src/main/java/个人收藏.md"});
        Label label = new Label();
        Item root = new Item();
        actualOpenCommand.execute(label);
        assertEquals("src/main/java/个人收藏.md", label.filepath);
        assertEquals(13, label.items.size());

    }

    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    void testopenCommand02() {
        openCommand actualOpenCommand = new openCommand(new String[]{"open"});
        Label label = new Label();
        actualOpenCommand.execute(label);
        assertEquals(null, label.filepath);
        assertTrue(label.items.isEmpty());
    }

    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    void testopenCommand03() {
        openCommand actualOpenCommand = new openCommand(new String[]{"open", "src/main/java/test.md"});
        Label label = new Label();
        actualOpenCommand.execute(label);
        assertTrue(label.items.isEmpty());
        assertEquals("src/main/java/test.md", label.filepath);
    }

    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    void testopenCommand04() {
        openCommand actualOpenCommand = new openCommand(new String[]{"open","ce%&*csnbj^$^&$(GF$GK($F_!"});
        Label label = new Label();
        actualOpenCommand.execute(label);
        assertTrue(label.items.isEmpty());
    }

    /**
     * Method under test: {@link openCommand#openCommand(String[])}
     */
    @Test
    void testopenCommand05() {
        openCommand actualOpenCommand = new openCommand(new String[]{
        });
        Label label = new Label();
        actualOpenCommand.execute(label);
        assertTrue(label.items.isEmpty());
    }
}

