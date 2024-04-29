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

public class Formula1Controller
{
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
    private TableView TabelaFormula1;
    @FXML
    private MenuButton MenuAnos;

    List<Competicao> competicoesFormula1 = Funcoes.GetCompeticoesFormula1();

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

        List<Competicao> competicoesFormula1Ano = Funcoes.GetCompeticoesPorAno(competicoesFormula1,anoAtual);

        atualizarTabelas(competicoesFormula1Ano);

        adicionarAnosAoMenuButton();
    }

    private void adicionarAnosAoMenuButton()
    {
        for (Competicao competicao : competicoesFormula1)
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

        List<Competicao> competicoesAnoSelecionado = Funcoes.GetCompeticoesPorAno(competicoesFormula1, anoSelecionado);
        atualizarTabelas(competicoesAnoSelecionado);
    }

    private void atualizarTabelas(List<Competicao> competicoesFormula1)
    {
        if (!competicoesFormula1.isEmpty())
        {
            DataCorridas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDataInicio()));
            Competicoes.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getNome()));
            //Falta implementar Coluna Vencedor Da Respetiva Competiçao!
            País.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getPais()));

            TabelaFormula1.setItems(FXCollections.observableArrayList(competicoesFormula1));
            TabelaFormula1.refresh();
        }

        TabelaFormula1.setRowFactory(tv -> {
            TableRow<Competicao> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Competicao rowData = row.getItem();
                    ID_Saver.setId_competicao(rowData.getId());
                    Recursos.SceneSwitcher.switchScene("F1Competicao.fxml",row);
                }
            });
            return row;
        });
    }
}
