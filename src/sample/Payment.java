package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Payment {
    @FXML
    public Button cancel;

    ObservableList<String> list = FXCollections.observableArrayList("aaa", "adadad", "assadsd");

    @FXML
    private ChoiceBox choiceBox = new ChoiceBox(list);

    public void initialize() {
        cancel.setOnAction(event -> {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPaths.SAMPLE_LAYOUT));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("hjh");
                stage.setScene(new Scene(root, 627, 397));
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();

            }

        });

    }
}
