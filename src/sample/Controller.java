package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    private String string;

    ObservableList<String> countryList=FXCollections.observableArrayList("sdasds", "asdsada", "adfadff");


    public boolean checkStringName(){
        return firstname.getText().matches("[a-z A-Z]+");
    }

    public boolean checkStringSurName(){
        return lastname.getText().matches("[a-z A-Z]+");
    }

    public boolean checkStringEmail(){
        return emailid.getText().matches("[a-z A-Z]+");
    }

    public boolean checkStringUserId(){
        return userid.getText().matches("[a-z A-Z]+");
    }

    public boolean checkPhone(){
        return phonenumber.getText().matches("[0-9]+");
    }

    public boolean checkReferenceCode(){
        return referencecode.getText().matches("[a-z A-Z]+");
    }


    public void initialize() {
        continueClick();
        resetClick();

        countrybox = new ChoiceBox(countryList);

//        countrybox.getItems().addAll("sdasd","werrr", "ertyuu");
//        statebox.getItems().addAll("erty","www","rrrr");
//        citybox.getItems().addAll("ggg","rty", "dssdfdsf");

    }

    public void continueClick(){
        continuebtn.setOnMouseClicked((MouseEvent event) -> {
            if (checkStringName() && checkStringSurName() && checkStringEmail() && checkStringUserId() && checkPhone()
                    && checkReferenceCode()){
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
            if (!firstname.getText().isEmpty())
                firstname.clear();
            if (!lastname.getText().isEmpty())
                lastname.clear();
            if (!emailid.getText().isEmpty())
                emailid.clear();
            if (!userid.getText().isEmpty())
                userid.clear();
            if (!phonenumber.getText().isEmpty())
                phonenumber.clear();
            if (!referencecode.getText().isEmpty())
                referencecode.clear();


        });
    }


//tarberutiun@ es dzevi, initialazable-i u implement eventhandleri mej
    //xi chi classi referncov methodi return@ stanum





}

