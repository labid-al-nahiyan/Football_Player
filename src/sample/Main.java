package sample;

import NetworkIng.Client;
import NetworkIng.Server;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    private Stage stage= new Stage();
    public Stage sellStage = new Stage();
    public Stage buyStage = new Stage();
    public Stage detailsStage= new Stage();
    public static String clubName;
    public static List<String> player = new ArrayList<>();
    public static List<ForBuyPlayer> buyPlayer = new ArrayList<>();

    public Client client;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        primaryStage.setOnCloseRequest(event ->{
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.exit(0);
        }) ;
        Login();
    }
    public void Login() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Fxml/Login.fxml"));
        Parent root = loader.load();
        LoginController mainMenu = loader.getController();
        mainMenu.setMain(this);stage.setTitle("Hello World");

        stage.setScene(new Scene(root, 650, 335));
//        stage.initStyle(StageStyle.UNDECORATED);

        stage.show();
    }
    public void MainMenu() throws IOException {
        FXMLLoader loader=loaderFxl("/Fxml/MainMenu.fxml");
         Parent root = loader.load();
        MainMenu mainMenu = loader.getController();
        mainMenu.setMain(this);

        StageShow(stage, root);
    }
    public void searchPlayer() throws IOException {
        FXMLLoader loader = loaderFxl("/Fxml/SearchPlayer.fxml");
        Parent root = loader.load();

        SearchPlayer searchPlayer = loader.getController();
        searchPlayer.setMain(this);

        StageShow(stage, root);
    }
    public void marketPlace() throws IOException{
        FXMLLoader loader = loaderFxl("/Fxml/MarketPlace.fxml");
        Parent root = loader.load();

        MarketPlace marketPlace = loader.getController();
        marketPlace.setMain(this);

        StageShow(stage, root);
    }
    public  void SellAlert(Player player) throws IOException {
        FXMLLoader loader = loaderFxl("/Fxml/SellAlert.fxml");
        Parent root = loader.load();
        SellAlert sellAlert =loader.getController();
        sellStage.setTitle("Hello World");
        sellStage.setScene(new Scene(root, 450, 200));
        sellAlert.setPlayer(player);
        sellAlert.setMain(this);
        sellStage.show();
    }
    public void BuyAlert(ForBuyPlayer player) throws IOException {
        FXMLLoader loader = loaderFxl("/Fxml/BuyerConfirmation.fxml");
        Parent root = loader.load();
        BuyerConfirmation buyerConfirmation =loader.getController();
        buyStage.setTitle("Hello World");
        buyStage.setScene(new Scene(root, 450, 200));
        buyerConfirmation.setPlayer(player);
        buyerConfirmation.setMain(this);
        buyStage.show();
    }
    public void playerDetails(String s) throws IOException {
        FXMLLoader loader = loaderFxl("/Fxml/Details.fxml");
        Parent root = loader.load();
        Details details =loader.getController();
        detailsStage.setTitle("Hello World");
        detailsStage.setScene(new Scene(root, 378, 492));
        details.setMain(this);
        details.setPlayer(s);
        detailsStage.show();
    }
    public FXMLLoader loaderFxl(String str){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(str));

        return loader;
    }
    public void StageShow(Stage stage, Parent root) {
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 700, 580));
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
