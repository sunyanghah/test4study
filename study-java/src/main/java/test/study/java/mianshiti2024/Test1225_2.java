package test.study.java.mianshiti2024;

import java.math.BigDecimal;

/**
 * @author sun yang
 * @date 2024/12/25
 */
public class Test1225_2 {

    public static void main(String[] args) {
        double a = 7.01;
        System.out.println(new BigDecimal(a).setScale(0, BigDecimal.ROUND_UP).intValue());

//        test222();
    }
    public static void test222() {
        // 原矩形 A 的长和宽
        double widthA = 10;
        double heightA = 1;

        // 旋转角度 (45度)
        double angle = Math.toRadians(45);

        // 原矩形 A 的四个顶点 (以中心为原点计算)
        double[][] corners = {
                {widthA / 2, heightA / 2},
                {widthA / 2, -heightA / 2},
                {-widthA / 2, heightA / 2},
                {-widthA / 2, -heightA / 2}
        };

        // 旋转矩阵计算旋转后顶点的坐标
        double cosTheta = Math.cos(angle);
        double sinTheta = Math.sin(angle);
        double minX = Double.MAX_VALUE, maxX = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE, maxY = Double.MIN_VALUE;

        for (double[] corner : corners) {
            double x = corner[0] * cosTheta - corner[1] * sinTheta;
            double y = corner[0] * sinTheta + corner[1] * cosTheta;

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        // 外接矩形的宽和高
        double rotatedWidth = maxX - minX;
        double rotatedHeight = maxY - minY;

        // 输出结果
        System.out.printf("矩形 B 的最小宽度: %.2f\n", rotatedWidth);
        System.out.printf("矩形 B 的最小高度: %.2f\n", rotatedHeight);
    }

}
