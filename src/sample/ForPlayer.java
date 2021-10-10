package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ForPlayer implements Serializable {
    private  List<String> player;
    private  List<ForBuyPlayer> buyPlayer;

    public ForPlayer(List <String> player, List<ForBuyPlayer>buyPlayer){
        this.player= player;
        this.buyPlayer=buyPlayer;
    }
    public List<String > getPlayerList(){
        return  this.player;
    }
    public List<ForBuyPlayer> getBuyPlayerList(){
        return  this.buyPlayer;
    }
}
