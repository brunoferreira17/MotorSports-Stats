module org.motorsportstats.motorsportstatsdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.motorsportstatscore;


    opens org.motorsportstats.desktop to javafx.fxml;
    exports org.motorsportstats.desktop;
}