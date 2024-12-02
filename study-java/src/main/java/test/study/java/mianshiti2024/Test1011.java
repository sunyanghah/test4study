package test.study.java.mianshiti2024;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/10/11
 */
public class Test1011 {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static void main(String[] args) throws Exception{
        String startTime = "2024-12-29 06:00:00";
        String endTime = "2025-2-1 23:59:59";

        SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        getAllDatesBetween(start.parse(startTime), end.parse(endTime)).forEach(System.out::println);

    }

    public static List<String> getAllDatesBetween(Date start, Date end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        List<String> dates = new ArrayList<>();
        for (LocalDate date = startDate; date.isBefore(endDate) || date.isEqual(endDate); date = date.plusDays(1)) {
            dates.add(date.format(formatter));
        }

        return dates;
    }

}
