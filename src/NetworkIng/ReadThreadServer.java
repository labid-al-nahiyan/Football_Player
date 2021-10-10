package NetworkIng;

import sample.ForBuyPlayer;
import sample.ForPlayer;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadThreadServer{
    private Thread thr;
    private NetworkUtil networkUtil;
    public String name;
    public List<String>list;
    public List<ForBuyPlayer>buyList;

//    public ReadThreadServer(String name, NetworkUtil networkUtil) {
//        this.name = name;
//        this.networkUtil = networkUtil;
//        this.list = Server.player;
//        this.buyList = Server.buyPlayer;
     //   this.thr = new Thread(this);
      //  thr.start();
 //   }

//    public void run() {
//        try {
//           while (true) {
//               SendData(networkUtil,name);
//           }
//        } catch (Exception e) {
//            System.out.println("hello rts");
//            System.out.println(e);
//        }
//    }
    public  synchronized void SendData(NetworkUtil networkUtil, String name)  {

        List<String>filter = new ArrayList<>();

        for(String p:Server.player){
            String token[]= p.split(",");
            if(token[4].equalsIgnoreCase(name)){
                filter.add(p);
            }
        }

        List<ForBuyPlayer>buyPlayers= new ArrayList<>();
        for(ForBuyPlayer p:Server.buyPlayer){
            if(!p.getClub().equalsIgnoreCase(name)){
                buyPlayers.add(p);
            }
        }
        ForPlayer player = new ForPlayer(filter,buyPlayers);
        try {
            networkUtil.write(player);
        } catch (IOException e) {
            System.out.println("44");
            e.printStackTrace();
        }

    }
}
