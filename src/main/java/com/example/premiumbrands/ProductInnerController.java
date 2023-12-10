package com.example.premiumbrands;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
import oracle.jdbc.driver.OracleDriver;
//import net.sf.jasperreports.engine.design.JasperDesign;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductInnerController {
    @FXML
    private ImageView imagee;

    @FXML
    private Label namel;

    @FXML
    private Label pricel;

    @FXML
    private Label colorl;

    @FXML
    private Label sizel;

    @FXML
    private Button addtosh;

    int Pid;
    void setPid(int Id)
    {
        this.Pid = Id;
    }
    int uid;
    void setId(int Id)
    {
        this.uid = Id;
    }
    @FXML
    public void DISPLAY(String name, int price, String color, String size, String path) throws FileNotFoundException {
        InputStream stream = new FileInputStream(path);
        Image image = new Image(stream);
        imagee.setImage(image);
        namel.setText(name);
        pricel.setText(String.valueOf(price));
        colorl.setText(color);
        sizel.setText(size);
    }


    @FXML
    public void addtosh(ActionEvent e) throws IOException, SQLException{//JRException {
        if(e.getSource()== addtosh) {

//            DriverManager.registerDriver((new OracleDriver()));
//            String URL="jdbc:oracle:thin:@localhost:1521:XE";
//            Connection con = DriverManager.getConnection(URL, "C##alaa", "alaa");
//            InputStream input = new FileInputStream(new File("invoice.jrxml"));
//            JasperDesign jd = JRXmlLoader.load(input);
//            JasperReport jr = JasperCompileManager.compileReport(jd);
//            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
//            OutputStream os = new FileOutputStream(new File("invoice.pdf"));
//            JasperExportManager.exportReportToPdfStream(jp , os);
//            os.close();
//            input.close();


        }
}
}

