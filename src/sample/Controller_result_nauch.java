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

public class Controller_result_nauch {
    ObservableList<Result_nauch_table> table = FXCollections.observableArrayList();
    public String show_result_nazvanie_stat;
    public String show_result_nazvanie_jour;
    public String show_result_avtory;
    public String show_result_tip;
    public String show_result_nomer_jour;
    public String show_result_tom;
    public String show_result_str;
    public String show_result_rinc;
    public String show_result_scopus;
    public String show_result_god;
    public int a=0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Result_nauch_table> Rezult_nuch;

    @FXML
    private TableColumn<Result_nauch_table, Integer> nomer;

    @FXML
    private TableColumn<Result_nauch_table, String> nazvanie_stat;

    @FXML
    private TableColumn<Result_nauch_table, String> nazvanie_jour;

    @FXML
    private TableColumn<Result_nauch_table, String> avtory;

    @FXML
    private TableColumn<Result_nauch_table, String> tip;

    @FXML
    private TableColumn<Result_nauch_table, String> nomer_jour;

    @FXML
    private TableColumn<Result_nauch_table, String> tom;

    @FXML
    private TableColumn<Result_nauch_table, String> stranicy;

    @FXML
    private TableColumn<Result_nauch_table, String> rinc;

    @FXML
    private TableColumn<Result_nauch_table, String> scopus;

    @FXML
    private TableColumn<Result_nauch_table, String> god;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image1;

    @FXML
    private Button exit_button;

    @FXML
    private Button button_get;

    @FXML
    private TextField text_field;

    @FXML
    void initialize() {
     button_get.setOnAction(event -> {
         try {
             get_result(text_field.getText());
         } catch (SQLException e) {
             e.printStackTrace();
         }
         nomer.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,Integer>("show_result_nomer"));
         nazvanie_stat.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_nazvanie_stat"));
         nomer_jour.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_nomer_jour"));
         avtory.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_avtory"));
         nazvanie_jour.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_nazvanie_jour"));
         tip.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_tip"));
         tom.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_tom"));
         stranicy.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_str"));
         rinc.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_rinc"));
         scopus.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_scopus"));
         god.setCellValueFactory(new PropertyValueFactory<Result_nauch_table,String>("show_result_god"));
         Rezult_nuch.setItems(table);
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
        ResultSet resultSet = dbHandler.getrResult_nauch();

        while(resultSet.next())
        {
            String god1 = resultSet.getString("god");
            if ((god.equals(god1)))
            {
                show_result_nazvanie_stat=resultSet.getString("nazvanie_stat");
                show_result_nazvanie_jour=resultSet.getString("nazvanie_jour");
                show_result_avtory=resultSet.getString("avtory");
                show_result_str=resultSet.getString("stranicy");
                show_result_tip=resultSet.getString("tip");
                show_result_god=resultSet.getString("god");
                show_result_nomer_jour=resultSet.getString("nomer");
                show_result_tom=resultSet.getString("tom");
                show_result_rinc=resultSet.getString("checkbox_rinc");
                show_result_scopus=resultSet.getString("checkbox_scopus");
                a=a+1;
                table.add(new Result_nauch_table(a,show_result_nazvanie_stat,show_result_nazvanie_jour,show_result_avtory,show_result_tip,show_result_nomer_jour,show_result_tom,show_result_str,show_result_rinc,show_result_scopus,show_result_god));
            }
        }
    }
}