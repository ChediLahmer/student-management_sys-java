package com.example.dualist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class Responsablepage {
    Stage stage;
    private Scene scene;
    @FXML
    private Button bimprimer;
    private Parent root;
    private Connection con;
    @FXML
    private BorderPane mainpane;



    @FXML
    void gomainpage(ActionEvent event) {
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

    public void getpage(String filename) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(filename + ".fxml"));
        mainpane.setCenter(root);
    }

    @FXML
    void annulerabsence(ActionEvent event) throws IOException {

        getpage("updateabsence");
    }

    @FXML
    void envoyermail(ActionEvent event) throws IOException {

        getpage("mail");
    }

    @FXML
    void generergraphe(ActionEvent event) throws IOException {

        getpage("graphe");

    }

    @FXML
    void imprimerabsences(ActionEvent event) throws IOException {

        getpage("voirtable");
    }
    @FXML
    void printaction(ActionEvent event) throws IOException {
        getpage("printyy");

    }

}









