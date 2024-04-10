module org.motorsportstatscore
{
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires java.persistence;
    requires spring.context;
    requires org.hibernate.orm.core;

    opens org.motorsportstatscore to javafx.fxml;
    exports org.motorsportstatscore.entity;
    exports org.motorsportstatscore.repository;
}