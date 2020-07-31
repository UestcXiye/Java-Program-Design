public class BitwiseOp{
	static String binary[]={"0000","0001","0010","0011",
	"0100","0101","0110","0111",
	"1000","1001","1010","1011",
	"1100","1101","1110","1111"};

	static final int FLAG1=1; //make FLAG1 a constant(0x0001)
	static final int FLAG2=2; //make FLAG2 a constant(0x0010)
	static final int FLAG4=8; //make FLAG4 a constant(0x1000)
	public static void main( String args[] ){
		int flags=0; //clear all flags
		System.out.println("Clear all flags... flags="+binary[flags]);
		flags=flags | FLAG4; //set flag4
		System.out.println("Set flag4... flags="+binary[flags]);
		flags=flags ^ FLAG1; //revert flag1
		System.out.println("Revert flag1... flags="+binary[flags]);
		flags=flags ^ FLAG2; //revert flag2
		System.out.println("Revert flag2... flags="+binary[flags]);
		int cf1=~FLAG1;
		flags=flags & cf1; //clear flag1
		System.out.println("Clear flag1... flags="+binary[flags]);
		int f4=flags & FLAG4;
		f4=f4>>>3; //get flag4
		System.out.println("Get flag4... flag4="+f4);
		int f1=flags & FLAG1; //get flag1
		System.out.println("Get flag1... flag1="+f1);
	}
}
