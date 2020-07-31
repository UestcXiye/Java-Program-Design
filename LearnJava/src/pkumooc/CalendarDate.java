package pkumooc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author liuwenchen
 * @create 2020-07-09 19:58
 */
public class CalendarDate {
    public static void main(String[] args) throws java.text.ParseException {
        Calendar calendar= Calendar.getInstance();
        calendar.roll(Calendar.MONTH,1);
        System.out.println(calendar.get(Calendar.MONTH)+"月"+calendar.get(Calendar.DATE)+"日");

        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        date=new SimpleDateFormat("yyyy-MM-dd").parse("2020-7-9");
        calendar.setTime(date);
        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG,Locale.ENGLISH));

    }
}
