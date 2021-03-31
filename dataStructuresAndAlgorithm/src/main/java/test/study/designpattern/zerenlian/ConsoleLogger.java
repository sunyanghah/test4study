package test.study.designpattern.zerenlian;

/**
 * Created by dell on 2020/1/7.
 * @author dell
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
