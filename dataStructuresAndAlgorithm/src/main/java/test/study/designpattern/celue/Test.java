package test.study.designpattern.celue;

/**
 * Created by dell on 2019/10/22.
 */
public class Test {

    public static void main(String[] args) {
        ColorFactory colorFactory = new ColorFactory();
        colorFactory.sayYourColor(ColorEnum.BLACK);
        colorFactory.sayYourColor(ColorEnum.PINK);
        colorFactory.sayYourColor(ColorEnum.YELLOW);
    }

}
