package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {
    private Main main;

    @FXML
    private BorderPane mainPane;
    @FXML private Label clubBanne;
    @FXML
    public void searchPlayer(ActionEvent event){
        try {
            main.searchPlayer();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void searchClub(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/SearchClub.fxml"));
        Parent root = loader.load();
        mainPane.setCenter(root);
    }
    public void marketPlace(ActionEvent event){
        try {
            main.marketPlace();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void LogOut(ActionEvent event){
        try {
           main.client.CloseConnection();
            main.Login();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void setMain(Main main){
        this.main = main;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubBanne.setText("Welcome "+Main.clubName);
    }
}
