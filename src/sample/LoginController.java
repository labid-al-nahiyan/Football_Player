package sample;

import NetworkIng.Client;
import NetworkIng.Server;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private Main main;
    @FXML
    private TextArea ClubInput;
    @FXML
    private Text manager;
    @FXML
    public void Submit(){

        String clubName = ClubInput.getText();
        main.clubName= clubName;
        main.client=new Client("127.0.0.1",44581,clubName);
        try {
            main.MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setMain(Main main){
        this.main = main;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ClubInput.setStyle("-fx-text-fill: white ; -fx-padding: 0 0 -22 0;");
    }
}
