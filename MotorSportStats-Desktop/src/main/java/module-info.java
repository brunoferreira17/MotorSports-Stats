module org.motorsportstats.motorsportstatsdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.motorsportstatscore;
    requires org.motorsportstats.services;
    requires org.postgresql.jdbc;


    opens org.motorsportstats.desktop to javafx.fxml;
    exports org.motorsportstats.desktop;
}