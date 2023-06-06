module Java.sixquiprend {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires junit;
    requires org.testng;
    requires java.desktop;


    opens Java.Data.Controler to javafx.fxml;
    opens Java.Data to javafx.fxml;
    exports Java;
    exports Java.Data;
    exports Java.Data.Controler;
}