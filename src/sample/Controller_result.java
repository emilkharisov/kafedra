package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller_result {

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
            operation("result_uch.fxml");
        });
        button_nauch_trud.setOnAction(event -> {
            operation("result_nauch.fxml");
        });
        exit_button.setOnAction(event -> {
            operation("sample.fxml");
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