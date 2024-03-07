package test.study.java.mianshiti2024;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang3.StringUtils;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author sun yang
 * @date 2024/2/29
 */
public class Test0229_3 {

    public static void main(String[] args) {
        test1_1();
    }

    public static int compare(String o1,String o2){
        int length = Math.min(o1.length(), o2.length());
        Collator collator = Collator.getInstance();

        for (int i = 0; i < length; i++) {
            char o1Char = o1.charAt(i);
            char o2Char = o2.charAt(i);

            if (o1Char == o2Char){
                continue;
            }

            String o1Pinyin = concatPinyinStringArray(PinyinHelper.toHanyuPinyinStringArray(o1Char));
            String o2Pinyin = concatPinyinStringArray(PinyinHelper.toHanyuPinyinStringArray(o2Char));
            if (StringUtils.isBlank(o1Pinyin) && StringUtils.isNotBlank(o2Pinyin)){
                return -1;
            }
            if (StringUtils.isNotBlank(o1Pinyin) && StringUtils.isBlank(o2Pinyin)){
                return 1;
            }
            if (StringUtils.isBlank(o1Pinyin) && StringUtils.isBlank(o2Pinyin)){
                return collator.compare(String.valueOf(o1Char),String.valueOf(o2Char));
            }
            String firstO1Pinyin = getFirstPinyin(o1Pinyin);
            String firstO2Pinyin = getFirstPinyin(o2Pinyin);
            if (firstO1Pinyin.equals(firstO2Pinyin)){
                continue;
            }
            return collator.compare(firstO1Pinyin,firstO2Pinyin);
        }

        if (o1.length() < o2.length()){
            return -1;
        }

        return 1;
    }

    private static String getFirstPinyin(String pinyin){
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(pinyin);

        if (matcher.find()) {
            String firstPair = matcher.group();
            return firstPair;
        }
        return pinyin;
    }


    public static void test1_1(){
        String[] nameArr = {"哔","百度","中国政府网","12","44","bb","gth","中风","重复","重量","41哈哈","b的说法","中国政府网"};

        List<String> names = Arrays.stream(nameArr).collect(Collectors.toList());

        Collections.sort(names,Test0229_3::compare);


        List<String> names2 = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {

            if ("bb".equals(names.get(i))){
                names2.add(0,names.get(i));
            }else{
                names2.add(names.get(i));
            }

        }

       names2.forEach(System.out::println);
    }


    @FunctionalInterface
    public interface Func<T>{

        String column(T obj);

    }


    private static String concatPinyinStringArray(String[] pinyinArr) {
        StringBuilder sb = new StringBuilder();
        if (pinyinArr != null && pinyinArr.length > 0) {
            for (String s : pinyinArr) {
                sb.append(s);
            }
        }
        return sb.toString();
    }


    @Data
    @AllArgsConstructor
    public static class Student{

        private Integer id;

        private String name;

    }


}
