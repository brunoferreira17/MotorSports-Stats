    package org.motorsportstats.desktop;

    import javafx.fxml.FXML;
    import javafx.scene.control.*;
    import org.motorsportstats.services.Funcoes;
    import org.motorsportstatscore.entity.*;

    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    import org.postgresql.util.PGInterval;


    public class F1CorridaController
    {
        @FXML
        private Button BotaoEditarPerfil;
        @FXML
        private Button BotaoAoVivo;
        @FXML
        private TableView<String> TabelaCorrida;
        @FXML
        private TableColumn<Corrida, Date> ColunaPosicao;
        @FXML
        private TableColumn<Corrida, String> ColunaPiloto;
        @FXML
        private TableColumn<Corrida, String> ColunaEquipa;
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

        private void atualizarTabelaCorridas(Integer id_corrida) {
            List<Object[]> results = Funcoes.obterResultadosPorCorrida(id_corrida);

            for (Object[] result : results) {
                int posicao = (int) result[0];
                String pilotoNome = (String) result[1];
                String equipaNome = (String) result[2];
                String tempoFormatado = formatarTempo(result[3]);

                List<String> rowItems = new ArrayList<>();
                rowItems.add(Integer.toString(posicao));
                rowItems.add(pilotoNome);
                rowItems.add(equipaNome);
                rowItems.add(tempoFormatado);

                // Adicionar os itens da linha à TableView
                TabelaCorrida.getItems().addAll(rowItems);
            }
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
