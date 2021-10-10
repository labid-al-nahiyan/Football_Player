package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SellPlayer  implements Initializable {
    private Main main;
    @FXML
    private  TableView<Player> Table;
    @FXML private TableColumn<Player,String> Name;
    @FXML private TableColumn<Player, String>Age;
    @FXML private TableColumn<Player,String>Position;
    @FXML private TableColumn<Player,String>Action;
    @FXML private TableColumn<Player,String>jction;

    public  ObservableList<Player> data = FXCollections.observableArrayList();

    Callback<TableColumn<Player, String>, TableCell<Player, String>> cellFactory = new Callback<>() {
                @Override
                public TableCell call(final TableColumn<Player, String> param) {
                    final TableCell<Player, String> cell = new TableCell<>() {
                        final Button btn = new Button("Sell");
                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                                setText(null);
                            } else {
                                btn.setOnAction(event -> {
                                   // Player player = getTableView().getItems().get(getIndex());
                                    Player demoPlayer = getTableRow().getItem();
                                    Sell(demoPlayer);

                                });
                                setGraphic(btn);
                                setText(null);
                            }
                        }
                    };
                    return cell;
                }
            };
    Callback<TableColumn<Player, String>, TableCell<Player, String>> DetailsFactory = new Callback<>() {
        @Override
        public TableCell call(final TableColumn<Player, String> param) {
            final TableCell<Player, String> cell = new TableCell<>() {
                final Button btn = new Button("Details");
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.setOnAction(event -> {
                            // Player player = getTableView().getItems().get(getIndex());
                            Player demoPlayer = getTableRow().getItem();
                            KnowDetails(demoPlayer);

                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
            return cell;
        }
    };

    public void KnowDetails(Player p){
        SearchPlayerByClubAndCountry.PlayerToString(p, main);
    }
    public  void Sell(Player p){

        try {
            main.SellAlert(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Timer t = null ;
    private void createTimer() {
        if (t == null) {
            t = new Timer("Hightlight", true);
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    load();
                }
            }, 0, 2500);
        }
    }

    @FXML
    public  void load(){
        data.clear();
        for(String p: Main.player){
            String[] token = p.split(",");
            Player player = new Player(token[0], token[1], token[2], token[3], token[4], token[5], token[6], token[7]);
            data.add(player);
        }
        Table.setItems(data);
    }
    @FXML
    public void Back(ActionEvent event){
        try {
            main.marketPlace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Age.setCellValueFactory(new PropertyValueFactory<Player,String>("age"));
        Position.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        Action.setCellFactory(cellFactory);
        jction.setCellFactory(DetailsFactory);

       load();
       createTimer();
    }

    public void setMain(Main main){
        this.main = main;
    }
}
