package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchPlayerByName implements Initializable {
    private Main main;
    @FXML
    private Label name;
    @FXML
    private Label countryName;
    @FXML
    private Label age;
    @FXML
    private Label height;
    @FXML
    private Label clubName;
    @FXML
    private Label position;
    @FXML
    private Label jersyNumber;
    @FXML
    private Label salary;
    @FXML
    private TextArea playerName;

    @FXML
    public void Submit(){

        String Player = playerName.getText();
        System.out.println(Player);
        List<String> selectByName;

            System.out.println(Player);
            selectByName = SearchMethod.byName(Player, main.player);
            System.out.println(Player);

        if(!selectByName.isEmpty())
        for(String p:selectByName){
            Details.PlayerToString(p, name, countryName, age, height, clubName, position, jersyNumber, salary);
        }

    }
    @FXML
    public void Back(ActionEvent event){
        try {
            main.searchPlayer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerName.setStyle("-fx-text-fill: white ; -fx-padding: 0 0 -22 0;");
    }

    public void setMain(Main main){
        this.main = main;
    }
}
