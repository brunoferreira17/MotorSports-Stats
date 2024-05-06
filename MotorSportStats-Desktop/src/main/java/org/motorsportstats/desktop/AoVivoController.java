package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class AoVivoController
{

    @FXML
    private VBox TabelaAoVivo;
    @FXML
    private ListView<String> ListaCompFav;
    @FXML
    private ListView<String> ListaEquipFav;
    @FXML
    private ListView<String> ListaPilotoFav;
    @FXML
    private DatePicker DataEscolhida;
    @FXML
    private Button BotaoTodos;
    @FXML
    private Button BotaoEditarPerfil;
    @FXML
    private Button BotaoFormula1;
    @FXML
    private Button BotaoMotoGP;
    @FXML
    private Button BotaoWRC;
    @FXML
    private void handleButbotaoTodos()
    {
        Recursos.SceneSwitcher.switchScene("desporto.fxml", BotaoTodos);
    }
    @FXML
    private void handleButEditarPerfil()
    {
        Recursos.SceneSwitcher.switchScene("editarperfil.fxml",BotaoEditarPerfil);
    }

    @FXML
    private void handleButFormula1()
    {
        Recursos.SceneSwitcher.switchScene("Formula1.fxml",BotaoFormula1);
    }

    @FXML
    private void handleButMotoGP()
    {
        Recursos.SceneSwitcher.switchScene("MotoGP.fxml",BotaoMotoGP);
    }

    @FXML
    private void handleButWRC()
    {
        Recursos.SceneSwitcher.switchScene("WRC.fxml",BotaoWRC);
    }


    public void initialize() {
        configurarDatePicker();
        carregarDados();
    }

    private void configurarDatePicker() {
        DataEscolhida.setValue(LocalDate.now());
        DataEscolhida.valueProperty().addListener((observable, oldValue, newValue) -> carregarDados());
    }

    private void carregarDados() {
        Utilizador utilizadorLogado = AuthService.getUtilizadorLogado();

        //List<TipoCompeticao> tipoCompeticoesFavoritas = Funcoes --- Por Fazer a Funçao

        List<Competicao> competicoesFavoritas = Funcoes.GetCompeticoesFavoritasDoUtilizador(utilizadorLogado);
        List<Equipa> EquipasFavoritos = Funcoes.GetEquipasFavoritasDoUtilizador(utilizadorLogado);
        List<Piloto> PilotosFavoritos = Funcoes.GetPilotosFavoritosDoUtilizador(utilizadorLogado);
        List<Corrida> corridas = Funcoes.GetCorridasDoDia(DataEscolhida.getValue());

        atualizarTabelaCorridas(utilizadorLogado,corridas);
        carregarListasFavoritos(competicoesFavoritas, EquipasFavoritos, PilotosFavoritos);
    }

    private void atualizarTabelaCorridas(Utilizador utilizadorLogado,List<Corrida> corridas)
    {

        TabelaAoVivo.getChildren().clear();
        if (corridas.isEmpty()) {
            Label aviso = new Label("Não há Corridas Hoje!");
            TabelaAoVivo.getChildren().add(aviso);
        } else {
            List<TipoCompeticao> tipocompeticaododia = Funcoes.GetTipoDeCompeticoesDoDia(DataEscolhida.getValue());
            List<Competicao> competicaododia = Funcoes.GetCompeticoesDoDia(DataEscolhida.getValue());
            Accordion tipoCompeticaoAccordion = new Accordion();

            for (TipoCompeticao tipoCompeticao : tipocompeticaododia) {
                TitledPane tipoCompeticaoPane = new TitledPane();
                tipoCompeticaoPane.setText(tipoCompeticao.getTipoCompeticao());
                VBox competicaoBox = new VBox();

                for (Competicao competicao : competicaododia) {
                    if (competicao.getIdTipoCompeticao() == tipoCompeticao) {
                        HBox competicaoHBox = new HBox();
                        ImageView imageView = new ImageView();
                        imageView.setFitWidth(20);
                        imageView.setFitHeight(20);
                        Image selectedImage = new Image((Objects.requireNonNull(getClass().getResourceAsStream("/images/star.png"))));
                        Image deselectedImage = new Image((Objects.requireNonNull(getClass().getResourceAsStream("/images/star2.png"))));

                        if(utilizadorLogado.getFavoritos().stream().anyMatch(favorito -> favorito.getCompeticaos().contains(competicao))) {
                            imageView.setImage(selectedImage);
                        } else {
                            imageView.setImage(deselectedImage);
                        }

                        imageView.setOnMouseClicked(event -> {
                            event.consume();
                            if (imageView.getImage() == deselectedImage) {
                                Funcoes.AdicionarCompeticaoFavorito(competicao,utilizadorLogado);
                                imageView.setImage(selectedImage);
                            } else {
                                Funcoes.RemoverCompeticaoFavorito(competicao,utilizadorLogado);
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
                                Recursos.SceneSwitcher.switchScene("F1Competicao.fxml",competicaoHBox));
                        tipoCompeticaoAccordion.getPanes().add(tipoCompeticaoPane);
                        competicaoBox.getChildren().add(competicaoHBox);


                    }
                }

                if (!competicaoBox.getChildren().isEmpty()) {
                    tipoCompeticaoPane.setContent(competicaoBox);
                }
            }

            if (!tipoCompeticaoAccordion.getPanes().isEmpty()) {
                TabelaAoVivo.getChildren().add(tipoCompeticaoAccordion);
            }
        }
    }

    private void carregarListasFavoritos(List<Competicao> competicoesFavoritas, List<Equipa> EquipasFavoritos, List<Piloto> PilotosFavoritos) {

        ListaCompFav.getItems().clear();
        ListaEquipFav.getItems().clear();
        ListaPilotoFav.getItems().clear();

        for(Competicao competicao: competicoesFavoritas) {
            ListaCompFav.getItems().add(competicao.getNome());
        }

        for(Equipa equipa : EquipasFavoritos) {
            ListaEquipFav.getItems().add(equipa.getNome());
        }

        for(Piloto piloto : PilotosFavoritos) {
            ListaPilotoFav.getItems().add(piloto.getNome());
        }
    }
}
