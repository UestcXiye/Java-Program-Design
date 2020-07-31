package pkumooc;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author liuwenchen
 * @create 2020-07-31 13:17
 */

public class TestJLayer {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\81228\\Desktop\\vocaloid工程\\以父之名\\以父之名.mp3");
        try {
            Player player=new Player(new FileInputStream(file));
            player.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}