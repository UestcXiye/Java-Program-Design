import java.time.*;
import java.time.format.*;

class CalendarDate8{
	public static void main(String[] args) throws java.text.ParseException
	{
		//使用默认时区时钟瞬时时间创建 Clock.systemDefaultZone() -->即相对于 ZoneId.systemDefault()默认时区  
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
		
		//自定义时区  
        LocalDateTime now2 = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(now2);//会以相应的时区显示日期  

		//构造一个对象  
        LocalDateTime d1 = LocalDateTime.of(2013, 12, 31, 23, 59, 59);

		//解析String--->LocalDateTime  
        LocalDateTime d4 = LocalDateTime.parse("2013-12-31T23:59:59");
        System.out.println(d4);

		//使用DateTimeFormatter API 解析 和 格式化  
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime d6 = LocalDateTime.parse("2013/12/31 23:59:59", formatter);
        System.out.println(formatter.format(d6));

		//时间获取的一部分
        System.out.println(d6.getYear());
        System.out.println(d6.getMonth()); //这不是整数，而是枚举
        System.out.println(d6.getDayOfYear());
        System.out.println(d6.getDayOfMonth());
        System.out.println(d6.getDayOfWeek());
        System.out.println(d6.getHour());
        System.out.println(d6.getMinute());
        System.out.println(d6.getSecond());
        System.out.println(d6.getNano()); //纳秒
		
		//时间增减  
        LocalDateTime d7 = d6.minusDays(1);
        LocalDateTime d8 = d6.plusHours(1).plusMinutes(30);
		System.out.println(d7);
		System.out.println(d8);
	}
}