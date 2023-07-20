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
import java.sql.*;
import java.util.ResourceBundle;

public class Updateabsence implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    @FXML
    private Button bdelete;
    @FXML
    private TextField fdate;

    @FXML
    private TextField fidenseignant;

    @FXML
    private TextField fidetudiant;

    @FXML
    private TextField fidmatiere;

    @FXML
    private TextField fnumseance;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = connect.bdConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    @FXML
    void delete(ActionEvent event) {
        if(((!fidetudiant.getText().isBlank())&& (!fidenseignant.getText().isBlank())&& (!fidmatiere.getText().isBlank()) &&
        (!fnumseance.getText().isBlank()) && !fdate.getText().isBlank())
         ){
            String query ="DELETE FROM absence WHERE idetudiant = ? AND idenseignant = ? AND idmatiere = ? AND numseance = ? AND date = ?";
            try {
                pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(fidetudiant.getText()));
                pst.setInt(2, Integer.parseInt(fidenseignant.getText()));
                pst.setInt(3, Integer.parseInt(fidmatiere.getText()));
                pst.setInt(4, Integer.parseInt(fnumseance.getText()));
                pst.setObject(5, fdate.getText());
                int i = pst.executeUpdate();
                if(i == 1){
                    Alert alert = new Alert(Alert.AlertType.NONE, "data has been deleted", ButtonType.OK);
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









    }



