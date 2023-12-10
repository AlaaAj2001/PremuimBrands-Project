package com.example.premiumbrands;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oracle.jdbc.driver.OracleDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClothesInnerController implements Initializable {
    @FXML
    private Button BackToStart;
    @FXML
    private VBox Vbox;
    @FXML
    private Label Tname;
    private Parent root;
    private Node n , n2;

    ArrayList <ProductInnerController> arr1;
    int cid;
    void setId(int Id)
    {
        this.cid = Id;
    }

    void setinnerid()
    {
        for(ProductInnerController p : arr1)
        {
            p.setId(cid);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arr1 = new ArrayList<ProductInnerController>();
        String pro_name;
        int pro_price;
        String pro_color;
        String pro_size;

        //Blob pro_image;
        Tname.setText("Clothes");
        try {
            DriverManager.registerDriver((new OracleDriver()));
            String URL="jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(URL, "C##alaa", "alaa");
            con.setAutoCommit(false);
            String query="Select P#, PNAME, PRICE, COLOR, PSIZE, T_ID, PIMAGE from PRODUCT where T_ID = 1";
            Statement ps=con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next())
            {

                pro_name = rs.getString("PNAME");
                pro_price = rs.getInt("PRICE");
                pro_color= rs.getString("COLOR");
                pro_size = rs.getString("PSIZE");
                String pathh= rs.getString("PIMAGE");
                int Pid = rs.getInt("P#");
                //pro_image = rs.getBlob("PIMAGE");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Prod_info.fxml"));

                try {
                    n = loader.load();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                ProductInnerController ProdController = loader.getController();
                ProdController.DISPLAY(pro_name, pro_price, pro_color, pro_size, pathh);
                ProdController.setPid(Pid);
                Vbox.getChildren().add(n);
                arr1.add(ProdController);
            }
            }catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    public void BackToStart(ActionEvent e) throws IOException {
        if(e.getSource()== BackToStart){
            //System.out.println(cid);
            Stage stage = (Stage) BackToStart.getScene().getWindow();
            stage.close();
            Stage window = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

            window.setScene(new Scene(root));
            window.show();

        }
    }
}
