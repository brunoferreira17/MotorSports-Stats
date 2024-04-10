package org.motorsportstats.desktop;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("paginainicial.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MotorSport-Stats");
        Image icon = new Image(Recursos.SceneSwitcher.class.getResourceAsStream("capacete.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}