package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.EquipaCompeticao;
import org.motorsportstatswebapp.entity.EquipaCompeticaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipaCompeticaoRepository extends JpaRepository<EquipaCompeticao, EquipaCompeticaoId> {
}