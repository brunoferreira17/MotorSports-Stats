package org.motorsportstatscore.entity;

public class ID_Saver
{
    private static Integer id_competicao;

    public static Integer getId_corrida() {
        return id_corrida;
    }

    public static void setId_corrida(Integer id_corrida) {
        ID_Saver.id_corrida = id_corrida;
    }

    private static Integer id_corrida;

    public static Integer getId_competicao() {
        return id_competicao;
    }
    public static void setId_competicao(Integer id_competicao) {
        ID_Saver.id_competicao = id_competicao;
    }
}
