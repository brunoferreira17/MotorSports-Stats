package org.motorsportstatscore.entity;

public class ID_Saver
{
    private static Integer id_competicao;
    private static Integer id_corrida;
    private static Integer id_utilizador;

    public static Integer getId_utilizador() {
        return id_utilizador;
    }

    public static void setId_utilizador(Integer id_utilizador) {
        ID_Saver.id_utilizador = id_utilizador;
    }

    public static Integer getId_corrida() {
        return id_corrida;
    }

    public static void setId_corrida(Integer id_corrida) {
        ID_Saver.id_corrida = id_corrida;
    }

    public static Integer getId_competicao() {
        return id_competicao;
    }
    public static void setId_competicao(Integer id_competicao) {
        ID_Saver.id_competicao = id_competicao;
    }
}
