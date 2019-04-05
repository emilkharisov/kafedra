package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller_Science {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_uch_trud;

    @FXML
    private Button button_nauch_trud;
    @FXML
    private Button exit_button;

    @FXML
    void initialize() {
        button_uch_trud.setOnAction(event -> {
            operation("uch_trud1.fxml");
        });
        button_nauch_trud.setOnAction(event -> {
            operation("nauch_fxml.fxml");
        });
        exit_button.setOnAction(event -> {
            try {
                exit_button.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

    }

    private void operation(String name_fxml) {
        try {
            button_nauch_trud.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name_fxml));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
