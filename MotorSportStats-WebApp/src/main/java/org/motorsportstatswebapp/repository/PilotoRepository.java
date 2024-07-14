package org.motorsportstatswebapp.repository;

import org.motorsportstatswebapp.entity.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Integer>
{
  Optional<Piloto> findById(Integer id);
}