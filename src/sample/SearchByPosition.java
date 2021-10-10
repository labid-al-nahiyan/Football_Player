package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchByPosition implements Initializable {
    private Main main;
    @FXML
    private TextArea positionInput;
    @FXML private TableView<Player> Table;
    @FXML private TableColumn<Player,String> Name;
    @FXML private TableColumn<Player, String>Age;
    @FXML private TableColumn<Player,String>Height;
    @FXML private TableColumn<Player,String>Detail;

    public ObservableList<Player> data = FXCollections.observableArrayList();

    @FXML
    public void Submit(){
        data.clear();
        String position = positionInput.getText();
        List<String> searchByPosition ;
        searchByPosition = SearchMethod.byPosition(position, main.player);
        for(String p: searchByPosition){
            String[] token = p.split(",");
            Player player = new Player(token[0], token[1], token[2], token[3], token[4], token[5], token[6], token[7]);
            data.add(player);
        }
        Table.setItems(data);
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
    @FXML
    public void Back(){
        try {
            main.searchPlayer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Age.setCellValueFactory(new PropertyValueFactory<Player,String>("age"));
        Height.setCellValueFactory(new PropertyValueFactory<Player,String>("height"));
        Detail.setCellFactory(DetailsFactory);
        positionInput.setStyle("-fx-text-fill: white ; -fx-padding: 0 0 -22 0;");

    }

    public void setMain(Main main){ this.main = main;
    }
}
