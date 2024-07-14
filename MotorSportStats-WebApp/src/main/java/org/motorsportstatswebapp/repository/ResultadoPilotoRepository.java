package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.ResultadoPiloto;
import org.motorsportstatswebapp.entity.ResultadoPilotoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoPilotoRepository extends JpaRepository<ResultadoPiloto, ResultadoPilotoId> {
}