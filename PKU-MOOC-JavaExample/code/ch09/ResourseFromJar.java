import java.awt.Image;
import java.awt.Toolkit;
import java.io. * ;

public class ResourseFromJar {

	//²Î¼û 
	public static Image getImageFromJar(String s, Class class1) {
		Image image = null;
		InputStream inputstream = class1.getResourceAsStream(s);
		if (inputstream != null) {
			ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
			try {
				byte abyte0[] = new byte[1024];
				for (int i = 0; (i = inputstream.read(abyte0)) >= 0;) {
					bytearrayoutputstream.write(abyte0, 0, i);
				}

				image = Toolkit.getDefaultToolkit().createImage(bytearrayoutputstream.toByteArray());
			} catch(IOException ioexception) {
				ioexception.printStackTrace();
			}
		}
		return image;
	}

	public static String getTextFromJar(String s, Class class1) {
		String s1 = "";
		InputStream inputstream = class1.getResourceAsStream(s);
		if (inputstream != null) {
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
			String s2;
			try {
				while ((s2 = bufferedreader.readLine()) != null) {
					s1 = s1 + s2 + "\n";
				}
			} catch(IOException ioexception) {
				ioexception.printStackTrace();
			}
		}
		return s1;
	}
}