package NetworkIng;

import sample.FileAction;
import sample.ForBuyPlayer;
import sample.ForPlayer;
import sample.Player;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static Map<String, NetworkUtil> clientMap=new HashMap<>();
    public static List<String>player = new Vector<>();
    public ReadThreadServer readThreadServer = new ReadThreadServer();

    public static List<ForBuyPlayer> buyPlayer = new Vector<>();

    Server() {

            try {
                ServerSocket serverSocket = null;
                try {
                    serverSocket = new ServerSocket(44581);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("server");
                    try {
                        serve(clientSocket);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }

                }
            } catch (Exception e) {
                System.out.println("Server starts:" + e);
            }


    }
    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        String clientName = ((String) networkUtil.read()).toUpperCase();
        clientMap.put(clientName, networkUtil);
        System.out.println(clientMap.toString());

        //    new ReadThreadServer(clientName, networkUtil);
            readThreadServer.SendData(networkUtil,clientName);
            new WriteThreadServer(clientName, networkUtil,readThreadServer);
    }
    public static NetworkUtil getNetworkUtil(String name){
        return clientMap.get(name);
    }

    public static void main(String args[]) {
        player.addAll(FileAction.readFromFile());
        new Server();
    }
}
