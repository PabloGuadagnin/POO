package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("layoutInicio.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(event -> sairDaAplicacao(stage));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sairDaAplicacao(Stage stage) {
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
