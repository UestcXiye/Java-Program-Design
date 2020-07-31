public class ExceptionIndexOutOf{
    public static void main(String[] args)    {
        String friends[]={"lisa","bily","kessy"};
      	try {
      	   for(int i=0;i<5;i++) {
           		System.out.println(friends[i]);
           }
      	} catch(java.lang.ArrayIndexOutOfBoundsException e)  {
           System.out.println("index err");
      	}
      	System.out.println("\nthis is the end");
       }
}
