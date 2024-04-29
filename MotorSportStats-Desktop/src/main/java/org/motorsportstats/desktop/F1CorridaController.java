    package org.motorsportstats.desktop;

    import javafx.beans.property.SimpleIntegerProperty;
    import javafx.beans.property.SimpleStringProperty;
    import javafx.collections.FXCollections;
    import javafx.fxml.FXML;
    import javafx.scene.control.*;
    import org.motorsportstats.services.Funcoes;
    import org.motorsportstatscore.entity.*;

    import java.util.ArrayList;
    import java.util.List;
    import org.postgresql.util.PGInterval;


    public class F1CorridaController
    {
        @FXML
        private Button BotaoEditarPerfil;
        @FXML
        private Button BotaoAoVivo;
        @FXML
        private TableView<ResultadosFormula1> TabelaCorrida;
        @FXML
        private TableColumn<ResultadosFormula1, Integer> ColunaPosicao;
        @FXML
        private TableColumn<ResultadosFormula1, String> ColunaPiloto;
        @FXML
        private TableColumn<ResultadosFormula1, String> ColunaEquipa;
        @FXML
        private TableColumn<ResultadosFormula1, String> ColunaTempo;
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

        private void atualizarTabelaCorridas(Integer id_corrida) {
            List<Object[]> results = Funcoes.obterResultadosPorCorrida(id_corrida);
            List<ResultadosFormula1> resultados = new ArrayList<>();

            for (Object[] result : results) {
                int posicao = (int) result[0];
                String pilotoNome = (String) result[1];
                String equipaNome = (String) result[2];
                String tempoFormatado = formatarTempo(result[3]);

                resultados.add(new ResultadosFormula1(posicao, pilotoNome, equipaNome, tempoFormatado));
            }

            ColunaPosicao.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPosicao()).asObject());
            ColunaPiloto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPilotoNome()));
            ColunaEquipa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEquipaNome()));
            ColunaTempo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTempoFormatado()));

            TabelaCorrida.setItems(FXCollections.observableArrayList(resultados));
            TabelaCorrida.refresh();
        }




        private String formatarTempo(Object tempoObjeto) {
            if (tempoObjeto instanceof PGInterval tempoIntervalo) {
                long minutos = tempoIntervalo.getMinutes();
                long segundos = (long) tempoIntervalo.getSeconds();
                long microssegundos = tempoIntervalo.getMicroSeconds();

                long milissegundos = ((minutos * 60L + segundos) * 1000L) + (microssegundos / 1000L);

                int milissegundosFormatados = (int) (milissegundos / Math.pow(10, String.valueOf(milissegundos).length() - 3));

                return String.format("%d:%d:%d", minutos, segundos, milissegundosFormatados);
            } else {
                return "Formato de tempo inválido";
            }
        }




    }
