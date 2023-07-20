package com.example.dualist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
public class Etudselect implements Initializable   {
    Stage stage;
    private Scene scene;
    private Parent root;
    private Connection con;
    @FXML
    void notrepage(ActionEvent event) {
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
    @FXML
    private Button bafficherregistre;
    @FXML
    private TableColumn<babsence,Date> ccdate;
    @FXML
    private TableColumn<babsence,Integer> ccidenseignant;
    @FXML
    private TableColumn<babsence,Integer> ccidetudiant;
    @FXML
    private TableColumn<babsence,Integer> ccidmatiere;
    @FXML
    private TableColumn<babsence,Integer> ccnumseance;
    @FXML
    private TableView<babsence> tableabscence;
    @FXML
    private ObservableList<babsence> data;

    @FXML
    void afficheregistre(ActionEvent event) {
        setCellTable();
        loadData();    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = connect.bdConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        data = FXCollections.observableArrayList();

    }
    private void setCellTable() {
        ccidetudiant.setCellValueFactory(new PropertyValueFactory<>("idetudiant"));
        ccidenseignant.setCellValueFactory(new PropertyValueFactory<>("idenseignant"));
        ccidmatiere.setCellValueFactory(new PropertyValueFactory<>("idmatiere"));
        ccnumseance.setCellValueFactory(new PropertyValueFactory<>("numseance"));
        ccdate.setCellValueFactory(new PropertyValueFactory<>("date"));

    }
    @FXML
    private void loadData() {

        data.clear();
        try {
            String sql = "SELECT * FROM Absence";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new babsence (
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getObject(5, LocalDate.class)
                ));
            }
            tableabscence.setItems(data);
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }

    }
            }


