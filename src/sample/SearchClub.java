package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class SearchClub implements Initializable{
    private Main main;
    @FXML private Label totalSalary;
    @FXML private TableView<Player> Table;
    @FXML private TableColumn<Player,String> Name;
    @FXML private TableColumn<Player,String>Country;
    @FXML private TableColumn<Player, String>Age;
    @FXML private TableColumn<Player,String>Height;
    @FXML private TableColumn<Player,String>Salary;
    @FXML private TableColumn<Player,String>Position;

    public ObservableList<Player> data = FXCollections.observableArrayList();

    @FXML
    public void findMaxAge(){
        data.clear();
        String clubInput = main.clubName;
        Map<String,Integer> MaxAge;
        MaxAge = SearchMethod.findMaxAge(clubInput,main.player);
        for (Map.Entry<String, Integer> cw : MaxAge.entrySet()) {
            System.out.println(cw.getKey() + " - "+cw.getValue());
        }
        if(MaxAge.containsKey(clubInput)){
            int age = MaxAge.get(clubInput);
            for(String p:main.player){
                String[] token = p.split(",");
                if(Integer.parseInt(token[2])==age && token[4].equalsIgnoreCase(clubInput)){
                    Player player = new Player(token[0],token[1],token[2],token[3],token[4],token[5],token[6],token[7]);
                    data.add(player);
                }
            }
        }
        totalSalary.setText("");

        Table.setItems(data);

    }
    @FXML
    public void findMaxSalary(){
        data.clear();
        String clubInput = main.clubName;
        Map<String,Double> MaxSalary;
        MaxSalary = SearchMethod.findMaxSalary(clubInput,main.player);
        for (Map.Entry<String, Double> cw : MaxSalary.entrySet()) {
            System.out.println(cw.getKey() + " - "+cw.getValue());
        }
        if(MaxSalary.containsKey(clubInput)){
            double salary = MaxSalary.get(clubInput);
            for(String p:main.player){
                String[] token = p.split(",");
                if(Double.parseDouble(token[7])==salary && token[4].equalsIgnoreCase(clubInput)){
                    Player player = new Player(token[0],token[1],token[2],token[3],token[4],token[5],token[6],token[7]);
                    data.add(player);
                }
            }
        }
        totalSalary.setText("");

        Table.setItems(data);
    }
    @FXML
    public void findMaxHeight(){
        data.clear();
        String clubInput = main.clubName;
        Map<String,Double> MaxHeight;
        MaxHeight = SearchMethod.findMaxHeight(clubInput,main.player);
        for (Map.Entry<String, Double> cw : MaxHeight.entrySet()) {
            System.out.println(cw.getKey() + " - "+cw.getValue());
        }
        if(MaxHeight.containsKey(clubInput)){
            double height = MaxHeight.get(clubInput);
            for(String p:main.player){
                String[] token = p.split(",");
                if(Double.parseDouble(token[3])==height && token[4].equalsIgnoreCase(clubInput)){
                    Player player = new Player(token[0],token[1],token[2],token[3],token[4],token[5],token[6],token[7]);
                    data.add(player);                }
            }
        }
        totalSalary.setText("");
        Table.setItems(data);
    }
    @FXML
    public void TotalSalary(){
        String clubInput = main.clubName;
        double sum = 0;
        for(String p: main.player){
            String[] token = p.split(",");
            if(clubInput.equalsIgnoreCase(token[4])){
                sum+=Double.parseDouble(token[7]);
            }
        }
        totalSalary.setText("Total Yearly Salary of "+clubInput +" is "+ (sum*52)/1000000+"M $");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Country.setCellValueFactory(new PropertyValueFactory<>("country"));
        Age.setCellValueFactory(new PropertyValueFactory<>("age"));
        Height.setCellValueFactory(new PropertyValueFactory<>("height"));
        Position.setCellValueFactory(new PropertyValueFactory<>("position"));
        Salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    public void setMain(Main main){
        this.main = main;
    }

}
