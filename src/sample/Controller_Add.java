package sample;

import java.io.IOException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;

public class Controller_Add {
    ObservableList<String> obrazovanieList = FXCollections.observableArrayList("Высшее","Cредне-техническое","Cредне-специальное","Среднее");
    ObservableList<String> dolzhnostList = FXCollections.observableArrayList("Заведующий кафедрой","Профессор","Доцент","Старший преподаватель","Ассистент","Заведующий лабораторией","Инженер-электроник","Программист","Математик","Техник","Лаборант");
    ObservableList<String> uchzvanieList = FXCollections.observableArrayList("Профессор","Доцент");
    ObservableList<String> uchstepen1List = FXCollections.observableArrayList("Доктор технических наук (д.т.н.)","Доктор педагогических наук (д.пед.н.)","Доктор физико-математических наук (д.ф.-м.н.)","Кандидат техническких наук ");
    public String path; //при показе нужно добавить путь а в самой программе просто добавить название файла(при этом картинки должны загружаться в папку pictures)

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane uchstepen;

    @FXML
    private TextField lastname;

    @FXML
    private TextField firstname;

    @FXML
    private TextField thirdname;

    @FXML
    private TextField year;

    @FXML
    private TextField adres;

    @FXML
    private TextField telephone;

    @FXML
    private ChoiceBox<String> obrazovanie;

    @FXML
    private ChoiceBox<String> dolzhnost;

    @FXML
    private ChoiceBox<String> uchstepen1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image1;

    @FXML
    private Button add_button;

    @FXML
    private ImageView image3;

    @FXML
    private ChoiceBox<String> uchzvanie;

    @FXML
    private TextField path_image;

    @FXML
    private Button add_photo_button;
    @FXML
    private Button exit_button;


    @FXML
    void initialize() {
        obrazovanie.setValue("Высшее");
        obrazovanie.setItems(obrazovanieList);
        dolzhnost.setValue("Заведующий кафедрой");
        dolzhnost.setItems(dolzhnostList);
        uchstepen1.setValue("Доктор технических наук (д.т.н.)");
        uchstepen1.setItems(uchstepen1List);
        uchzvanie.setValue("Профессор");
        uchzvanie.setItems(uchzvanieList);
        DatebaseHandler dbHandler = new DatebaseHandler();
        add_button.setOnAction(event -> {

         dbHandler.add_info(lastname.getText(),firstname.getText(),thirdname.getText(),dolzhnost.getValue(),uchstepen1.getValue(),uchzvanie.getValue(),adres.getText(),telephone.getText(),obrazovanie.getValue(),year.getText(),path);
        });
        add_photo_button.setOnAction(event -> {
            File file = new File(path_image.getText());
            Image image = new Image(file.toURI().toString());
            image3.setImage(image);
            path=path_image.getText();

        });

        exit_button.setOnAction(event -> {
            try {
                exit_button.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
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