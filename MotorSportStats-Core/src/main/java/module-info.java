module org.motorsportstatscore
{
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires java.persistence;
    requires spring.context;
    requires org.hibernate.orm.core;

    opens org.motorsportstatscore to javafx.fxml;
    opens org.motorsportstatscore.entity to org.hibernate.orm.core;
    opens org.motorsportstatscore.repository to org.hibernate.orm.core;
    exports org.motorsportstatscore.entity;
    exports org.motorsportstatscore.repository;
}