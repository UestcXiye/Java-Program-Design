public class MyDate {
    private int day;
    private int month;
    private int year;
    public MyDate(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}     
	void addYear(){
		year ++;
	}
	public void display() {
		System.out.println(year + "-" + month + "-" +day);  
	}
	public static void main(String[] args) {
		MyDate m = new MyDate(2003, 9, 22);
		MyDate n = m;
		n.addYear();
		m.display();
		n.display();
    }    
}
