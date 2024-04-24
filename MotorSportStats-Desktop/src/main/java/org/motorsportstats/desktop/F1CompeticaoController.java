package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.*;

import java.util.List;
import java.util.Objects;

public class F1CompeticaoController
{
    @FXML
    private Button BotaoEditarPerfil;
    @FXML
    private VBox TabelaCorridas;
    @FXML
    private void handleButEditarPerfil()
    {
        Recursos.SceneSwitcher.switchScene("editarperfil.fxml",BotaoEditarPerfil);
    }

    public void initialize()
    {

    }

    private void atualizarTabelaCorridas(Utilizador utilizadorLogado, List<Corrida> corridas)
    {
        TabelaCorridas.getChildren().clear();
        if (corridas.isEmpty()) {
            Label aviso = new Label("Não há Corridas Desta Competiçao!");
            TabelaCorridas.getChildren().add(aviso);
        } else {
            List<Corrida> CorridasDaCompeticao = Funcoes.GetCorridasDaCompeticao(1);
            Accordion CorridasAccordion = new Accordion();

            for (Corrida corrida : CorridasDaCompeticao)
            {

                TitledPane titledPane = new TitledPane();
                titledPane.setText(corrida.getNome());

                // Criar o conteúdo do TitledPane para exibir os resultados da corrida
                VBox conteudoPane = new VBox();

                // Aqui você pode adicionar os resultados da corrida, por exemplo:
                List<Resultado> resultados = Funcoes.GetResultadosDaCorrida(corrida.getIdCorrida());
                for (Resultado resultado : resultados) {
                    HBox resultadoBox = new HBox();

                    Label posicaoLabel = new Label("Posição: " + resultado.getPosicao());
                    Label pilotosLabel = new Label("Pilotos: " + resultado.getPilotos());
                    Label tempoLabel = new Label("Tempo: " + resultado.getTempo());

                    resultadoBox.setSpacing(10);

                    resultadoBox.getChildren().addAll(posicaoLabel, pilotosLabel, tempoLabel);

                    conteudoPane.getChildren().add(resultadoBox);
                }

                titledPane.setContent(conteudoPane);

                CorridasAccordion.getPanes().add(titledPane);
            }

            TabelaCorridas.getChildren().add(CorridasAccordion);


        }
    }
}
