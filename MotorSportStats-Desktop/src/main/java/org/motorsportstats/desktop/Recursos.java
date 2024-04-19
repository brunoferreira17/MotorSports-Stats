package org.motorsportstats.desktop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

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

                //Inserir Icon
                Image icon = new Image(Objects.requireNonNull(SceneSwitcher.class.getResourceAsStream("capacete.png")));
                stage.getIcons().add(icon);

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

    public static class WindowManager
    {
        public static void openWindowToEdit(String fxmlFile, String Text)
        {
            try {
                // Carregar o arquivo FXML
                FXMLLoader loader = new FXMLLoader(WindowManager.class.getResource(fxmlFile));
                Parent root = loader.load();

                MiniPaginaEdicaoController Controller = loader.getController();
                Controller.SetLabel(Text);

                // Criar uma nova janela
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
