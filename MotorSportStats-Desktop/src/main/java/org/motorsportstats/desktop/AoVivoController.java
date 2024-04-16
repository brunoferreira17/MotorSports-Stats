package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.Competicao;
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
            List<Competicao> competicaododia = Funcoes.GetCompeticoesDoDia();

            Accordion tipoCompeticaoAccordion = new Accordion();

            for (TipoCompeticao tipoCompeticao : tipocompeticaododia)
            {
                TitledPane tipoCompeticaoPane = new TitledPane();
                tipoCompeticaoPane.setText(tipoCompeticao.getTipoCompeticao());

                VBox competicaoBox = new VBox();

                for (Competicao competicao : competicaododia)
                {
                    if (competicao.getIdTipoCompeticao() == tipoCompeticao)
                    {
                        Label competicaoLabel = new Label(competicao.getNome());
                        competicaoBox.getChildren().add(competicaoLabel);
                    }
                }

                if (!competicaoBox.getChildren().isEmpty())
                {
                    tipoCompeticaoPane.setContent(competicaoBox);
                    tipoCompeticaoAccordion.getPanes().add(tipoCompeticaoPane);
                }
            }

            if (!tipoCompeticaoAccordion.getPanes().isEmpty())
            {
                TabelaAoVivo.getChildren().add(tipoCompeticaoAccordion);
            }
        }
    }
}
