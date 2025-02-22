package test.study.java.mianshiti2024;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/11/29
 */
public class Test1129 {


    /**
     * 根据给定的角度返回对应的值。
     * @param angle 角度值，范围在0-360之间。
     * @return 对应的角度值。
     */
    public static double getAngleValue(int angle) {
        double result;
        angle = Math.abs(angle);
        if (angle <= 180){
            result = (180 - Math.abs(angle - 180))/180D;
        }else{
            result = (180 - Math.abs(angle - 360))/180D;
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> waterTextList = new ArrayList<>();
        waterTextList.add("111");
        waterTextList.add("222");
        waterTextList.add("333");

        String[] strings = waterTextList.toArray(new String[0]);
        System.out.println(strings);
    }

}
