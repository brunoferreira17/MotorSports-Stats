module MotorSportStats.WebApp
{
    requires org.motorsportstatscore;
    requires org.motorsportstats.services;
    requires spring.context;
    requires spring.web;
    requires spring.boot.autoconfigure;
    requires spring.boot;

    exports org.motorsportstatswebapp;
    opens org.motorsportstatswebapp;

}