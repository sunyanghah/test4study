package test.study.designpattern.zhuangtai;

/**
 * Created by dell on 2020/1/7.
 * @author dell
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Start State";
    }

}
