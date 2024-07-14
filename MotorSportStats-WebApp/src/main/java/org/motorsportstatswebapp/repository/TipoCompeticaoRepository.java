package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.TipoCompeticao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCompeticaoRepository extends JpaRepository<TipoCompeticao, Integer> {
}