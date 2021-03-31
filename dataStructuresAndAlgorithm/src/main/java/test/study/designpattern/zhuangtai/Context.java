package test.study.designpattern.zhuangtai;

/**
 * Created by dell on 2020/1/7.
 * @author dell
 */
public class Context {

    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
