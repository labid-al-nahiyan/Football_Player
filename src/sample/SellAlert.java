package sample;

import NetworkIng.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class SellAlert implements Initializable {
    private Main main;
    Player player;

    @FXML private TextArea prize;
    @FXML
    public void Confirm(ActionEvent event){
        if(prize.getText().trim().length()!=0) {
            String prizeNo = prize.getText();

            for(String pp: Main.player){
                String[] token = pp.split(",");
                if (token[0].equalsIgnoreCase(player.getName())) {
                    Main.player.remove(pp);
                    break;
                }
            }
                player.setSalary(prizeNo);

                main.client.sellPlayer(player);
                main.sellStage.close();
        }

    }
    @FXML
    public void Cancle(ActionEvent event){
        main.sellStage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prize.setStyle("-fx-text-fill: white ; -fx-padding: 0 0 -22 0;");
    }
    public void setPlayer(Player player){this.player =player;}

    public void setMain(Main main){
        this.main = main;
    }
}
