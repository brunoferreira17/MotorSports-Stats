package org.motorsportstats.desktop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private void handleButCancelarRegistro()
    {
        Recursos.SceneSwitcher.switchScene("paginainicial.fxml",ButCancelarRegistro);
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
}
