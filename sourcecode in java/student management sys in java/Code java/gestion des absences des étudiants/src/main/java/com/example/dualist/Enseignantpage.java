package com.example.dualist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Enseignantpage {
    Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private BorderPane mainpany;
    @FXML
    void mapage(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("firstpage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getpagy(String filename) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(filename+".fxml"));
        mainpany.setCenter(root);
    }
    @FXML
    void imprimerabsence(ActionEvent event) throws IOException {
        getpagy ("voirtable");
    }

    @FXML
    void insertedabsence(ActionEvent event) throws IOException {
        getpagy("adddabsence");
    }

}

