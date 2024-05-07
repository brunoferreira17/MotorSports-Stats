package org.motorsportstats.desktop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class WRCController {

    @FXML
    private Button BotaoEditarPerfil;
    @FXML
    private Button BotaoAoVivo;
    @FXML
    private TableColumn<Competicao, LocalDate> DataCorridas;
    @FXML
    private TableColumn<Competicao, String> Competicoes;
    @FXML
    private TableColumn<Competicao, String> País;
    @FXML
    private TableView TabelaWrc;
    @FXML
    private MenuButton MenuAnos;
    @FXML
    private ListView<Notificacao> ListaNotificacao;

    List<Competicao> competicoesWrc = Funcoes.GetCompeticoesWrc();
    Utilizador utilizadorlogado = AuthService.getUtilizadorLogado();

    @FXML
    private void handleButNotificacao()
    {
        if(ListaNotificacao.isVisible())
        {
            ListaNotificacao.setVisible(false);
        } else if (!ListaNotificacao.isVisible())
        {
            ListaNotificacao.setVisible(true);
        }
    }

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

    @FXML
    public void initialize()
    {
        carregarDados();
    }

    private void carregarDados()
    {
        int anoAtual = Year.now().getValue();

        MenuAnos.setText(String.valueOf(anoAtual));

        List<Competicao> competicoesWrcAno = Funcoes.GetCompeticoesPorAno(competicoesWrc,anoAtual);

        atualizarTabelas(competicoesWrcAno);

        adicionarAnosAoMenuButton();
    }

    private void adicionarAnosAoMenuButton()
    {
        for (Competicao competicao : competicoesWrc)
        {
            int ano = competicao.getDataInicio().getYear();

            boolean anoJaAdicionado = false;
            for (MenuItem item : MenuAnos.getItems()) {
                if (item.getText().equals(String.valueOf(ano))) {
                    anoJaAdicionado = true;
                    break;
                }
            }

            if (!anoJaAdicionado) {
                MenuItem menuItem = new MenuItem(String.valueOf(ano));
                menuItem.setOnAction(this::selecionarAno);
                MenuAnos.getItems().add(menuItem);
            }
        }
    }
    private void selecionarAno(ActionEvent event)
    {
        MenuItem menuItem = (MenuItem) event.getSource();
        int anoSelecionado = Integer.parseInt(menuItem.getText());

        MenuAnos.setText(menuItem.getText());

        List<Competicao> competicoesAnoSelecionado = Funcoes.GetCompeticoesPorAno(competicoesWrc, anoSelecionado);
        atualizarTabelas(competicoesAnoSelecionado);
    }

    private void atualizarTabelas(List<Competicao> competicoesWrc)
    {
        if (!competicoesWrc.isEmpty())
        {
            DataCorridas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDataInicio()));
            Competicoes.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getNome()));
            //Falta implementar Coluna Vencedor Da Respetiva Competiçao!
            País.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getPais()));

            TabelaWrc.setItems(FXCollections.observableArrayList(competicoesWrc));
            TabelaWrc.refresh();
        }

        TabelaWrc.setRowFactory(tv -> {
            TableRow<Competicao> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Competicao rowData = row.getItem();
                    ID_Saver.setId_competicao(rowData.getId());
                    Recursos.SceneSwitcher.switchScene("WRCCompeticao.fxml",row);
                }
            });
            return row;
        });
    }

}