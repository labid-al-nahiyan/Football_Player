package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CountryWise implements Initializable {
    private Main main;

    @FXML
    TableView<Player>Table;
    @FXML
    TableColumn<Player,String>Country;
    @FXML
    TableColumn<Player,Integer>Count;
    public ObservableList<Player> data = FXCollections.observableArrayList();
    public Map<String,Integer>list =new HashMap<>();
    @FXML
    public void Back(ActionEvent event){
        try {
            main.searchPlayer();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void setMain(Main main){
        this.main = main;
    }

    public  void loadData() {
        list.clear();
        for(String p: main.player){
            String[] token = p.split(",");

            if(list.containsKey(token[1])){
                list.put(token[1],list.get(token[1])+1);
            }
            else {
                list.put(token[1],1);
            }
        }
        if(!list.isEmpty())
            for (Map.Entry<String, Integer> cw : list.entrySet()) {
                System.out.println(cw.getKey() + " - "+cw.getValue());
                String a= cw.getKey();
                int b= cw.getValue();
                Player player = new Player(a,b);
                data.add(player);

            }

            Table.setItems(data);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Count.setCellValueFactory(new PropertyValueFactory<>("count"));
        Country.setCellValueFactory(new PropertyValueFactory<>("country"));
        loadData();
}
}
