package org.motorsportstatscore.entity;

import org.motorsportstatscore.entity.Utilizador;
import org.motorsportstatscore.repository.UtilizadorRepository;

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
