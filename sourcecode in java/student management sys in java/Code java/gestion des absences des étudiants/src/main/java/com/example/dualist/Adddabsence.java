package com.example.dualist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Adddabsence implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    @FXML
    private Button badd;

    @FXML
    private TextField ffdate;

    @FXML
    private TextField ffidenseignant;

    @FXML
    private TextField ffidetudiant;

    @FXML
    private TextField ffidmatiere;

    @FXML
    private TextField ffnumseance;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = connect.bdConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void add(ActionEvent event) {
        if(((!ffidetudiant.getText().isBlank())&& (!ffidenseignant.getText().isBlank())&& (!ffidmatiere.getText().isBlank()) &&
                (!ffnumseance.getText().isBlank()) && !ffdate.getText().isBlank())
        ){
            String query ="INSERT INTO absence (idetudiant,idenseignant,idmatiere,numseance,date) VALUES(?,?,?,?,?)";
            try {
                pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(ffidetudiant.getText()));
                pst.setInt(2, Integer.parseInt(ffidenseignant.getText()));
                pst.setInt(3, Integer.parseInt(ffidmatiere.getText()));
                pst.setInt(4, Integer.parseInt(ffnumseance.getText()));
                pst.setObject(5, ffdate.getText());
                int i = pst.executeUpdate();
                if(i == 1){
                    Alert alert = new Alert(Alert.AlertType.NONE, "data has been added", ButtonType.OK);
                    alert.setTitle("Successful ");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.NONE, "Fill in the blanks", ButtonType.OK);
            alert.setTitle("ALERT!");
            alert.showAndWait();
        }
    }

    @FXML
    void insertdate(ActionEvent event) {

    }

    @FXML
    void insertidenseignant(ActionEvent event) {

    }

    @FXML
    void insertidetudiant(ActionEvent event) {

    }

    @FXML
    void insertidmatiere(ActionEvent event) {

    }

    @FXML
    void insertnumseance(ActionEvent event) {

    }

}

