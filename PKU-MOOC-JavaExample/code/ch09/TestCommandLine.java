public class TestCommandLine{
	public static void main(String[] args) {
		for ( int i = 0; i < args.length; i++ ) {
			System.out.println("args[" + i + "] = " + args[i]);
		}
	}
}

//运行时，使用java TestCommandLine lisa "bily" "Mr Brown"