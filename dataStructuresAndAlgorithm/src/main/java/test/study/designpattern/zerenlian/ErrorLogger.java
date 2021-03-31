package test.study.designpattern.zerenlian;

/**
 * Created by dell on 2020/1/7.
 * @author dell
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
