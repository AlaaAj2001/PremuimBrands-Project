package com.example.premiumbrands;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ShoppingBagController {
    @FXML
    private Button BackToStart;

    @FXML
    public void BackToStart(ActionEvent e) throws IOException {
        if(e.getSource()== BackToStart) {
            Stage stage = (Stage) BackToStart.getScene().getWindow();
            stage.close();
            Stage window = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
            window.setScene(new Scene(root));
            window.show();

        }
    }


}
