package com.example.premiumbrands;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import oracle.jdbc.driver.OracleDriver;

import java.io.IOException;
import java.sql.*;

public class AdminController {
    @FXML
    private Button VBI;

    @FXML
    private Button VPI;

    //@FXML
    //private TextArea TEXTAREA;

    @FXML
    private TableView <ProductClass>T;

    @FXML
    private TableColumn <ProductClass,Integer> c1;

    @FXML
    private TableColumn <ProductClass,String> c2;

    @FXML
    private TableColumn <ProductClass,String> c3;

    @FXML
    private TableColumn <ProductClass,String> c4;

    @FXML
    private TableColumn <ProductClass,Integer> c5;

    @FXML
    private TableColumn <ProductClass,String> c6;


    @FXML
    public void VPI(ActionEvent e) throws IOException {
        if(e.getSource()== VPI ) {
            c1.setCellValueFactory(new PropertyValueFactory<ProductClass, Integer>("c1"));
            c2.setCellValueFactory(new PropertyValueFactory<ProductClass, String>("c2"));
            c3.setCellValueFactory(new PropertyValueFactory<ProductClass, String>("c3"));
            c4.setCellValueFactory(new PropertyValueFactory<ProductClass, String>("c4"));
            c5.setCellValueFactory(new PropertyValueFactory<ProductClass, Integer>("c5"));
            c6.setCellValueFactory(new PropertyValueFactory<ProductClass, String>("c6"));

            ObservableList<ProductClass> list = FXCollections.observableArrayList();
            try {
            DriverManager.registerDriver((new OracleDriver()));
            String URL="jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(URL, "C##alaa", "alaa");
            con.setAutoCommit(false);

            String query="Select PRODUCT.P#, PRODUCT.PNAME, PRODUCT.COLOR, PRODUCT.PRICE, PRODUCT.PSIZE, PRODUCT.T_ID, TYPE.T_ID, TYPE.TNAME  from PRODUCT,TYPE WHERE PRODUCT.T_ID = TYPE.T_ID ";
            Statement ps=con.createStatement();
            ResultSet rs = ps.executeQuery(query);

                c1.setText("Product Number");
                c2.setText("Name");
                c3.setText("Color");
                c4.setText("Size");
                c5.setText("Price");
                c6.setText("Type");

            while (rs.next())
            {
                String pro_name = rs.getString("PNAME");
                int pro_price = rs.getInt("PRICE");
                String pro_color= rs.getString("COLOR");
                String pro_size = rs.getString("PSIZE");
                int Pid = rs.getInt("P#");
                String Type = rs.getString("TNAME");


                list.add(new ProductClass(Pid , pro_name, pro_color, pro_size, pro_price, Type));


                T.setItems(list);

//                this.TEXTAREA.appendText(Pid + "\t" + pro_name + "\t" + pro_color + "\t" + pro_size + "\t" + pro_price+ "\n");
                }
            con.commit();
            con.close();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        }

    }

    @FXML
    public void VBI(ActionEvent e) throws IOException {
        if(e.getSource()== VBI ) {
                c1.setCellValueFactory(new PropertyValueFactory<ProductClass, Integer>("c1"));
                c2.setCellValueFactory(new PropertyValueFactory<ProductClass, String>("c2"));
                c3.setCellValueFactory(new PropertyValueFactory<ProductClass, String>("c3"));
                c4.setCellValueFactory(new PropertyValueFactory<ProductClass, String>("c4"));
                c5.setCellValueFactory(new PropertyValueFactory<ProductClass, Integer>("c5"));
                c6.setCellValueFactory(new PropertyValueFactory<ProductClass, String>("c6"));

            ObservableList<ProductClass> list = FXCollections.observableArrayList();
                try {
                    DriverManager.registerDriver((new OracleDriver()));
                    String URL="jdbc:oracle:thin:@localhost:1521:XE";
                    Connection con = DriverManager.getConnection(URL, "C##alaa", "alaa");
                    con.setAutoCommit(false);

                    String query="Select UUSER.U_ID, UUSER.UFNAME, UUSER.ULNAME, UUSER.UEMAIL, UUSER.UPHONE_NUMBER, UUSER.ADDRESS_ID , ADDRESS.A_ID ,ADDRESS.CITY from UUSER,ADDRESS where BUYERORSELLER = 'B' AND ADDRESS.A_ID = UUSER.ADDRESS_ID ";
                    Statement ps=con.createStatement();
                    ResultSet rs = ps.executeQuery(query);

                    c1.setText("Buyer ID");
                    c2.setText("First Name");
                    c3.setText("Last Name");
                    c4.setText("Email");
                    c5.setText("PhoneNum");
                    c6.setText("City");

                    while (rs.next())
                    {
                        String u_fname = rs.getString("UFNAME");
                        String u_lname = rs.getString("ULNAME");
                        String u_email= rs.getString("UEMAIL");
                        String u_address = rs.getString("CITY");
                        int uid = rs.getInt("U_ID");
                        int upn = rs.getInt("UPHONE_NUMBER");

                        list.add(new ProductClass(uid , u_fname, u_lname, u_email, upn, u_address));
                        T.setItems(list);

//                this.TEXTAREA.appendText(Pid + "\t" + pro_name + "\t" + pro_color + "\t" + pro_size + "\t" + pro_price+ "\n");
                    }
                    con.commit();
                    con.close();

                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }
}
