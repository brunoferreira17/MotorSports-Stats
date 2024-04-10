module org.motorsportstatscore
{
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires java.persistence;
    requires spring.context;

    opens org.motorsportstatscore to javafx.fxml;
    exports org.motorsportstatscore.entity;
    exports org.motorsportstatscore.repository;
}