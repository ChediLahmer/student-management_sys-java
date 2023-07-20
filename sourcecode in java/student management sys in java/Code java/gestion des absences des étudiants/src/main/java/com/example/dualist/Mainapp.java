package com.example.dualist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Mainapp extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("firstpage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Image icon = new Image("C:/Users/fahdl/Desktop/icon.png");
            stage.getIcons().add(icon);
            stage.setTitle("student_management_system");
            stage.setResizable(false);
            stage.show();
            stage.setOnCloseRequest(event ->{
                event.consume();
                cancel(stage);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    void cancel(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("are you sure?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You successfully exit");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}