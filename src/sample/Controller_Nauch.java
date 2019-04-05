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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_Nauch {
    ObservableList<String> tipList = FXCollections.observableArrayList("Прогграмный продукт","Патенты","Монографии","Статьи");
    String rinc="Null";
    String scopus="Null";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nazvanie_stat;

    @FXML
    private TextField nazvanie_jour;

    @FXML
    private TextField tom;

    @FXML
    private ChoiceBox<String> tip;

    @FXML
    private TextField stranicy;

    @FXML
    private TextField avtory;

    @FXML
    private Button add_trud;

    @FXML
    private CheckBox checkbox_rinc;

    @FXML
    private CheckBox checkbox_scopus;

    @FXML
    private TextField nomer;

    @FXML
    private TextField god;
    @FXML
    private Button exit_button;
    @FXML
    void initialize() {
    tip.setValue("Прогграмный продукт");
    tip.setItems(tipList);
        DatebaseHandler dbHandler = new DatebaseHandler();
        add_trud.setOnAction(event -> {
            if (checkbox_scopus.isSelected())
            {
                scopus ="SCOPUS";
            }
            if (checkbox_rinc.isSelected())
            {
                rinc ="РИНЦ";
            }
            dbHandler.add_info2(nazvanie_stat.getText(),nazvanie_jour.getText(),tom.getText(),tip.getValue(),stranicy.getText(),avtory.getText(),rinc,scopus,nomer.getText(),god.getText());
            rinc="Null";
            scopus="Null";
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
