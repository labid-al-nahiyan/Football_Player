package NetworkIng;

import sample.Player;
import util.NetworkUtil;

public class WritePlayerToServer implements Runnable{
    private Thread thr;
    private NetworkUtil networkUtil;
    Player name;

    public WritePlayerToServer(NetworkUtil networkUtil, Object name) {
        this.networkUtil = networkUtil;
        this.name = (Player) name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            networkUtil.write(name);
        }
        catch (Exception e) {
            System.out.println("1");
            System.out.println(e);
        }
    }
}
