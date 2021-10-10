package NetworkIng;

import sample.ForBuyPlayer;
import sample.Player;
import util.NetworkUtil;

public class WriteBuyPlayerToServer implements Runnable{
    private Thread thr;
    private NetworkUtil networkUtil;
    ForBuyPlayer name;

    public WriteBuyPlayerToServer(NetworkUtil networkUtil, Object name) {
        this.networkUtil = networkUtil;
        this.name = (ForBuyPlayer) name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            networkUtil.write(name);
        }
        catch (Exception e) {
            System.out.println("2");
            System.out.println(e);
        }
    }
}
