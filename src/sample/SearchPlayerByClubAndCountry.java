package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchPlayerByClubAndCountry implements Initializable {

    private Main main;
    @FXML private TextArea country;
    @FXML private TableView<Player> Table;
    @FXML private TableColumn<Player,String>Name;
    @FXML private TableColumn<Player, String>Age;
    @FXML private TableColumn<Player,String>Detail;
    @FXML private TableColumn<Player,String>Position;
    public ObservableList<Player> data = FXCollections.observableArrayList();

    @FXML
    public void Submit(ActionEvent event){
        data.clear();
        String countryInput = country.getText();
        List<String>searchByClubAndCountry;
        searchByClubAndCountry= SearchMethod.byClubAndCountry(countryInput, main.player);
        if(!searchByClubAndCountry.isEmpty())
            for(String p:searchByClubAndCountry){
                String[] token = p.split(",");
                Player player = new Player(token[0], token[1], token[2], token[3], token[4], token[5], token[6], token[7]);
                data.add(player);
            }
        Table.setItems(data);
    }
    @FXML
    public void Back(ActionEvent event){
        try {
            main.searchPlayer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        PlayerToString(p, main);
    }
    static void PlayerToString(Player p, Main main) {
        String player = p.getName()+","+p.getCountry()+","+p.getAge()+","+p.getHeight()+","+p.getClub()+","+p.getPosition()+","+p.getJersy()+","+p.getSalary();
        try {
            main.playerDetails(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        country.setStyle("-fx-text-fill: white ; -fx-padding: 0 0 0 0;");
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Age.setCellValueFactory(new PropertyValueFactory<Player,String>("age"));
        Position.setCellValueFactory(new PropertyValueFactory<Player,String>("position"));
        Detail.setCellFactory(DetailsFactory);

    }

    public void setMain(Main main){
        this.main = main;
    }
}
