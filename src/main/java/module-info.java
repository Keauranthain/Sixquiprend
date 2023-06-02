module Java.sixquiprend {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens Java to javafx.fxml;
    exports Java;
    exports Java.Data.Printer;
    //exports;
    //opens to
}