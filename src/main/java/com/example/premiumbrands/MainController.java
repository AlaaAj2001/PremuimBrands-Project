package com.example.premiumbrands;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {
    @FXML
    private Button SignUp;
    @FXML
    private Button SignIn;


    @FXML
    void open_signup(ActionEvent e) throws IOException {
        if(e.getSource() == SignUp){
            Stage stage = (Stage)SignUp.getScene().getWindow();
            stage.close();
            Stage window =new Stage();
            Parent root= FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            window.setTitle("Premium Brands");
            //Image image=new Image("Picture9.png");
            //window.getIcons().add(image);
            window.setScene(new Scene(root,480,480));
            window.show();

        }
    }

    @FXML
    void open_signin(ActionEvent e) throws IOException {
        if(e.getSource() == SignIn){
            Stage stage = (Stage)SignIn.getScene().getWindow();
            stage.close();
            Stage window =new Stage();
            Parent root= FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            window.setTitle("Premium Brands");
            //Image image=new Image("Picture9.png");
            //window.getIcons().add(image);
            window.setScene(new Scene(root,480,480));
            window.show();

        }
    }

}
    //@FXML
    //private VBox vbox;
    //private Parent fxml;


//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
//        t.setToX(vbox.getLayoutX()*20);
//        t.play();
//        t.setOnFinished((e) ->
//        {
//            try
//            {
//                fxml = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
//                vbox.getChildren().removeAll();
//                vbox.getChildren().setAll(fxml);
//            }catch(IOException ex)
//            {
//
//            }
//        });
//    }
//
//    @FXML
//    private void open_signin(ActionEvent event)
//    {
//        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
//        t.setToX(vbox.getLayoutX()*20);
//        t.play();
//        t.setOnFinished((e) ->
//        {
//            try
//            {
//                fxml = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
//                vbox.getChildren().removeAll();
//                vbox.getChildren().setAll(fxml);
//            }catch(IOException ex)
//            {
//
//            }
//        });
//    }
//    @FXML
//    private void open_signup(ActionEvent event)
//    {
//        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
//        t.setToX(0);
//        t.play();
//        t.setOnFinished((e) ->
//        {
//            try
//            {
//                fxml = FXMLLoader.load(getClass().getResource("SIGNUPP.fxml"));
//                vbox.getChildren().removeAll();
//                vbox.getChildren().setAll(fxml);
//            }catch(IOException ex)
//            {
//
//            }
//        });
//    }
//
//
//
//}

