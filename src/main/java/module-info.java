module com.example.premiumbrands {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ojdbc8;
    //requires jasperreports;


    opens com.example.premiumbrands to javafx.fxml;
    exports com.example.premiumbrands;
}
