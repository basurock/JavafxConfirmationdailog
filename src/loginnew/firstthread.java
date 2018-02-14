/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginnew;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Basavaraj
 */
public class firstthread extends Application {
    
      public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Title");
        alert.setHeaderText("Some Text");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeCancel = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Thread thread = new Thread(() -> {
            try {
                // Wait for 5 secs
     //           Thread.sleep(5000);
                if (alert.isShowing()) {
                    Platform.runLater(() -> alert.close());
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        Optional<ButtonType> result = alert.showAndWait();
    }
    
}
