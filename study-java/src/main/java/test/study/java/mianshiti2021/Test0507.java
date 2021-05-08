package test.study.java.mianshiti2021;

import lombok.Getter;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @Description:
 * @Title: Test0507
 * @Package test.study.java.mianshiti2021
 * @date 2021-05-0716:58
 */
public class Test0507 {

    public static void main(String[] args) {
        GenderType.getByMessage("GENDER_TYPE_1");
    }

    enum GenderType {
        GENDER_TYPE_1(1, "男"),
        GENDER_TYPE_2(2, "女");
        @Getter
        public Integer code;

        @Getter
        public String message;

        GenderType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        private static Map<Integer, GenderType> keyMap = new HashMap<>();

        static {
            EnumSet.allOf(GenderType.class).forEach(e -> keyMap.put(e.code, e));
        }

        public static GenderType getByCode(Integer code) {
            return keyMap.get(code);
        }

        public static GenderType getByMessage(String message){
//            System.out.println(valueOf(message).getMessage());

            return Arrays.stream(values()).filter(val ->
                val.getMessage().equals(message)
            ).findFirst().orElse(null);

        }
    }

}