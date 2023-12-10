package com.example.premiumbrands;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import oracle.jdbc.driver.OracleDriver;

import java.io.IOException;
import java.sql.*;

public class SignInController {
    @FXML
    private Button GoToStart_BTN;
    @FXML
    private Button returntoSignUp;
    @FXML
    private TextField Emailtext;
    @FXML
    private PasswordField Passtext;
    @FXML
    private Text lable;
     int id;
    String BUYERORSELLER;
    @FXML
    public void SIGN_IN(ActionEvent event){
        lable.setDisable(true);
        String pass = Passtext.getText();
        try {
            DriverManager.registerDriver((new OracleDriver()));
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "C##alaa", "alaa");

            con.setAutoCommit(false);
            String query="Select U_ID, UEMAIL, UPASS, BUYERORSELLER from UUSER where UEMAIL= '" + Emailtext.getText() + "'";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("U_ID");
            System.out.println(id);
            if(pass.equals(rs.getString("UPASS")))
            {
                lable.setText("Login Successes");
//                  PreparedStatement stmt = con.prepareStatement("insert into SELLER values(?,?,?)");
//                  stmt.setInt(1,1);
//                stmt.setString(2,rs.getString("UEmail"));
//                stmt.setString(3,rs.getString("U_ID"));
                BUYERORSELLER=rs.getString("BUYERORSELLER");
                //stmt.executeUpdate();

                con.commit();
                con.close();
                if(event.getSource()==GoToStart_BTN){
                    Stage stage = (Stage)GoToStart_BTN.getScene().getWindow();
                    stage.close();
                    if(BUYERORSELLER.equals("B")){
                        Stage primaryStage=new Stage();
                        FXMLLoader loder1 = new FXMLLoader(getClass().getResource("Start.fxml"));
                        Parent root= loder1.load();
                        StartController st = loder1.getController();
                        st.setId(id);
                        primaryStage.setTitle("Premium Brands");
//                        Image image=new Image(("src/Picture9.png"));
//                        primaryStage.getIcons().add(image);
                        Scene scene=new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }
                    else {
                        Stage primaryStage=new Stage();
                        Parent root= FXMLLoader.load(getClass().getResource("Admin.fxml"));
                        primaryStage.setTitle("Admin");
                        Scene scene=new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        }
                }}
            else
                lable.setText("Password or Email not correct");

        }
        catch (Exception ex) {
            lable.setText("Password or Email not correct");

        }
    }



    @FXML
    void returntoSignUp(ActionEvent e) throws IOException {
        if(e.getSource() == returntoSignUp){
            Stage stage = (Stage)returntoSignUp.getScene().getWindow();
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
}
