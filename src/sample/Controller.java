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

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    void initialize() {
        button1.setOnAction(event -> {
         operation("add_prepodovatel.fxml");
          }
        );
        button2.setOnAction(event -> {
                    operation("show_prepodovatel.fxml");
                }
        );
        button4.setOnAction(event -> {
                    operation("science_work.fxml");
                }
        );
        button3.setOnAction(event -> {
                    operation("result.fxml");
        });


    }

    private void operation(String name_fxml) {
        button1.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(name_fxml));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);

        stage.showAndWait();
    }
}