package org.motorsportstats.desktop;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.*;

import java.time.LocalDate;
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
    private TableColumn<Competicao, String> Vencedores;

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
        Utilizador utilizadorLogado = AuthService.getUtilizadorLogado();

        //List<TipoCompeticao> tipoCompeticoesFavoritas = Funcoes --- Por Fazer a Funçao

        List<Competicao> competicoesFormula1 = Funcoes.GetCompeticoesFormula1();
        atualizarTabelas(utilizadorLogado,competicoesFormula1);
    }

    private void atualizarTabelas(Utilizador utilizadorLogado,List<Competicao> competicoesFormula1)
    {
        if (!competicoesFormula1.isEmpty())
        {
            DataCorridas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDataInicio()));
            Competicoes.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getNome()));
            Vencedores.setCellValueFactory(cellData ->  new SimpleStringProperty(cellData.getValue().getPais()));
        }
    }

}
