package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.*;

import java.util.List;

public class F1CorridaController
{
    @FXML
    private Button BotaoEditarPerfil;
    @FXML
    private Button BotaoAoVivo;
    @FXML
    private TableView TabelaCorrida;
    @FXML
    private TableColumn ColunaPosicao;
    @FXML
    private TableColumn ColunaPiloto;
    @FXML
    private TableColumn ColunaEquipa;
    @FXML
    private TableColumn ColunaTempo;
    @FXML
    private Label LabelNomeCorrida;
    @FXML
    private void handleButEditarPerfil()
    {
        Recursos.SceneSwitcher.switchScene("editarperfil.fxml",BotaoEditarPerfil);
    }

    @FXML
    private void handleButAoVivo()
    {
        Recursos.SceneSwitcher.switchScene("inicio_aovivo.fxml",BotaoAoVivo);
    }

    public void initialize()
    {
        atualizarTabelaCorridas(ID_Saver.getId_corrida());
    }

    private void atualizarTabelaCorridas(Integer id_corrida)
    {
        TabelaCorrida.getItems().clear(); // Limpa os itens existentes na tabela

        List<Object[]> results = Funcoes.obterResultadosPorCorrida(id_corrida);

        for (Object[] result : results) {
            int posicao = (int) result[0];
            String pilotoNome = (String) result[1];
            String equipaNome = (String) result[2];
            String tempo = result[3].toString(); // Tempo pode precisar de conversão para String

            TabelaCorrida.getItems().add(new Object[]{posicao, pilotoNome, equipaNome, tempo});
        }
    }

}
