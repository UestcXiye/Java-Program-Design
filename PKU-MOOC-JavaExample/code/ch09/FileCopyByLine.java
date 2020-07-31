import java.io.*;
public class FileCopyByLine {
	public static void main(String[] args) {
		try {
			FileReader input = new FileReader("FileCopyByLine.java");
			BufferedReader br = new BufferedReader(input);
			FileWriter output = new FileWriter("temp.txt");
			BufferedWriter bw = new BufferedWriter(output);
			
			String s = br.readLine();			
			while ( s!=null ) {
				bw.write(s);
				bw.newLine();
				System.out.println(s);
				s = br.readLine();
			}			
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
