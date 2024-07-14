package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.Equipa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipaRepository extends JpaRepository<Equipa, Integer> {
}