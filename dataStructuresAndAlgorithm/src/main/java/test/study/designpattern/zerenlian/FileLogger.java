package test.study.designpattern.zerenlian;

/**
 * Created by dell on 2020/1/7.
 * @author dell
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
