module org.motorsportstats.motorsportstatsservices {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.motorsportstats.motorsportstatsservices to javafx.fxml;
    exports org.motorsportstats.motorsportstatsservices;
}