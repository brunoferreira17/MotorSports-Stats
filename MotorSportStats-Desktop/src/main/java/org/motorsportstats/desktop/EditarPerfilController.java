    package org.motorsportstats.desktop;

    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import org.motorsportstatscore.entity.AuthService;
    import org.motorsportstatscore.entity.Utilizador;
    import org.motorsportstatscore.repository.UtilizadorRepository;

    public class EditarPerfilController
    {
        @FXML
        private Button BotaoConfirmarEdicao;
        @FXML
        private Button BotaoCancelarEdicao;
        @FXML
        private Button BotaoLogout;
        @FXML
        private Button BotaoNotificacao;
        @FXML
        private Label LabelNomeUtilizador;
        @FXML
        private Label LabelEmailUtilizador;
        @FXML
        private Label LabelSenhaUtilizador;
        @FXML
        private Label LabelTelefoneUtilizador;

        private Utilizador utilizadorLogado;
        private String novoNome;
        private String novoEmail;
        private String novaSenha;
        private String novoTelefone;
        @FXML
        private void handleButCancelarEdicao()
        {
            Recursos.SceneSwitcher.switchScene("inicio_aovivo.fxml",BotaoCancelarEdicao);
        }

        @FXML
        private void handleButConfirmarEdicao()
        {
            if(utilizadorLogado != null)
            {
                utilizadorLogado.setNome(novoNome);
                utilizadorLogado.setEmail(novoEmail);
                utilizadorLogado.setSenha(novaSenha);
                utilizadorLogado.setTelefone(novoTelefone);

                UtilizadorRepository.atualizar(utilizadorLogado);
            }
            Recursos.SceneSwitcher.switchScene("inicio_aovivo.fxml",BotaoConfirmarEdicao);
        }

        @FXML
        private void handleButNotificacao()
        {

        }

        @FXML
        private void handleButLogout()
        {
            AuthService.setUtilizadorLogado(null);
            Recursos.SceneSwitcher.switchScene("paginainicial.fxml",BotaoLogout);
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

        public void initialize()
        {
            utilizadorLogado = AuthService.getUtilizadorLogado();

            LabelNomeUtilizador.setText(utilizadorLogado.getNome());
            LabelEmailUtilizador.setText(utilizadorLogado.getEmail());
            LabelSenhaUtilizador.setText(utilizadorLogado.getSenha());
            LabelTelefoneUtilizador.setText(utilizadorLogado.getTelefone());

            setNovoNome(utilizadorLogado.getNome());
            setNovoEmail(utilizadorLogado.getEmail());
            setNovaSenha(utilizadorLogado.getSenha());
            setNovoTelefone(utilizadorLogado.getTelefone());
        }
    }
