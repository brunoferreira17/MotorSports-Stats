package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.motorsportstatscore.entity.AuthService;
import org.motorsportstatscore.entity.Utilizador;

public class EditarPerfilController
{
    @FXML
    private Button BotaoConfirmarEdicao;
    @FXML
    private Button BotaoCancelarEdicao;
    @FXML
    private Label BotaoEditarNome;
    @FXML
    private Label BotaoEditarEmail;
    @FXML
    private Label BotaoEditarSenha;
    @FXML
    private Label BotaoEditarTelefone;
    @FXML
    private Label LabelNomeUtilizador;
    @FXML
    private Label LabelEmailUtilizador;
    @FXML
    private Label LabelSenhaUtilizador;
    @FXML
    private Label LabelTelefoneUtilizador;
    @FXML
    private void handleButCancelarEdicao()
    {
        Recursos.SceneSwitcher.switchScene("inicio_aovivo.fxml",BotaoCancelarEdicao);
    }

    private void initialize()
    {
        Utilizador utilizadorLogado = AuthService.getUtilizadorLogado();

        LabelNomeUtilizador.setText(utilizadorLogado.getNome());
        LabelEmailUtilizador.setText(utilizadorLogado.getEmail());
        LabelSenhaUtilizador.setText(utilizadorLogado.getSenha());
        LabelTelefoneUtilizador.setText(utilizadorLogado.getTelefone());

    }
}
