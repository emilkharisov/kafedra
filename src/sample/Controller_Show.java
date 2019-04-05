package sample;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Animation.Shake;

public class Controller_Show {

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
    private Button add_button1;

    @FXML
    private Button add_button;

    @FXML
    private Label lastname1;

    @FXML
    private Label firstname1;

    @FXML
    private Label god;

    @FXML
    private Label adres;

    @FXML
    private Label telephone;

    @FXML
    private Label obrazovanie;

    @FXML
    private Label dolzhnost;

    @FXML
    private Label uchstepen1;

    @FXML
    private Label thirdname1;

    @FXML
    private Label uchzvanie;

    @FXML
    private Button exit_button;

    @FXML
    private ImageView image_prepod;
    private boolean error =false;

    @FXML
    void initialize() {
        DatebaseHandler dbHandler1 = new DatebaseHandler();
        lastname1.setText(dbHandler1.show_lastname);
        firstname1.setText(dbHandler1.show_firstname);
        thirdname1.setText(dbHandler1.show_thirdname);
        dolzhnost.setText(dbHandler1.show_dolzhnost);
        uchstepen1.setText(dbHandler1.show_uchstpen);
        uchzvanie.setText(dbHandler1.show_uchzvanie);
        adres.setText(dbHandler1.show_adres);
        telephone.setText(dbHandler1.show_telephone);
        obrazovanie.setText(dbHandler1.show_obrazovanie);
        god.setText(dbHandler1.show_god);
        File file1 = new File(dbHandler1.show_image);
        Image image1 = new Image(file1.toURI().toString());
        image_prepod.setImage(image1);
        
            add_button1.setOnAction(event -> {
                    DatebaseHandler dbHandler = new DatebaseHandler();
                    ResultSet resultSet;
                    resultSet=dbHandler.getUser(lastname.getText(),firstname.getText(),thirdname.getText());
                    lastname1.setText(dbHandler.show_lastname);
                    firstname1.setText(dbHandler.show_firstname);
                    thirdname1.setText(dbHandler.show_thirdname);
                    dolzhnost.setText(dbHandler.show_dolzhnost);
                    uchstepen1.setText(dbHandler.show_uchstpen);
                    uchzvanie.setText(dbHandler.show_uchzvanie);
                    adres.setText(dbHandler.show_adres);
                    telephone.setText(dbHandler.show_telephone);
                    obrazovanie.setText(dbHandler.show_obrazovanie);
                    god.setText(dbHandler.show_god);
                    File file = new File(dbHandler.show_image);
                    Image image = new Image(file.toURI().toString());
                    image_prepod.setImage(image);
                    error=dbHandler.error_show;
                    if(error == false)
                    {
                        Shake shake = new Shake(lastname);
                        Shake shake1 = new Shake(firstname);
                        Shake shake2 = new Shake(thirdname);
                        shake.play_anim();
                        shake1.play_anim();
                        shake2.play_anim();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Неккоректный ввод данных");
                        alert.setContentText("Такой преподователь отсутствует в базе данных");
                        alert.showAndWait();
                    }

                    dbHandler.clear();
                }
        );
                    exit_button.setOnAction(event -> {
                        try {
                            add_button1.getScene().getWindow().hide();
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
