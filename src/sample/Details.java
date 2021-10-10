package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Details{
    public String player;
    private  Main main;
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
    public void setPlayer(String player){
        PlayerToString(player, name, countryName, age, height, clubName, position, jersyNumber, salary);
    }

    static void PlayerToString(String player, Label name, Label countryName, Label age, Label height, Label clubName, Label position, Label jersyNumber, Label salary) {
        String[] token = player.split(",");
        name.setText(token[0]);
        countryName.setText(token[1]);
        age.setText(token[2]);
        height.setText(token[3]);
        clubName.setText(token[4]);
        position.setText(token[5]);
        jersyNumber.setText(token[6]);
        salary.setText(token[7]);
    }


    @FXML
    public void Back(ActionEvent event){
        main.detailsStage.close();
    }
    public void setMain(Main main){
        this.main = main;
    }

}
