package test.study.java.mianshiti2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sun yang
 * @date 2025/2/8
 */
public class Test0208_2 {

    private static int maxTextLength = 20;
    private static int minTextLength = 10;
    private static String insertStr = "|";

    public static void main(String[] args) {
//        String text = ",你好，这个无比美丽又充满希望的世界！这是一个@#测试：看看,有.多撒范德萨发撒发生地方萨芬大丰收大法师水电费萨芬撒旦法收到发撒手动阀打撒范德萨发撒范德萨撒旦法士大夫萨达多少标&点符号？";
//        String text = "这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段。";
//        String text = "这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息这是第一段信息";
//        String text = "你好啊";
//        String text = "你好世界,这是一个测试,看看有多少标点符号";
//        String text = "你好世界.";
//        String text = "hello world, this is a test, see how many punctuation marks there are?";
//        String text = " ff ";
//        String text = "这是正正好好十个字呢";
//        String text = "这是正正好好十一个字呢";
//        String text = "如果不信你就数一数吧这是正正好好二十个字";
//        String text = "如果不信你就数一数吧这是正正好好，二十一个字";
//        String text = "好";
        String text = "手打范德萨发山东哈哈哈";

        StringBuilder finalText = new StringBuilder();

        if (text.length()<maxTextLength){
            int centerIndex = text.length() / 2;
            finalText.append(text,0,centerIndex).append(insertStr).append(text,centerIndex,text.length());
            System.out.println(finalText);
            return;
        }

        List<String> textList = splitText(text);

        int textLength = 0;

        for (int i = 0; i < textList.size(); i++) {
            String str = textList.get(i);
            textLength += str.length();
            if (str.length()< maxTextLength*1.5 && textLength >= maxTextLength) {
                int centerIndex = str.length() / 2;
                finalText.append(str,0,centerIndex).append(insertStr).append(str,centerIndex,str.length());
            } else if (str.length() >= maxTextLength){
                for (int j = 0; j < str.length(); j+=maxTextLength) {
                    if (j + maxTextLength < str.length()){
                        finalText.append(str, j,j+maxTextLength).append(insertStr);
                    }else{
                        finalText.append(str, j,str.length());
                    }
                }
            }else if (str.length() <= minTextLength){
                finalText.append(str);
                continue;
            }else if (str.length() > minTextLength){
                finalText.append(str).append(insertStr);
            }

            textLength = 0;
        }

        System.out.println(finalText);

    }

    // 判断字符是否是标点符号
    public static boolean isPunctuation(char c) {
        // 使用Character类的isLetterOrDigit方法判断字符是否是字母或数字
        // 如果不是字母或数字，则可能是标点符号
        return ' ' == c || (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c));
    }

    public static List<String> splitText(String text){
        // 创建一个集合来存储标点符号
        List<String> textList = new ArrayList<>();
        char[] chars = text.toCharArray();
        int tempIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isPunctuation(chars[i])) {
                String substring = text.substring(tempIndex, i);
                if (substring.length() > 0) {
                    textList.add(substring);
                }
                textList.add(String.valueOf(chars[i]));
                tempIndex = i + 1;
            }else if (i == chars.length-1){
                String substring = text.substring(tempIndex, i+1);
                if (substring.length() > 0) {
                    textList.add(substring);
                }
            }
        }
        return textList;
    }

}
