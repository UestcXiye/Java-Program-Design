import java.io.*;
class TryWithResourcesTest {
    public static void main(String ... args)
		throws IOException
	{
		String path = "c:\\aaa.txt";
		System.out.println( ReadOneLine1( path ) );
		System.out.println( ReadOneLine2( path ) );
    }
	static String ReadOneLine1(String path){
		BufferedReader br=null;
        try {
            br=new BufferedReader(new FileReader(path));
            return br.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
				try{ 
					br.close();
				}catch(IOException ex){
				}
			}
        }
		return null;
	}
	static String ReadOneLine2(String path)
		throws IOException
	{
		try(BufferedReader br= new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
	}
}