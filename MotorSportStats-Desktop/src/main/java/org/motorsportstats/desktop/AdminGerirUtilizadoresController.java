package org.motorsportstats.desktop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.motorsportstatscore.entity.ID_Saver;
import org.motorsportstatscore.entity.Utilizador;
import org.motorsportstatscore.repository.UtilizadorRepository;

import java.time.LocalDate;
import java.util.List;

public class AdminGerirUtilizadoresController
{
    @FXML
    private Button BotaoEditarPerfil;
    @FXML
    private TableColumn<Utilizador , Integer> IDUtilizadores;
    @FXML
    private TableColumn<Utilizador, String> NomeUtilizadores;
    @FXML
    private TableColumn<Utilizador, LocalDate> DataNascimento;
    @FXML
    private TableColumn<Utilizador, String> Contacto;
    @FXML
    private TableColumn<Utilizador, org.motorsportstatscore.entity.TipoUtilizador> TipoUtilizador;
    @FXML
    private TableView TabelaUtilizadores;
    @FXML
    private void handleButEditarPerfil()
    {
        Recursos.SceneSwitcher.switchScene("editarperfil.fxml",BotaoEditarPerfil);
    }

    @FXML
    public void initialize()
    {
        carregarDados();
    }

    private void carregarDados()
    {
        List<Utilizador> UtilizadoresNoSistema = UtilizadorRepository.listar();

        atualizarTabelas(UtilizadoresNoSistema);
    }

    private void atualizarTabelas(List<Utilizador> utilizadores)
    {
        if (!utilizadores.isEmpty())
        {
            IDUtilizadores.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
            NomeUtilizadores.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getNome()));
            TipoUtilizador.setCellValueFactory(cellData ->  new SimpleObjectProperty<>(cellData.getValue().getTipo()));
            DataNascimento.setCellValueFactory(cellData ->  new SimpleObjectProperty<>(cellData.getValue().getDataNascimento()));
            Contacto.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getTelefone()));

            TabelaUtilizadores.setItems(FXCollections.observableArrayList(utilizadores));
            TabelaUtilizadores.refresh();
        }

        TabelaUtilizadores.setRowFactory(tv -> {
            TableRow<Utilizador> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Utilizador rowData = row.getItem();
                    ID_Saver.setId_utilizador(rowData.getId());
                    Recursos.SceneSwitcher.switchScene("AdminEditarUtilizador.fxml",row);
                }
            });
            return row;
        });
    }
}
