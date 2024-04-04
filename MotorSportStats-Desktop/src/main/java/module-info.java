module org.motorsportstats.motorsportstatsdesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.motorsportstats.motorsportstatsdesktop to javafx.fxml;
    exports org.motorsportstats.motorsportstatsdesktop;
}