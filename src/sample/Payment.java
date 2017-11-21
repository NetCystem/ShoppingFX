package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Payment {
    @FXML
    public Button pay;
    @FXML
    private PasswordField cvc;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextField cardholder;
    @FXML
    private TextField cardnumber;

    private Models models = new Models();

    public void initialize() {
        cvc.addEventFilter(KeyEvent.KEY_TYPED, models.maxLength(3));
        models.dateFormatting(datepicker);

        pay.setOnAction(event -> {
            if (models.checkCVC(cvc) && models.dateCheck(datepicker) && models.check(cardholder) && models.checkNumber(cardnumber)) {
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
            } else {
                System.out.println("Error");
            }
        });

    }


}
