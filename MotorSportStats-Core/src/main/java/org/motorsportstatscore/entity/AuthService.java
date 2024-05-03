package org.motorsportstatscore.entity;

public class AuthService {

    private static Utilizador utilizadorLogado;

    public static Utilizador getUtilizadorLogado()
    {
        return utilizadorLogado;
    }

    public static void setUtilizadorLogado(Utilizador utilizador)
    {
        utilizadorLogado = utilizador;
    }

}
