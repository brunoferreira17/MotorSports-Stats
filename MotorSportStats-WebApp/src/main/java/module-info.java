module org.motorsportstats.motorsportsatswebapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.motorsportstats.motorsportsatswebapp to javafx.fxml;
    exports org.motorsportstats.motorsportsatswebapp;
}