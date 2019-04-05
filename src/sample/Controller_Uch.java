package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_Uch {
    ObservableList<String> tipList = FXCollections.observableArrayList("Методические указания","Учебные пособия","Учебники");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nazvanie;

    @FXML
    private TextField avtory;

    @FXML
    private TextField stranicy;

    @FXML
    private ChoiceBox<String> tip;

    @FXML
    private TextField god;

    @FXML
    private TextField izdatel;

    @FXML
    private Button add_trud;
    @FXML
    private Button exit_button;

    @FXML
    void initialize() {
        tip.setValue("Методические указания");
        tip.setItems(tipList);
        DatebaseHandler dbHandler = new DatebaseHandler();
        add_trud.setOnAction(event -> {
            
            dbHandler.add_info1(nazvanie.getText(),avtory.getText(),stranicy.getText(),tip.getValue(),god.getText(),izdatel.getText());
            
        });
        exit_button.setOnAction(event -> {
            try {
                exit_button.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("science_work.fxml"));
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
}