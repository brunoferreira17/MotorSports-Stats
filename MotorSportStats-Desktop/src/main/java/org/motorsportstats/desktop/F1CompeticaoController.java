package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        atualizarTabelaCorridas(AuthService.getId_competicao());
    }

    private void atualizarTabelaCorridas(Integer id_competicao)
    {
        TabelaCorridas.getChildren().clear();

        List<Corrida> CorridasDaCompeticao = Funcoes.GetCorridasDaCompeticao(id_competicao);

        if (CorridasDaCompeticao.isEmpty()) {
            Label aviso = new Label("Não há Corridas Desta Competiçao!");
            TabelaCorridas.getChildren().add(aviso);
        } else {

            Accordion CorridasAccordion = new Accordion();

            for (Corrida corrida : CorridasDaCompeticao)
            {

                TitledPane titledPane = new TitledPane();
                titledPane.setText(corrida.getNome());

                // Criar o conteúdo do TitledPane para exibir os resultados da corrida
                VBox conteudoPane = new VBox();

                // Aqui você pode adicionar os resultados da corrida, por exemplo:
                List<Object[]> results = Funcoes.obterResultadosPorCorrida(corrida.getIdCorrida());

                // Itere sobre os resultados
                for (Object[] result : results) {
                    int posicao = (int) result[0];
                    String pilotoNome = (String) result[1];
                    String equipaNome = (String) result[2];
                    String tempo = result[3].toString(); // Tempo pode precisar de conversão para String

                    // Crie um HBox para exibir cada resultado
                    HBox resultadoBox = new HBox();

                    // Crie Labels para cada campo do resultado
                    Label posicaoLabel = new Label("Posição: " + posicao + "|");
                    Label pilotoLabel = new Label("Piloto: " + pilotoNome + "|");
                    Label equipaLabel = new Label("Equipa: " + equipaNome + "|");
                    Label tempoLabel = new Label("Tempo: " + tempo);


                    // Adicione os Labels ao HBox
                    resultadoBox.getChildren().addAll(posicaoLabel, pilotoLabel, equipaLabel, tempoLabel);

                    // Adicione o HBox ao conteúdo do TitledPane
                    conteudoPane.getChildren().add(resultadoBox);
                }


                titledPane.setContent(conteudoPane);

                CorridasAccordion.getPanes().add(titledPane);
            }

            TabelaCorridas.getChildren().add(CorridasAccordion);

        }
    }

}
