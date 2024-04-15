package org.motorsportstats.desktop;

import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import org.motorsportstatscore.entity.TipoUtilizador;
import org.motorsportstatscore.entity.Utilizador;
import org.motorsportstatscore.repository.UtilizadorRepository;

import java.time.LocalDate;

public class RegistroController
{
    @FXML
    private Button ButCancelarRegistro;
    @FXML
    private TextField nome_usuario;
    @FXML
    private PasswordField password_usuario;
    @FXML
    private TextField email_usuario;
    @FXML
    private TextField contacto_usuario;
    @FXML
    private DatePicker datanascimento_usuario;
    @FXML
    private Label avisolabel;

    @FXML
    public void initialize()
    {
        // Esconde a label de aviso ao iniciar a página
        avisolabel.setVisible(false);
    }

    @FXML
    public String getnome_usuario()
    {
        return nome_usuario.getText();
    }

    @FXML
    public String getpassword_usuario()
    {
        return password_usuario.getText();
    }

    @FXML
    public String getemail_usuario()
    {
        return email_usuario.getText();
    }

    @FXML
    public String getcontacto_usuario()
    {
        return contacto_usuario.getText();
    }

    @FXML
    public LocalDate getdatanascimento_usuario()
    {
        return datanascimento_usuario.getValue();
    }
    
    @FXML
    private void handleButCancelarRegistro()
    {
        Recursos.SceneSwitcher.switchScene("paginainicial.fxml",ButCancelarRegistro);
    }

    @FXML
    private void handleButRegistrarRegistro()
    {

        Utilizador utilizador = new Utilizador();
        utilizador.setNome(getnome_usuario());
        utilizador.setEmail(getemail_usuario());
        utilizador.setSenha(getpassword_usuario());
        utilizador.setDataNascimento(getdatanascimento_usuario());
        utilizador.setTelefone(getcontacto_usuario());
        utilizador.setTipo(TipoUtilizador.utilizador);
        UtilizadorRepository.criar(utilizador);

        try {
            UtilizadorRepository.criar(utilizador);

            mostrarAviso("Utilizador Registrado com Sucesso");

            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), this::esconderAvisoEMudarPagina));
            timeline.play();
        } catch (Exception e) {
            mostrarAviso("Erro ao registrar usuário. Por favor, tente novamente mais tarde.");
        }
    }

    private void mostrarAviso(String mensagem) {
        avisolabel.setText(mensagem);
        avisolabel.setVisible(true);
    }

    private void esconderAvisoEMudarPagina(ActionEvent event) {
        avisolabel.setVisible(false);
        Recursos.SceneSwitcher.switchScene("paginainicial.fxml", ButCancelarRegistro);
    }
}
