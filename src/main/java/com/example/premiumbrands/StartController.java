package com.example.premiumbrands;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import oracle.jdbc.driver.OracleDriver;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StartController {
    @FXML
    private Button shopping;
    @FXML
    private Button account;
    @FXML
    private Button clothes;
    @FXML
    private Button shoes;
    @FXML
    private Button glasses;
    @FXML
    private Button watches;

    int id;
    void setId(int Id)
    {
        this.id = Id;
    }

    @FXML
    public void clothes(ActionEvent e) throws IOException {
        if(e.getSource()== clothes ) {
            System.out.println(id);
            Stage stage = (Stage) clothes.getScene().getWindow();
            stage.close();
            Stage window = new Stage();
            FXMLLoader loder1 = new FXMLLoader(getClass().getResource("clothes_Inner.fxml"));
            Parent root= loder1.load();
            ClothesInnerController st = loder1.getController();
            st.setId(id);
            st.setinnerid();
            window.setScene(new Scene(root));
            window.show();

        }
    }

    @FXML
    public void shoes(ActionEvent e) throws IOException {

        if(e.getSource()== shoes) {
            Stage stage = (Stage) shoes.getScene().getWindow();
            stage.close();
            Stage window = new Stage();
            FXMLLoader loder1 = new FXMLLoader(getClass().getResource("shoes_Inner.fxml"));
            Parent root= loder1.load();
            ShoesInnerController st = loder1.getController();
            st.setId(id);
            st.setinnerid();
            window.setScene(new Scene(root));
            window.show();

        }
    }

    @FXML
    public void glasses(ActionEvent e) throws IOException {
        if(e.getSource()== glasses) {
            Stage stage = (Stage) glasses.getScene().getWindow();
            stage.close();
            Stage window = new Stage();
            FXMLLoader loder1 = new FXMLLoader(getClass().getResource("glasses_Inner.fxml"));
            Parent root= loder1.load();
            GlassesInnerController st = loder1.getController();
            st.setId(id);
            st.setinnerid();
            window.setScene(new Scene(root));
            window.show();

        }
    }

    @FXML
    public void watches(ActionEvent e) throws IOException {

        if(e.getSource()== watches) {
            Stage stage = (Stage) watches.getScene().getWindow();
            stage.close();
            Stage window = new Stage();
            FXMLLoader loder1 = new FXMLLoader(getClass().getResource("watches_Inner.fxml"));
            Parent root= loder1.load();
            WatchesInnerController st = loder1.getController();
            st.setId(id);
            st.setinnerid();
            window.setScene(new Scene(root));
            window.show();

        }
    }

    @FXML
    public void GoToShopping(ActionEvent e) throws IOException {
        if(e.getSource()== shopping) {
            Stage stage = (Stage) shopping.getScene().getWindow();
            stage.close();
            Stage window = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("shoppingbag.fxml"));
            window.setScene(new Scene(root));
            window.show();

        }
    }

    @FXML
    void GoToAccount(ActionEvent e) throws IOException {
        if(e.getSource() == account){
            Stage stage = (Stage)account.getScene().getWindow();
            stage.close();
            Stage window =new Stage();
            FXMLLoader loder1 = new FXMLLoader(getClass().getResource("PersonalAccount.fxml"));
            Parent root= loder1.load();
            AccountController ac = loder1.getController();
            ac.setId(id);
            window.setTitle("Your Acount");
            window.setScene(new Scene(root));
            window.show();

        }
    }
}
