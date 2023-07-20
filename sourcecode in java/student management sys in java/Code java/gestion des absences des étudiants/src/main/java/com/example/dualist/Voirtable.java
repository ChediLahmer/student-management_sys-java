package com.example.dualist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Voirtable implements Initializable {
    private Connection con;
    @FXML
    private TableColumn<babsence, Date> fccdate;
    @FXML
    private TableColumn<babsence,Integer> fccidenseignant;
    @FXML
    private TableColumn<babsence,Integer> fccidetudiant;
    @FXML
    private TableColumn<babsence,Integer> fccidmatiere;
    @FXML
    private TableColumn<babsence,Integer> fccnumseance;
    @FXML
    private TableView<babsence> tableabscence1;
    @FXML
    private ObservableList<babsence> dataa;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = connect.bdConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dataa = FXCollections.observableArrayList();
        setCellTable();
        loadData();

    }
    private void setCellTable() {
        fccidetudiant.setCellValueFactory(new PropertyValueFactory<>("idetudiant"));
        fccidenseignant.setCellValueFactory(new PropertyValueFactory<>("idenseignant"));
        fccidmatiere.setCellValueFactory(new PropertyValueFactory<>("idmatiere"));
        fccnumseance.setCellValueFactory(new PropertyValueFactory<>("numseance"));
        fccdate.setCellValueFactory(new PropertyValueFactory<>("date"));

    }
    @FXML
    private void loadData() {

        dataa.clear();
        try {
            String sql = "SELECT * FROM Absence";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dataa.add(new babsence (
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getObject(5, LocalDate.class)
                ));
            }
            tableabscence1.setItems(dataa);
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }

    }

}
