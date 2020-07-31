public class TestMath{
     public static void main (String args[]) 
     {   
		 System.out.println("Math.ceil(3.1415)=" + Math.ceil(3.1415));
		 System.out.println("Math.floor(3.1415)=" + Math.floor(3.1415));
		 System.out.println("Math.round(987.654)=" + Math.round(987.654));
		 System.out.println("Math.max(-987.654,301)=" + Math.max(-987.654,301));
		 System.out.println("Math.min(-987.654,301)=" + Math.min(-987.654,301));
		 System.out.println("Math.sqrt(-4.01)=" + new Double(Math.sqrt(-4.01)).isNaN());
		 System.out.println("Math.PI=" + Math.PI);
		 System.out.println("Math.E=" + Math.E);
     }
}
