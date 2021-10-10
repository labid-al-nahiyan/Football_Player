
    package sample;

import NetworkIng.Server;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

    public class BuyPlayer implements Initializable {
        private Main main;

        @FXML
        private TableView<ForBuyPlayer> Table;
        @FXML private TableColumn<ForBuyPlayer,String> Name;
        @FXML private TableColumn<ForBuyPlayer,String>Country;
        @FXML private TableColumn<ForBuyPlayer, String>Age;
        @FXML private TableColumn<ForBuyPlayer,String>Height;
        @FXML private TableColumn<ForBuyPlayer,String>Club;
        @FXML private TableColumn<ForBuyPlayer,String>Jersy;
        @FXML private TableColumn<ForBuyPlayer,String>Salary;
        @FXML private TableColumn<ForBuyPlayer,String>Position;
        @FXML private TableColumn<ForBuyPlayer,String>Action;
        @FXML private TableColumn<ForBuyPlayer,String>detail;

        public ObservableList<ForBuyPlayer> data = FXCollections.observableArrayList();

        Callback<TableColumn<ForBuyPlayer, String>, TableCell<ForBuyPlayer, String>> cellFactory = new Callback<>() {
            @Override
            public TableCell call(final TableColumn<ForBuyPlayer, String> param) {
                final TableCell<ForBuyPlayer, String> cell = new TableCell<>() {
                    final Button btn = new Button("BUY");
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                // Player player = getTableView().getItems().get(getIndex());
                                ForBuyPlayer demoPlayer = getTableRow().getItem();
                                Buy(demoPlayer);

                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        Callback<TableColumn<ForBuyPlayer, String>, TableCell<ForBuyPlayer, String>> detailsFectory = new Callback<>() {
        @Override
        public TableCell call(final TableColumn<ForBuyPlayer, String> param) {
            final TableCell<ForBuyPlayer, String> cell = new TableCell<>() {
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
                            ForBuyPlayer demoPlayer = getTableRow().getItem();
                            knowDetails(demoPlayer);

                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            };
            return cell;
        }
    };
        public  void Buy(ForBuyPlayer p){
            try {
                main.BuyAlert(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void knowDetails(ForBuyPlayer p){
            String player = p.getName()+","+p.getCountry()+","+p.getAge()+","+p.getHeight()+","+p.getClub()+","+p.getPosition()+","+p.getJersy()+","+p.getPrize();
            try {
                main.playerDetails(player);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private static Timer t = null;
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
        public void load(){
            data.clear();
            for(ForBuyPlayer p: Main.buyPlayer){
               data.add(p);
            }
            Table.setItems(data);
        }
        @FXML
        public void Back(ActionEvent event){
            for (ForBuyPlayer P: Main.buyPlayer){
                P.getName();
                System.out.println(P.getName());
            }
            System.out.println("hello");
            try {
                main.marketPlace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void setMain(Main main){
            this.main = main;
        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            Name.setCellValueFactory(new PropertyValueFactory<ForBuyPlayer,String>("name"));
            Age.setCellValueFactory(new PropertyValueFactory<ForBuyPlayer,String>("age"));
            Position.setCellValueFactory(new PropertyValueFactory<ForBuyPlayer,String>("position"));
            Action.setCellFactory(cellFactory);
            detail.setCellFactory(detailsFectory);

            load();
            createTimer();
        }
    }