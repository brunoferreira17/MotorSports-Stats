
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML da página inicial
        Parent root = FXMLLoader.load(getClass().getResource("C:Users/bruno/Desktop/ESCOLA/porg3/MotorSports-Stats/MotorSportStats-Desktop/src/main/java/paginainicial.fxml"));

        // Configura a cena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Página Inicial");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
