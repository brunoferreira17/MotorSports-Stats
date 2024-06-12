package org.motorsportstatscore.repository;

import org.motorsportstatscore.entity.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PilotoRepository extends JpaRepository<Piloto, Long>, JpaSpecificationExecutor<Piloto> {
    void criar(Piloto piloto); // Manter o nome do método como "criar"

    void apagar(Piloto piloto); // Manter o nome do método como "apagar"

    void atualizar(Piloto piloto); // Manter o nome do método como "atualizar"

    Piloto findPiloto(int id); // Manter o nome do método como "findPiloto"

    List<Piloto> listar(); // Manter o nome do método como "listar"
}
