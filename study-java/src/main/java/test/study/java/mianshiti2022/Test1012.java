package test.study.java.mianshiti2022;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunYang
 * @date 2022/10/12 11:22
 */
public class Test1012 {

    private static Pattern compile = Pattern.compile("http://10.100.32.63:8888.+/(.*\\..+?)\"");
    private static Pattern compile2 = Pattern.compile("http://10.100.32.63:8888/(.*\\..+?)\"");


    public static void main(String[] args) {
        String urlStr = "### 色块『 color 』::配置说明\n" +
                "\n" +
                ">#### 控件效果\n" +
                "<img src=\"http://10.100.32.63:8888/group1/M00/00/03/CmQgP2LrdeOEL3tRAAAAABsZDew281.png\" width = \"510\"/>\n" +
                "<img src=\"http://10.100.32.63:8888/group1/M00/00/05/CmQgP2Ls0c-EQOvrAAAAAOoLGLY289.png\" width = \"510\"/>\n" +
                "\n" +
                ">#### 属性描述\n" +
                "|-|字段名|含义|默认值|描述|必填|\n" +
                "|-|-|-|-|-|-|\n" +
                "|*|type|色块|color| 控件类型 |是|\n" +
                "|*|key|唯一标识|-| 取值控件唯一标识 |是|\n" +
                "|*|label|显示名称| -| - |-|\n" +
                "|*|value|值| - | 控件值/默认值 |-|\n" +
                "|*|~~placeholder~~|~~引导文字~~|-| - |-|\n" +
                "|*|description|描述|-| - |-|\n" +
                "|*|hidden|隐藏|false| 控件隐藏 |-|\n" +
                "|*|readonly|只读|false| 控件只读 |-|\n" +
                "|*|required|必填|false| 控件必填 |-|\n" +
                "|*|prefix|控件前缀|-| - |-|\n" +
                "|*|suffix|控件后缀|-| - |-|\n" +
                "||rgba|颜色空间|false| RGBA是代表Red（红色）Green（绿色）Blue（蓝色）和Alpha的色彩空间。</br>Alpha通道一般用作不透明度参数。|是|\n" +
                "\n" +
                ">#### 代码结构\n" +
                "```JSON\n" +
                "{\n" +
                "  \"type\": \"color\",\n" +
                "  \"key\": \"\",\n" +
                "  \"label\": \"色块\",\n" +
                "  //\"placeholder\": \"\", 不支持的属性\n" +
                "  \"description\": \"\",\n" +
                "  \"value\": \"\",\n" +
                "  \"hidden\": false,\n" +
                "  \"readonly\": false,\n" +
                "  \"required\": false,\n" +
                "  \"prefix\": \"\",\n" +
                "  \"suffix\": \"\",\n" +
                "  \"rgba\":false\n" +
                "}\n" +
                "```";
        String handleUrl = test1(urlStr);
        System.out.println(handleUrl);

        System.out.println("--------");
        System.out.println(test2(urlStr));
    }

    private static String test1(String urlStr){
        Matcher matcher = compile.matcher(urlStr);
        if (matcher.find()){
            System.out.println("-+++---"+matcher.groupCount());
            return matcher.group(1);
        }
        return "";
    }
    private static String test2(String urlStr){
        Matcher matcher = compile2.matcher(urlStr);
        if (matcher.find()){
            return matcher.group(1);
        }
        return "";
    }
}
