package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.CorridaVolta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorridaVoltaRepository extends JpaRepository<CorridaVolta, Integer>
{

    List<CorridaVolta> findByIdCorrida_Id(Integer corridaId);
}