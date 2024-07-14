package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.Competicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Integer> {
}