package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.CorridaStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorridaStageRepository extends JpaRepository<CorridaStage, Integer> {
}