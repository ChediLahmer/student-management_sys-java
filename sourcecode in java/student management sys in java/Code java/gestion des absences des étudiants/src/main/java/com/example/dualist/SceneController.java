package com.example.dualist;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class SceneController implements Initializable {

    private ObservableList<babsence> data;
    private Connection con;
    @FXML
    private Button bcancel;

    @FXML
    private RadioButton benseignant;

    @FXML
    private RadioButton betudiant;

    @FXML
    private RadioButton bresponsable;

    @FXML
    private TextField insertedid;

    @FXML
    private TextField insertedpassword;

    @FXML
    private ToggleGroup role;

    @FXML
    private Label whoareyou;
     Stage stage;
    private Scene scene;
    private Parent root;
    private PreparedStatement pst;
    private ResultSet rs;
    @FXML
    private AnchorPane scenepane;



    @FXML
    void getrole(ActionEvent event) {

    }
    @FXML
    void myid (ActionEvent event){

    }

    @FXML
    void mypassword (ActionEvent event){

    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = connect.bdConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void login(ActionEvent event) throws IOException {
        if (benseignant.isSelected()) {
            try {
                String query = "SELECT * FROM enseignant WHERE idenseignant = ? AND pwd = ? ";
                pst = con.prepareStatement(query);
                pst.setString(1, insertedid.getText());
                pst.setString(2, insertedpassword.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("nom");
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("enseignantpage.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Invalid username and password", ButtonType.OK);
                    alert.setTitle("ALERT!");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        }
        else if (betudiant.isSelected()) {
            try {
                String query = "SELECT * FROM etudiant WHERE idetudiant = ? AND pwd = ? ";
                pst = con.prepareStatement(query);
                pst.setString(1, insertedid.getText());
                pst.setString(2, insertedpassword.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("nom");
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("absence.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Invalid username and password", ButtonType.OK);
                    alert.setTitle("ALERT!");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        } else if (bresponsable.isSelected()) {
            try {
                String query = "SELECT * FROM responsable WHERE idresponsable = ? AND pwd = ? ";
                pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(insertedid.getText()));
                pst.setString(2, insertedpassword.getText());
                rs = pst.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("nom");
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("responsablepage.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Invalid username and password", ButtonType.OK);
                    alert.setTitle("ALERT!");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
            else {
                Alert alert = new Alert(Alert.AlertType.NONE, "Invalid username and password", ButtonType.OK);
                alert.setTitle("ALERT!");
                alert.showAndWait();
        }



    }
    @FXML
    void cancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Do you want to save before exiting?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenepane.getScene().getWindow();
            System.out.println("You successfully exit");
            stage.close();
        }
    }


    }


















