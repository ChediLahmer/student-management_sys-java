package com.example.dualist;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Graphe implements Initializable {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = connect.bdConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            chart();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private BarChart<?, ?> barchart;

    @FXML
    private AnchorPane mainform;
    public void chart() throws SQLException {
        String query = "SELECT month(date) AS month, count(*) AS absences FROM Absence GROUP BY month(date)";
        XYChart.Series chartdata = new XYChart.Series();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                chartdata.getData().add(new XYChart.Data(rs.getString(1),rs.getInt(2)));
            }
        barchart.getData().add(chartdata);

    }
}




