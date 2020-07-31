class Single{
	private static Single onlyone = new Single();
	private String name;
	public static Single getSingle() {
		return onlyone;
	}
	private Single() {}
}

public class TestSingle{
	public static void main(String args[]) {			         
		Single  s1 = Single.getSingle();
		Single  s2 = Single.getSingle();
		if (s1==s2){
			System.out.println("s1 is equals to s2!");
		 }
	}
}
