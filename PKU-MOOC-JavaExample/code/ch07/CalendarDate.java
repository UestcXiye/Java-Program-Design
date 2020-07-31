import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import static java.util.Calendar.*;

class CalendarDate 
{
	public static void main(String[] args) throws java.text.ParseException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.roll( MONTH, 1);
		System.out.println( calendar.get(MONTH) + "ÔÂ" + calendar.get( DAY_OF_MONTH ) + "ÈÕ");

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		System.out.println( formatter.format(date ));

		date = new SimpleDateFormat("yyyy-MM-dd").parse( "2013-4-23" );
		calendar.setTime( date );
		System.out.println( calendar.getDisplayName(DAY_OF_WEEK, LONG, Locale.CHINA) );

	}
}
