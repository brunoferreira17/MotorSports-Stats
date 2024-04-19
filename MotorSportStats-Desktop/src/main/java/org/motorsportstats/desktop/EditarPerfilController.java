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

    @FXML
    private void handleButConfirmarEdicao()
    {

    }

    @FXML
    private void LabelEditarNome()
    {
        String novoNome = abrirMiniPaginaEdicao("MiniPaginaEdicao.fxml", "Novo Nome");

    }

    @FXML
    private void LabelEditarEmail()
    {
        String novoEmail = abrirMiniPaginaEdicao("MiniPaginaEdicao.fxml", "Novo Email");
    }

    @FXML
    private void LabelEditarSenha()
    {
        String novoSenha = abrirMiniPaginaEdicao("MiniPaginaEdicao.fxml", "Novo Senha");
    }

    @FXML
    private void LabelEditarTelefone()
    {
        String novoTelefone = abrirMiniPaginaEdicao("MiniPaginaEdicao.fxml", "Novo Telefone");
    }

    private String abrirMiniPaginaEdicao(String fxmlFile, String labelText) {
        MiniPaginaEdicaoController controller = Recursos.WindowManager.openWindowToEdit(fxmlFile, labelText);
        return (controller != null) ? controller.getNovoOpcao(): null;
    }

    public void initialize()
    {
        Utilizador utilizadorLogado = AuthService.getUtilizadorLogado();

        LabelNomeUtilizador.setText(utilizadorLogado.getNome());
        LabelEmailUtilizador.setText(utilizadorLogado.getEmail());
        LabelSenhaUtilizador.setText(utilizadorLogado.getSenha());
        LabelTelefoneUtilizador.setText(utilizadorLogado.getTelefone());
    }
}
