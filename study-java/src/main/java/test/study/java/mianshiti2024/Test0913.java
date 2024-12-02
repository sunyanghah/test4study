package test.study.java.mianshiti2024;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author sun yang
 * @date 2024/9/13
 */
public class Test0913 {

    public static void main(String[] args) throws ParseException {
        System.out.println(DeptUserTypeEnum.WORK_WX.getFlag());
        System.out.println(DeptUserTypeEnum.WORK_WX.name());

        String condition = "{\"xpath\": [1145], \"fullText\": [1146, 165, 1147], \"template\": [], \"columnName\": [], \"columnValue\": [1146]}";

        Map<String, List<Long>> map = JSON.parseObject(condition, Map.class);
        System.out.println(map.get("xpath").size());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

        Calendar nowCalendar = Calendar.getInstance();

        nowCalendar.setTime(sdf.parse("2024-09-28 00:00:00 000"));

        System.out.println(sdf.format(nowCalendar.getTime()));
        nowCalendar.add(Calendar.HOUR_OF_DAY,1);

        nowCalendar.set(Calendar.MINUTE,0);
        nowCalendar.set(Calendar.SECOND,0);
        nowCalendar.set(Calendar.MILLISECOND,0);

        System.out.println(sdf.format(nowCalendar.getTime()));

    }

}
