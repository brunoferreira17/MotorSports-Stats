package org.motorsportstats.desktop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.AuthService;
import org.motorsportstatscore.entity.Competicao;
import org.motorsportstatscore.entity.Corrida;
import org.motorsportstatscore.entity.ID_Saver;

import java.util.Date;
import java.util.List;

public class F1CompeticaoController
{
    @FXML
    private Button BotaoEditarPerfil;
    @FXML
    private Button BotaoAoVivo;
    @FXML
    private TableColumn<Corrida, Date> DataCorridas;
    @FXML
    private TableColumn<Corrida, String> ColunaCorridas;
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
        Integer id_comp = ID_Saver.getId_competicao();
        List<Corrida> Corridas = Funcoes.GetCorridasDaCompeticao(id_comp);
        atualizarTabelas(Corridas);
    }

    private void atualizarTabelas(List<Corrida> Corridas)
    {
        if (!Corridas.isEmpty())
        {
            DataCorridas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getData()));
            ColunaCorridas.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getNome()));
            //Falta implementar Coluna Vencedor Da Respetiva Corrida!
            País.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getPais()));

            TabelaFormula1.setItems(FXCollections.observableArrayList(competicoesFormula1));
            TabelaFormula1.refresh();
        }

        TabelaFormula1.setRowFactory(tv -> {
            TableRow<Corrida> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Corrida rowData = row.getItem();
                    ID_Saver.setId_corrida(rowData.getIdCorrida());
                    Recursos.SceneSwitcher.switchScene("F1Corrida.fxml",row);
                }
            });
            return row;
        });
    }
}

