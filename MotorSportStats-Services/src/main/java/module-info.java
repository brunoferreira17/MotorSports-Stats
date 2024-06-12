module org.motorsportstats.services {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.motorsportstatscore;
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires java.persistence;
    requires spring.context;
    requires org.hibernate.orm.core;
    requires spring.beans;
    requires spring.tx;
    requires spring.data.commons;


    opens org.motorsportstats.services to javafx.fxml;
    exports org.motorsportstats.services;
}