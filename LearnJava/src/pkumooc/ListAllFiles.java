package pkumooc;

import java.io.File;

/**
 * @author liuwenchen
 * @create 2020-07-12 10:08
 */
public class ListAllFiles {
    public static void main(String[] args) {
        ListFiles(new File("C:\\Users\\81228\\Documents\\Program\\C Program"));
    }

    public static void ListFiles(File file)
    {
        if(!file.exists() || !file.isDirectory()) return;

        String[] files=file.list();
        for(int i=0;i<files.length;i++)
        {
            File f=new File(file,files[i]);
            if(f.isFile()) {
                System.out.println(file + "\\" + f.getName() + "\t" + f.length());
            } else {
                System.out.println(file + "\\" + f.getName() + "\t<dir>");
                ListFiles(f);
            }
        }
    }
}
