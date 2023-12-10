package com.example.premiumbrands;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import oracle.jdbc.driver.OracleDriver;
import oracle.sql.DATE;

import java.io.IOException;
import java.sql.*;

public class SignUpController {
    @FXML
    private Button start;
    @FXML
    private Button returntoSignIn;
    @FXML
    private TextField fname;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField lname;
    @FXML
    private TextField email;
    @FXML
    private TextField pn;
    @FXML
    private TextField loca_id;
    @FXML
    private TextField u_id;
    @FXML
    private TextField city;
    @FXML
    private TextField street;
    @FXML
    private Text lable;

    @FXML
    String tmpSB="B";
    public void GoToStart(ActionEvent e) throws IOException {
        lable.setDisable(true);
        if (email.getText().equals("") || fname.getText().equals("") || lname.getText().equals("") || pass.getText().equals("") || loca_id.getText().equals("") || city.getText().equals("") || street.getText().equals("")){
            lable.setText("You should fill all field");
        }
        else
         if (isValidEmailAddress(email.getText())) {
            if ((email.getText().equals("alaaaj2001@gmail.com")) || (email.getText().equals("masa.m2001@gmail.com")))
                tmpSB = "A";
            else
                tmpSB = "B";

                try {
                    DriverManager.registerDriver(new OracleDriver());
                    String url = "jdbc:oracle:thin:@localhost:1521:XE";
                    Connection con = DriverManager.getConnection(url, "C##alaa", "alaa");
                    con.setAutoCommit(false);
                    {
                        PreparedStatement AD = con.prepareStatement("insert into ADDRESS values(?,?,?)");
                        AD.setInt(1, Integer.parseInt(loca_id.getText()));
                        AD.setString(2, city.getText());
                        AD.setString(3, street.getText());
                        AD.executeUpdate();

                        PreparedStatement ps = con.prepareStatement("insert into UUSER values(?,?,?,?,?,?,?,?)");
                        ps.setInt(1, Integer.parseInt(u_id.getText()));
                        ps.setInt(7, Integer.parseInt(loca_id.getText()));
                        ps.setString(8, tmpSB);
                        ps.setString(3, email.getText());
                        ps.setString(4, fname.getText());
                        ps.setString(5, lname.getText());
                        ps.setString(2, pass.getText());
                        ps.setInt(6, Integer.parseInt(pn.getText()));
                        ps.executeUpdate();
                        con.commit();
                        con.close();
                        lable.setText("Success");

                        if (e.getSource() == start) {
                            Stage stage = (Stage) start.getScene().getWindow();
                            stage.close();
                            Stage window = new Stage();
                            Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                            window.setScene(new Scene(root));
                            window.show();
                        }

                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    lable.setText("Error");
                }

            }
        else
        {
            lable.setText("Invalid Email");
        }
    }
                public boolean isValidEmailAddress (String email){
                    String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
                    java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
                    java.util.regex.Matcher m = p.matcher(email);
                    return m.matches();
                }
                @FXML
                void returntoSignIn (ActionEvent e) throws IOException {
                    if (e.getSource() == returntoSignIn) {
                        Stage stage = (Stage) returntoSignIn.getScene().getWindow();
                        stage.close();
                        Stage window = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                        window.setTitle("Premium Brands");
                        //Image image=new Image("Picture9.png");
                        //window.getIcons().add(image);
                        window.setScene(new Scene(root, 480, 480));
                        window.show();

                    }
                }}

