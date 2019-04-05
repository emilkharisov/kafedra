package sample;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller_result_uch {
    ObservableList<Result_uch_table> table = FXCollections.observableArrayList();
    public String show_result_nazvanie;
    public String show_result_avtoru;
    public String show_result_str;
    public String show_result_tip;
    public String show_result_god;
    public String show_result_izdatel;
    public int a=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image1;

    @FXML
    private Button exit_button;

    @FXML
    private TableView<Result_uch_table> Result_uch;

    @FXML
    private TableColumn<Result_uch_table, Integer> id_uch;

    @FXML
    private TableColumn<Result_uch_table, String> nazvanie_uch;

    @FXML
    private TableColumn<Result_uch_table, String> avtory_uch;

    @FXML
    private TableColumn<Result_uch_table, String> stranicy_uch;

    @FXML
    private TableColumn<Result_uch_table, String> tip_uch;

    @FXML
    private TableColumn<Result_uch_table, String> god_uch;

    @FXML
    private TableColumn<Result_uch_table, String> izdatel_uch;
     @FXML
     private Button button_get;
    @FXML
    private TextField text_field;

    @FXML
  private void initialize() throws SQLException {
        button_get.setOnAction(event -> {
            try {
                get_result(text_field.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            nazvanie_uch.setCellValueFactory(new PropertyValueFactory<Result_uch_table,String>("show_result_nazvanie"));
            id_uch.setCellValueFactory(new PropertyValueFactory<Result_uch_table,Integer>("show_result_nomer"));
            avtory_uch.setCellValueFactory(new PropertyValueFactory<Result_uch_table,String>("show_result_avtoru"));
            stranicy_uch.setCellValueFactory(new PropertyValueFactory<Result_uch_table,String>("show_result_str"));
            tip_uch.setCellValueFactory(new PropertyValueFactory<Result_uch_table,String>("show_result_tip"));
            god_uch.setCellValueFactory(new PropertyValueFactory<Result_uch_table,String>("show_result_god"));
            izdatel_uch.setCellValueFactory(new PropertyValueFactory<Result_uch_table,String>("show_result_izdatel"));
            Result_uch.setItems(table);

        });
        exit_button.setOnAction(event -> {
            try {
                exit_button.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
    }


    public void get_result(String god) throws SQLException {
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResultSet resultSet = dbHandler.getrResult_uch();

        while(resultSet.next())
        {
            String god1 = resultSet.getString("god");
            if ((god.equals(god1)))
            {
                show_result_nazvanie=resultSet.getString("nazvanie");
                show_result_avtoru=resultSet.getString("avtory");
                show_result_izdatel=resultSet.getString("izdatel");
                show_result_str=resultSet.getString("stranicy");
                show_result_tip=resultSet.getString("tip");
                show_result_god=resultSet.getString("god");
                a=a+1;
                table.add(new Result_uch_table(a,show_result_nazvanie,show_result_avtoru,show_result_str,show_result_tip,show_result_god,show_result_izdatel));
            }
        }
    }
}



