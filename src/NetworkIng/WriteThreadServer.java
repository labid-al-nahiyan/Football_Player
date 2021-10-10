package NetworkIng;

import sample.ForBuyPlayer;
import sample.ForPlayer;
import sample.Player;
import util.NetworkUtil;

import javax.swing.plaf.metal.MetalBorders;
import java.io.IOException;
import java.util.*;

public class WriteThreadServer implements Runnable{
    private Thread thr;
    private NetworkUtil networkUtil;
    public String name;
    public List<String> list;
    private  ReadThreadServer readThreadServer;

    public WriteThreadServer(String name, NetworkUtil networkUtil,ReadThreadServer readThreadServer) {
        this.name = name;
        this.networkUtil = networkUtil;
        this.list = Server.player;
        this.readThreadServer=readThreadServer;
        this.thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run() {
        try {
            while (true){
                Object o = networkUtil.read();
                if (o instanceof Player) {
                    Player p = (Player) o;
                    ForBuyPlayer dp = new ForBuyPlayer(p.getName(), p.getCountry(), p.getAge(), p.getHeight(), p.getClub(), p.getPosition(), p.getJersy(), p.getSalary());
                    Server.buyPlayer.add(dp);
                    List<String>players= Server.player;
                    for(String pp: players){
                        String[] token = pp.split(",");
                        if (token[0].equalsIgnoreCase(p.getName()) && token[4].equalsIgnoreCase(p.getClub())) {
                            players.remove(pp);
                            break;
                        }
                    }
                    Server.player= players;
                    new Thread(() -> {
                    //    readThreadServer.SendData(networkUtil,name);
                        for (Map.Entry me : Server.clientMap.entrySet()) {
                            System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
                            readThreadServer.SendData((NetworkUtil) me.getValue(),(String) me.getKey());
                        }
                    }).start();
                }
                else if (o instanceof ForBuyPlayer) {
                    ForBuyPlayer player = (ForBuyPlayer) o;
                    String newPlayer = player.getName() + "," + player.getCountry() + "," + player.getAge() + "," + player.getHeight() + "," + name + "," + player.getPosition() + "," + player.getJersy() + "," + player.getPrize();
                    Server.player.add(newPlayer);
                    List<ForBuyPlayer>players = Server.buyPlayer;

                    for(ForBuyPlayer p: players){
                        if (p.getName().equalsIgnoreCase(player.getName()) && p.getCountry().equalsIgnoreCase(player.getCountry())) {
                            players.remove(p);
                            break;
                        }
                    }
                    Server.buyPlayer= players;
                    new Thread(() -> {
                       // readThreadServer.SendData(networkUtil,name);
                        for (Map.Entry me : Server.clientMap.entrySet()) {
                            System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
                            readThreadServer.SendData((NetworkUtil) me.getValue(),(String) me.getKey());
                        }
                    }).start();
                }
            }
        } catch (Exception e) {
            System.out.println("hello wts");
            e.printStackTrace();
        }
    }

}
