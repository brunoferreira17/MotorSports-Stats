package org.motorsportstatscore.entity;

import org.motorsportstatscore.entity.Utilizador;
import org.motorsportstatscore.repository.UtilizadorRepository;

public class AuthService {

    private static Utilizador utilizadorLogado;
    private static Integer id_competicao;

    public static Integer getId_competicao() {
        return id_competicao;
    }

    public static void setId_competicao(Integer id_competicao) {
        AuthService.id_competicao = id_competicao;
    }

    public static Utilizador getUtilizadorLogado()
    {
        return utilizadorLogado;
    }

    public static void setUtilizadorLogado(Utilizador utilizador)
    {
        utilizadorLogado = utilizador;
    }

}
