package com.example.dualist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.transform.Scale;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Printyy implements Initializable {

    @FXML
    private TableColumn<babsence, LocalDate> ddate;

    @FXML
    private TableColumn<babsence, Integer> didenseignant;

    @FXML
    private TableColumn<babsence, Integer> didetudiant;

    @FXML
    private TableColumn<babsence, Integer> didmatiere;

    @FXML
    private TableColumn<babsence, Integer> didnumseance;
    @FXML
    private TableView<babsence> arrayab;
    private Connection con;
    @FXML
    private ObservableList<babsence> data;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = connect.bdConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        data = FXCollections.observableArrayList();
        setCellTable();
        loadData();

    }
    @FXML
    private Button printButton;

    @FXML
    private void printTable(ActionEvent event) {
        printTableView(arrayab);
    }

    @FXML
    private void initialize() {
        printButton.setOnAction(this::printTable);
    }

    private void setCellTable() {
        didetudiant.setCellValueFactory(new PropertyValueFactory<>("idetudiant"));
        didenseignant.setCellValueFactory(new PropertyValueFactory<>("idenseignant"));
        didmatiere.setCellValueFactory(new PropertyValueFactory<>("idmatiere"));
        didnumseance.setCellValueFactory(new PropertyValueFactory<>("numseance"));
        ddate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    private void loadData() {
        data.clear();
        try {
            String sql = "SELECT * FROM Absence";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new babsence(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getObject(5, LocalDate.class)
                ));
            }
            arrayab.setItems(data);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    private void printTableView(TableView<babsence> tableView) {
        PrinterJob job = PrinterJob.createPrinterJob();
        PageLayout pageLayout = Printer.getDefaultPrinter().createPageLayout(Printer.getDefaultPrinter().getDefaultPageLayout().getPaper(), Printer.getDefaultPrinter().getDefaultPageLayout().getPageOrientation(), Printer.MarginType.DEFAULT);
        double scaleX = pageLayout.getPrintableWidth() / tableView.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / tableView.getBoundsInParent().getHeight();
        Scale scale = new Scale(scaleX, scaleY);
        tableView.getTransforms().add(scale);

        if (job != null) {
            if (job.showPrintDialog(null)) {
                boolean success = job.printPage(tableView);
                if (success) {
                    job.endJob();
                }
            }
        }
    }


}

