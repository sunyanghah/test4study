package test.study.designpattern.celue;

/**
 * Created by dell on 2019/10/22.
 * @author dell
 */
public class ColorFactory {

    public void sayYourColor(ColorEnum colorEnum){
        colorEnum.getInstance().sayMyColor();
    }

}
