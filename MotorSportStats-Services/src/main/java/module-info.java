module org.motorsportstats.services {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.motorsportstatscore;


    opens org.motorsportstats.services to javafx.fxml;
    exports org.motorsportstats.services;
}