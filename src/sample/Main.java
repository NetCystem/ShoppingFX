package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(FXMLPaths.SAMPLE_LAYOUT));
        primaryStage.setTitle("Shopping");
        primaryStage.setScene(new Scene(root, 627, 397));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
