package com.example.premiumbrands;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import oracle.jdbc.driver.OracleDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AccountController {

    @FXML
    private TextField email;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField pn;

    @FXML
    private Button save;

    @FXML
    private Button returntostart;

    @FXML
    private AnchorPane show;

    int id;
    void setId(int Id)
    {
        this.id = Id;
    }

    public void show(MouseEvent ee){
        if (ee.getSource() == show) {
        try {
            DriverManager.registerDriver((new OracleDriver()));
            String URL="jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(URL, "C##alaa", "alaa");
            String query="Select UFNAME, ULNAME, UPHONE_NUMBER, UEMAIL, UPASS, U_ID from UUSER where U_ID = '" + id + "'";
            Statement ps=con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                fname.setText(rs.getString("UFNAME"));
                lname.setText(rs.getString("ULNAME"));
                email.setText(rs.getString("UEMAIL"));
                pn.setText(String.valueOf(rs.getInt("UPHONE_NUMBER")));
                pass.setText(rs.getString("UPASS"));

            }
            con.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }}


    @FXML
    public void returntostart(ActionEvent e) throws IOException {
        if (e.getSource() == returntostart) {
            Stage stage = (Stage) returntostart.getScene().getWindow();
            stage.close();
            Stage window = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
            window.setScene(new Scene(root));
            window.show();
        }
    }

    @FXML
    void save(ActionEvent event) {
        if (event.getSource() == save){
            try {
                DriverManager.registerDriver((new OracleDriver()));
                String URL="jdbc:oracle:thin:@localhost:1521:XE";
                Connection con = DriverManager.getConnection(URL, "C##alaa", "alaa");
                con.setAutoCommit(false);
                String query="UPDATE UUSER SET UFNAME = '" + fname.getText() + "', ULNAME = '" + lname.getText() + "', UPHONE_NUMBER = '" + pn.getText() + "', UEMAIL = '" + email.getText() + "', UPASS = '" + pass.getText() + "' where U_ID = '" + id + "'";
                Statement ps=con.createStatement();
                ps.executeUpdate(query);
                con.commit();
                con.close();
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }

    }
    }


}
