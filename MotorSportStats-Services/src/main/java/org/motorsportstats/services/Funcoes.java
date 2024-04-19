package org.motorsportstats.services;


import org.motorsportstatscore.entity.*;
import org.motorsportstatscore.repository.DbConnection;
import org.motorsportstatscore.repository.FavoritoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Funcoes
{
    public static List<Corrida> GetCorridasDoDia(LocalDate DataHoje)
    {

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

    public static List<Competicao> GetCompeticoesDoDia(LocalDate DataHoje)
    {

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

    public static List<TipoCompeticao> GetTipoDeCompeticoesDoDia(LocalDate DataHoje)
    {

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

    public static void AdicionarCompeticaoFavorito(Competicao competicaofavorita, Utilizador utilizador)
    {
        boolean competicaoJafavorita = utilizador.getFavoritos().stream()
                .anyMatch(favorito -> favorito.getCompeticaos().contains(competicaofavorita));

        if(competicaoJafavorita)
        {
         return;
        }

        Favorito favorito = new Favorito();
        favorito.setIdUtilizador(utilizador);
        favorito.getCompeticaos().add(competicaofavorita);

        utilizador.getFavoritos().add(favorito);

        FavoritoRepository.criar(favorito);

    }
    public static void RemoverCompeticaoFavorito(Competicao competicaoFavorita, Utilizador utilizador)
    {
        Favorito favorito = utilizador.getFavoritos().stream()
                .filter(f -> f.getCompeticaos().contains(competicaoFavorita))
                .findFirst()
                .orElse(null);

        if (favorito != null) {
            favorito.getCompeticaos().remove(competicaoFavorita);
            if (favorito.getCompeticaos().isEmpty()) {
                utilizador.getFavoritos().remove(favorito);
                FavoritoRepository.apagar(favorito);
            }
        }
    }

    /*public static List<TipoCompeticao> GetTipoCompeticoesFavoritasDoUtilizador(Utilizador utilizador) {
        return utilizador.getFavoritos().stream()
                .flatMap(favorito -> favorito.get().stream())
                .distinct()
                .collect(Collectors.toList());
    }*/

    public static List<Competicao> GetCompeticoesFavoritasDoUtilizador(Utilizador utilizador) {
        return utilizador.getFavoritos().stream()
                .flatMap(favorito -> favorito.getCompeticaos().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Equipa> GetEquipasFavoritasDoUtilizador(Utilizador utilizador) {
        return utilizador.getFavoritos().stream()
                .flatMap(favorito -> favorito.getEquipas().stream())
                .distinct()
                .collect(Collectors.toList());
    }
    public static List<Piloto> GetPilotosFavoritosDoUtilizador(Utilizador utilizador) {
        return utilizador.getFavoritos().stream()
                .flatMap(favorito -> favorito.getPilotos().stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
