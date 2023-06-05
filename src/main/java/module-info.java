module Java.sixquiprend {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires junit;
    requires org.testng;


    opens Java to javafx.fxml;
    exports Java;
    exports Java.Data.Printer;
    //exports;
    //opens to
}