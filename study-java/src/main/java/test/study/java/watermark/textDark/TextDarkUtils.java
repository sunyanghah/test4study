package test.study.java.watermark.textDark;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/30
 */
public class TextDarkUtils {

    private static final char CODE1 = '\u200B';
    private static final char CODE2 = '\u200C';
    private static final char CODE3 = '\u200D';
    private static final char CODE4 = '\u200E';
    private static final char CODE5 = '\u200F';
    private static final char CODE6 = '\u202A';
    private static final char CODE7 = '\u206C';
    private static final char CODE8 = '\u206D';
    private static final char CODE9 = '\u206E';
    private static final char CODE10 = '\u206F';
    private static final char CODE11 = '\ufeff';
    private static final char CODE12 = '\u2060';

    private static List<Character> docxCodeList = Arrays.asList(CODE2,CODE3);

    private static String toBinary(Long watermarkId) {
        if (watermarkId == null) {
            return null;
        }
        return Long.toBinaryString(watermarkId);
    }

    private static Long toLong(String binary) {
        if (binary == null) {
            return null;
        }
        return Long.parseLong(binary, 2);
    }

    // 123  -> 1111011
    public static String encode(Long watermarkId) {
        String binary = toBinary(watermarkId);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < binary.length(); j++) {
            char b = binary.charAt(j);
            if (b == '0') {
                sb.append(CODE3);
            } else {
                sb.append(CODE2);
            }
        }
        return CODE4+sb.toString()+CODE5;
    }

    private static String findCode(String text) {
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean codeStart = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == CODE4) {
                codeStart = true;
            }
            if (codeStart && docxCodeList.contains(chars[i])) {
                if (chars[i] == CODE3) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
            if (chars[i] == CODE5) {
                break;
            }
        }
        return sb.toString();
    }

    public static Long decode(String text) {
        if (text == null) {
            return null;
        }
        String code = findCode(text);
        if (code == null || code.length() == 0) {
            return null;
        }
        return toLong(code);
    }

}
