package NetworkIng;

import sample.*;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadThreadClient implements Runnable{
    private Thread thr;
    private NetworkUtil networkUtil;

    public ReadThreadClient(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o;
                if((o=networkUtil.read())!=null) {
                    ForPlayer a = (ForPlayer) o;
                    Main.player = a.getPlayerList();
                    Main.buyPlayer = a.getBuyPlayerList();
                }
            }
        } catch (Exception e) {
            System.out.println("3");
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
