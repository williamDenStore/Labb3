module com.william_k.labb3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.william_k.labb3 to javafx.fxml;
    exports com.william_k.labb3;
}