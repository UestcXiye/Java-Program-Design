class MyDate {
    int day,month,year;
    public MyDate(int i,int j,int k) {
    	day = i;
    	month = j;
    	year = k;
    }
}

class MyOkDate extends MyDate{
	public MyOkDate(int i,int j,int k ){
		super(i,j,k);
	}
	public boolean equals( Object obj ){
		if( obj instanceof MyOkDate ){
			MyOkDate m = (MyOkDate)obj; 
			if(m.day==day && m.month==month && m.year==year )
				return true;
		}
		return false;
	}
}

public class TestEqualsObject{
	public static void main(String[] args) {
 	   MyDate m1 = new MyDate(24, 3, 2001);
 	   MyDate m2 = new MyDate(24, 3, 2001);
	   System.out.println( m1.equals(m2) ); //不相等,显示false
	   m1 = new MyOkDate( 24, 3, 2001 );
	   m2 = new MyOkDate( 24, 3, 2001 );
	   System.out.println( m1.equals(m2) ); //相等,显示true
   }
}
