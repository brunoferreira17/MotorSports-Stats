package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.Corrida;
import org.motorsportstatscore.entity.TipoCompeticao;

import java.util.List;

public class AoVivoController
{

    @FXML
    private VBox TabelaAoVivo;

    public void initialize()
    {
        List<Corrida> corridas = Funcoes.GetCorridasDoDia();

        if(corridas.isEmpty())
        {
            Label aviso = new Label("Nao há Corridas Hoje!");
            TabelaAoVivo.getChildren().add(aviso);
        }else
        {
            List<TipoCompeticao> tipocompeticaododia = Funcoes.GetTipoDeCompeticoesDoDia();

            for (TipoCompeticao tipoCompeticao : tipocompeticaododia)
            {
                TitledPane titledPane = new TitledPane();
                titledPane.setText(tipoCompeticao.getTipoCompeticao());

                TabelaAoVivo.getChildren().add(titledPane);
            }
        }
    }
}
