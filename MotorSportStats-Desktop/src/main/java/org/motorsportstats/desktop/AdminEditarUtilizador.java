package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.motorsportstats.services.Funcoes;
import org.motorsportstatscore.entity.ID_Saver;
import org.motorsportstatscore.entity.Utilizador;
import org.motorsportstatscore.repository.UtilizadorRepository;

public class AdminEditarUtilizador
{
    @FXML
    private Button BotaoConfirmarEdicao;
    @FXML
    private Button BotaoCancelarEdicao;
    @FXML
    private Button BotaoApagarUtilizador;
    @FXML
    private Label LabelNomeUtilizador;
    @FXML
    private Label LabelEmailUtilizador;
    @FXML
    private Label LabelSenhaUtilizador;
    @FXML
    private Label LabelTelefoneUtilizador;
    @FXML
    private Label LabelIDUtilizador;

    private Utilizador utilizadorSelecionado;
    private String novoNome;
    private String novoEmail;
    private String novaSenha;
    private String novoTelefone;
    private String novoID;
    @FXML
    private void handleButCancelarEdicao()
    {
        Recursos.SceneSwitcher.switchScene("AdminGerirUtilizadores.fxml",BotaoCancelarEdicao);
    }

    @FXML
    private void handleButConfirmarEdicao()
    {
         if(utilizadorSelecionado != null)
        {
            utilizadorSelecionado.setNome(novoNome);
            utilizadorSelecionado.setEmail(novoEmail);
            utilizadorSelecionado.setSenha(novaSenha);
            utilizadorSelecionado.setTelefone(novoTelefone);
            utilizadorSelecionado.setId(Integer.valueOf(novoID));

            UtilizadorRepository.atualizar(utilizadorSelecionado);
        }
        Recursos.SceneSwitcher.switchScene("AdminGerirUtilizadores.fxml",BotaoConfirmarEdicao);
    }

    @FXML
    private void handleButApagarUtilizador()
    {
        try {
            Funcoes.RemoverTodosOsFavoritosDoUtilizador(utilizadorSelecionado);
            UtilizadorRepository.apagar(utilizadorSelecionado);

            Recursos.WindowManager.openWindowToWarm("MiniPaginaAviso.fxml", "Utilizador Apagado!");
            Recursos.SceneSwitcher.switchScene("AdminGerirUtilizadores.fxml",BotaoApagarUtilizador);
        }catch (Exception e)
        {
            Recursos.WindowManager.openWindowToWarm("MiniPaginaAviso.fxml", "Utilizador Nao Apagado!");
            Recursos.SceneSwitcher.switchScene("AdminGerirUtilizadores.fxml",BotaoApagarUtilizador);
        }
    }

    @FXML
    private void LabelEditarNome()
    {
        novoNome = Recursos.WindowManager.openWindowToEdit("MiniPaginaEdicao.fxml", "Novo Nome");
        if(novoNome != null)
        {
            setNovoNome(novoNome);
        }
    }

    @FXML
    private void LabelEditarEmail()
    {
        novoEmail = Recursos.WindowManager.openWindowToEdit("MiniPaginaEdicao.fxml", "Novo Email");
        if(novoEmail != null)
        {
            setNovoEmail(novoEmail);
        }
    }

    @FXML
    private void LabelEditarSenha()
    {
        novaSenha = Recursos.WindowManager.openWindowToEdit("MiniPaginaEdicao.fxml", "Novo Senha");
        if(novaSenha != null)
        {
            setNovaSenha(novaSenha);
        }
    }
    @FXML
    private void LabelEditarTelefone()
    {
        novoTelefone = Recursos.WindowManager.openWindowToEdit("MiniPaginaEdicao.fxml", "Novo Telefone");
        if(novoTelefone != null)
        {
            setNovoTelefone(novoTelefone);
        }
    }
    @FXML
    private void LabelEditarID()
    {
        novoID = (Recursos.WindowManager.openWindowToEdit("MiniPaginaEdicao.fxml", "Novo ID"));
        if(novoID != null)
        {
            setNovoID(novoID);
        }
    }

    public void setNovoNome(String novoNome) {
        this.novoNome = novoNome;
    }

    public void setNovoEmail(String novoEmail) {
        this.novoEmail = novoEmail;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public void setNovoTelefone(String novoTelefone) {
        this.novoTelefone = novoTelefone;
    }
    public void setNovoID(String novoID){
        this.novoID = novoID;
    }

    public void initialize()
    {
        utilizadorSelecionado = UtilizadorRepository.findUtilizador(ID_Saver.getId_utilizador());

        LabelNomeUtilizador.setText(utilizadorSelecionado.getNome());
        LabelEmailUtilizador.setText(utilizadorSelecionado.getEmail());
        LabelSenhaUtilizador.setText(utilizadorSelecionado.getSenha());
        LabelTelefoneUtilizador.setText(utilizadorSelecionado.getTelefone());
        LabelIDUtilizador.setText(String.valueOf((utilizadorSelecionado.getId())));

        setNovoNome(utilizadorSelecionado.getNome());
        setNovoEmail(utilizadorSelecionado.getEmail());
        setNovaSenha(utilizadorSelecionado.getSenha());
        setNovoTelefone(utilizadorSelecionado.getTelefone());
        setNovoID(String.valueOf(utilizadorSelecionado.getId()));
    }
}
