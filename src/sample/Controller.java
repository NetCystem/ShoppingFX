package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button continuebtn;
    @FXML
    private Button reset;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField emailid;
    @FXML
    private TextField userid;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField referencecode;
    @FXML
    private ChoiceBox countrybox;
    @FXML
    private ChoiceBox statebox;
    @FXML
    private ChoiceBox citybox;
    @FXML
    private CheckBox emailcheck;

    private Models models = new Models();

    ObservableList<String> countryList = FXCollections.observableArrayList("USA", "UK", "India");
    ObservableList<String> stateList = FXCollections.observableArrayList("Florida", "Chetser", "Sagha");
    ObservableList<String> cityList = FXCollections.observableArrayList("Miami", "London", "Mumbai");

    public void initialize() {
        continueClick();
        resetClick();
//        checkUncheck();

        countrybox.setItems(countryList);
        statebox.setItems(stateList);
        citybox.setItems(cityList);

    }

    public void continueClick() {
        continuebtn.setOnMouseClicked((MouseEvent event) -> {
            if (models.check(firstname) && models.check(lastname) && models.checkEmail(emailid)
                    && models.check(userid) && models.checkPhone(phonenumber) &&
                    models.check(referencecode) && models.isSelected(countrybox)
                    && models.isSelected(statebox) && models.isSelected(citybox)) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLPaths.PAYMENT_LAYOUT));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Other");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                    // Hide this current window (if this is what you want)
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();

                }

            }else {
                System.out.println("Error");
            }

        });
    }


    public void resetClick(){
        reset.setOnAction(event -> {
            models.clear(firstname);
            models.clear(lastname);
            models.clear(emailid);
            models.clear(userid);
            models.clear(phonenumber);
            models.clear(referencecode);
            models.clearBox(countrybox);
            models.clearBox(statebox);
            models.clearBox(citybox);
        });
    }

//    public void checkUncheck(){
//            emailcheck.setSelected(true);
//    }


//tarberutiun@ es dzevi, initialazable-i u implement eventhandleri mej
    //xi chi classi referncov methodi return@ stanum





}

