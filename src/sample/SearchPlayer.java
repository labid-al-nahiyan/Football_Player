package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchPlayer implements Initializable {
    private  Main main;

    @FXML private Label clubBanne;
    @FXML public BorderPane searchPane;
    @FXML
    public void SearchByName() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/SearchPlayerByName.fxml"));
        Parent root = loader.load();
        searchPane.setCenter(root);
    }
    @FXML
    public void SearchByCountryAndClub() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/SearchPlayerByClubAndCountry.fxml"));
        Parent root = loader.load();
        searchPane.setCenter(root);
        SearchPlayerByClubAndCountry searchPlayerByClubAndCountry= loader.getController();
        searchPlayerByClubAndCountry.setMain(this.main);
    }
    @FXML
    public void SearchByPosition() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/SearchByPosition.fxml"));
        Parent root = loader.load();
        searchPane.setCenter(root);
        SearchByPosition searchByPosition= loader.getController();
        searchByPosition.setMain(this.main);
    }
    @FXML
    public void SearchBySalary() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/SearchBySalary.fxml"));
        Parent root = loader.load();
        searchPane.setCenter(root);
        SearchBySalary searchBySalary= loader.getController();
        searchBySalary.setMain(this.main);
    }
    @FXML
    public void SearchByHeight() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/SearchByHeight.fxml"));
        Parent root = loader.load();
        searchPane.setCenter(root);
        SearchByHeight searchByHeight= loader.getController();
        searchByHeight.setMain(this.main);
    }
    @FXML
    public void SearchByCountryWise() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/Country_wise.fxml"));
        Parent root = loader.load();
        searchPane.setCenter(root);
        CountryWise countryWise= loader.getController();
        countryWise.setMain(this.main);
    }
    @FXML
    public void BackToMainMenu(ActionEvent event){
        try {
            main.MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubBanne.setText("Welcome "+Main.clubName);
    }

    public void setMain(Main main){
        this.main = main;
    }
}
