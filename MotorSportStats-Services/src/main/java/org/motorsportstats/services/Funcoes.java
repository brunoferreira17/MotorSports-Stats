package org.motorsportstats.services;


import org.motorsportstatscore.entity.Corrida;
import org.motorsportstatscore.entity.TipoCompeticao;
import org.motorsportstatscore.entity.Competicao;
import org.motorsportstatscore.repository.DbConnection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcoes
{
    public static List<Corrida> GetCorridasDoDia()
    {
        LocalDate DataHoje = LocalDate.now();

        List<Corrida> CorridaDoDia = DbConnection.getEntityManager()
                .createQuery("SELECT u FROM Corrida u WHERE u.data = :data", Corrida.class)
                .setParameter("data", DataHoje)
                .getResultList();

        /*WHERE u.data = :data*/
        if(!CorridaDoDia.isEmpty())
        {
            return  CorridaDoDia;
        }else
        {
            return new ArrayList<>();
        }
    }

    public static List<Competicao> GetCompeticoesDoDia()
    {
        LocalDate DataHoje = LocalDate.now();

        String jpql = "SELECT DISTINCT c " +
                "FROM Competicao c " +
                "JOIN c.corridas co " +
                "WHERE co.data = :data";

        List<Competicao> CompeticoesDoDia = DbConnection.getEntityManager()
                .createQuery(jpql, Competicao.class)
                .setParameter("data", DataHoje)
                .getResultList();

        /*WHERE u.data = :data*/
        if(!CompeticoesDoDia.isEmpty())
        {
            return  CompeticoesDoDia;
        }else
        {
            return new ArrayList<>();
        }
    }

    public static List<TipoCompeticao> GetTipoDeCompeticoesDoDia()
    {
        LocalDate DataHoje = LocalDate.now();

        String jpql = "SELECT DISTINCT tc " +
                "FROM TipoCompeticao tc " +
                "JOIN tc.competicaos c " +
                "JOIN c.corridas co " +
                "WHERE co.data = :data";

        List<TipoCompeticao> TipoCompeticaoDoDia = DbConnection.getEntityManager()
                .createQuery(jpql, TipoCompeticao.class)
                .setParameter("data", DataHoje)
                .getResultList();

        /*SELECT tc FROM TipoCompeticao tc JOIN Competicao c ON tc.id = c.idTipoCompeticao JOIN Corrida co ON c.idTipoCompeticao = co.idCompeticao WHERE co.data = :data*/

        if(!TipoCompeticaoDoDia.isEmpty())
        {
            return  TipoCompeticaoDoDia;
        }else
        {
            return new ArrayList<>();
        }
    }
}
