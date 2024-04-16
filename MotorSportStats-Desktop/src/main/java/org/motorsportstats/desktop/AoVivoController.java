package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.Competicao;
import org.motorsportstatscore.entity.Corrida;
import org.motorsportstatscore.entity.TipoCompeticao;

import java.util.List;
import java.util.Objects;

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
                        HBox competicaoHBox = new HBox();

                        ImageView imageView = new ImageView();
                        imageView.setFitWidth(20);
                        imageView.setFitHeight(20);
                        Image selectedImage = new Image((getClass().getResourceAsStream("/images/star.png")));
                        Image deselectedImage = new Image((getClass().getResourceAsStream("/images/star2.png")));
                        imageView.setImage(deselectedImage);

                        imageView.setOnMouseClicked(event -> {
                            event.consume();
                            if (imageView.getImage() == deselectedImage) {
                                imageView.setImage(selectedImage);
                            } else {
                                imageView.setImage(deselectedImage);
                            }
                        });

                        competicaoHBox.getChildren().add(imageView);

                        Label competicaoLabel = new Label(competicao.getNome());
                        competicaoHBox.getChildren().add(competicaoLabel);

                        Pane filler = new Pane();
                        HBox.setHgrow(filler, Priority.ALWAYS);
                        competicaoHBox.getChildren().add(filler);

                        Label dataLabel = new Label(competicao.getDataInicio().toString());
                        competicaoHBox.getChildren().add(dataLabel);

                        competicaoHBox.setOnMouseClicked(event ->
                                Recursos.SceneSwitcher.switchScene("desporto.fxml",competicaoHBox));
                        tipoCompeticaoAccordion.getPanes().add(tipoCompeticaoPane);

                        competicaoBox.getChildren().add(competicaoHBox);
                    }
                }

                if (!competicaoBox.getChildren().isEmpty())
                {
                    tipoCompeticaoPane.setContent(competicaoBox);

                }
            }

            if (!tipoCompeticaoAccordion.getPanes().isEmpty())
            {
                TabelaAoVivo.getChildren().add(tipoCompeticaoAccordion);
            }
        }
    }
}
