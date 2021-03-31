package test.study.designpattern.celue;

/**
 * Created by dell on 2019/10/22.
 * @author dell
 */
public enum ColorEnum {

    BLACK(new ColorBlack()),
    RED(new ColorRed()),
    WHITE(new ColorWhite()),
    YELLOW(new ColorYellow()),
    PINK(new ColorPink());



    ColorEnum(ColorInterface colorInterface){this.colorInterface = colorInterface;}

    private ColorInterface colorInterface;

    public ColorInterface getInstance(){
        return colorInterface;
    }

}
