package sample;

import javafx.fxml.FXML;

import java.io.IOException;

public class BuyerConfirmation {
    private Main main;
    private ForBuyPlayer player;

    @FXML
    public void Confirm(){
        main.client.sellPlayer(player);

        main.buyStage.close();

    }

    @FXML
    public void Cancle(){
        main.buyStage.close();
    }

    public void setMain(Main main){
        this.main = main;
    }
    public void setPlayer(ForBuyPlayer player){
        this.player= player;
    }
}
