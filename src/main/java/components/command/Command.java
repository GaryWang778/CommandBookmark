package components.command;
import dataStructure.Label;

//抽象命令接口
public interface Command {

    void execute(Label bookMark);

}