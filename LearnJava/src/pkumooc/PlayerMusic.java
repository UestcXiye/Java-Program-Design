package pkumooc;

import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import java.io.File;
import java.io.IOException;

/**
 * @author liuwenchen
 * @create 2020-07-31 0:00
 */

public class PlayerMusic {
    public static void main(String[] args) throws NoPlayerException,IOException {
        File file=new File("C:\\Users\\81228\\Desktop\\vocaloid工程\\以父之名\\以父之名.wav");
        Player player= Manager.createPlayer(file.toURI().toURL());
        player.start();
    }
}