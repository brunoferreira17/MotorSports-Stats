module MotorSportStats.Desktop {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.motorsportstats.desktop to javafx.fxml;
    exports org.motorsportstats.desktop;
}
