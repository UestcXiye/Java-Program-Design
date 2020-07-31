
interface Player {
    void play(String video);
}

//本程序演示动态调用一个类，并生成实例
class PlayerMaster {
    public static void main(String[] args) throws ClassNotFoundException, 
                            InstantiationException, IllegalAccessException {

        //String playerImpl = System.getProperty("PlayerImpl");
		//类名可以从配置中来，甚至从一个目录下查找所有的文件。为了编译简单起见，这里写固定了。
		String playerImpl = "SimplePlayer";

        Player player = (Player) Class.forName(playerImpl).newInstance();

		String movie = "春秋";

        player.play(movie);
    }
}

class SimplePlayer implements Player {
    @Override
    public void play(String video) {
        System.out.println("正在播放 " + video);
    }
    
}
