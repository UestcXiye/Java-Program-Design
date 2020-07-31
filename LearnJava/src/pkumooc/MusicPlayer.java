package pkumooc;

import javax.media.CannotRealizeException;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenchen
 * @create 2020-07-31 11:32
 */

public class MusicPlayer implements ControllerListener {
    private Player player;
    private boolean first;
    private List<String> mp3List;
    private int idx=0;

    MusicPlayer(List<String> mp3List)
    {
        this.mp3List=mp3List;
    }

    public static void main(String[] args) {
        List<String> mp3List = new ArrayList<>();
        mp3List.add("C:\\Users\\81228\\Desktop\\vocaloid工程\\8月31日\\小懒Eliza - 8月31日.wav");
        mp3List.add("C:\\Users\\81228\\Desktop\\vocaloid工程\\你在看孤独的风景\\你在看孤独的风景.wav");
        mp3List.add("C:\\Users\\81228\\Desktop\\vocaloid工程\\以父之名\\以父之名.wav");

        MusicPlayer musicPlayer = new MusicPlayer(mp3List);
        musicPlayer.start();
    }

    public void start()
    {
        try {
            File playFile=new File(mp3List.get(idx));
            player= Manager.createRealizedPlayer(playFile.toURI().toURL());
        } catch (CannotRealizeException e) {
            System.out.println("Cannot create a player");
        } catch (NoPlayerException e) {
            System.out.println("Cannot play files");
        } catch (IOException ignored){}
        if (player == null) {
            return;
        }
        first=false;
        player.addControllerListener(this);
        player.prefetch();
    }

    @Override
    public void controllerUpdate(ControllerEvent e)
    {
        if(e instanceof EndOfMediaEvent)
        {
            idx++;
            if(idx<this.mp3List.size())
            {
                this.start();
            }
            return;
        }
        if(e instanceof PrefetchCompleteEvent)
        {
            player.start();
        }
    }
}
