package NetworkIng;

import sample.ForBuyPlayer;
import sample.Main;
import sample.Player;
import util.NetworkUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Client{

    public String clientName;
    private NetworkUtil networkUtil;
    public Client(String serverAddress, int serverPort, String clientName) {
        try {
            this.clientName= clientName;
            networkUtil = new NetworkUtil(serverAddress, serverPort);
            networkUtil.write(this.clientName);
            new ReadThreadClient(networkUtil);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void sellPlayer(Object player) {
        if(player instanceof Player)
            new WritePlayerToServer(networkUtil, player);
        else if(player instanceof ForBuyPlayer){
            new WriteBuyPlayerToServer(networkUtil,player);
        }
    }
    public void CloseConnection(){

        Server.clientMap.remove(networkUtil);

    }
}