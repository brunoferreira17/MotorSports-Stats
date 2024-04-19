package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.motorsportstatscore.entity.AuthService;
import org.motorsportstatscore.entity.Utilizador;
import org.motorsportstatscore.repository.UtilizadorRepository;


public class LoginController
{
    @FXML
    private Button ButConfirmarLogin;
    @FXML
    private Button ButCancelarLogin;
    @FXML
    private TextField email_usuario;
    @FXML
    private PasswordField  password_usuario;

    @FXML
    private void handleButConfirmarLogin()
    {
        Utilizador utilizadorLogado = UtilizadorRepository.VerificarAutenticacao(getemail_usuario(),getpassword_usuario());

        if(utilizadorLogado != null)
        {
            AuthService.setUtilizadorLogado(utilizadorLogado);
            Recursos.SceneSwitcher.switchScene("inicio_aovivo.fxml",ButConfirmarLogin);
        }

    }

    @FXML
    private void handleButCancelarLogin()
    {
       Recursos.SceneSwitcher.switchScene("paginainicial.fxml",ButCancelarLogin);
    }
    @FXML
    public String getemail_usuario()
    {
        return email_usuario.getText();
    }
    @FXML
    public String getpassword_usuario()
    {
        return password_usuario.getText();
    }

}
