package org.motorsportstats.desktop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.IOException;

public class Recursos
{
    public static class SceneSwitcher
    {

        public static void switchScene(String fxmlFile, Node node)
        {
            try
            {
                // Carregar o arquivo FXML
                FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(fxmlFile));
                Parent root = loader.load();

                // Criar uma nova cena com a raiz do arquivo FXML
                Scene scene = new Scene(root);

                // Obter a janela principal
                Stage stage = (Stage) node.getScene().getWindow();

                // Definir a cena na janela principal
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
