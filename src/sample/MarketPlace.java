package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MarketPlace implements Initializable {
    private Main main;
    @FXML private Label clubBanne;
    @FXML public  BorderPane marketPane;
    @FXML private ImageView showLogo;
    public  void sellPlayer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/SellPlayer.fxml"));
        Parent root = loader.load();
        marketPane.setCenter(root);
        SellPlayer sellPlayer= loader.getController();
        sellPlayer.setMain(this.main);
      }
    @FXML
    public void buyPlayer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/BuyPlayer.fxml"));
        Parent root = loader.load();
        marketPane.setCenter(root);
        BuyPlayer buyPlayer= loader.getController();
        buyPlayer.setMain(this.main);
    }
    @FXML
    public void Back(ActionEvent event){
        try {
            main.MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubBanne.setText("Welcome "+Main.clubName.toUpperCase());
        String img = "logo/"+Main.clubName+".png";
        System.out.println(img);
        Image image = new Image(img);
        System.out.println(image);
        showLogo.setImage(image);
        showLogo.setOpacity(.2);

    }


    public void setMain(Main main){
        this.main = main;
    }
}
