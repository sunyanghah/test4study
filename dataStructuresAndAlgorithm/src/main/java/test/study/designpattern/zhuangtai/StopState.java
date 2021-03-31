package test.study.designpattern.zhuangtai;

/**
 * Created by dell on 2020/1/7.
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Stop State";
    }
}
