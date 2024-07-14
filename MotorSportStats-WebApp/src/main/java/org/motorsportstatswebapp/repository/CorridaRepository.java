package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Integer> {
}