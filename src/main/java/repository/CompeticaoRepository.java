package repository;

import entity.Competicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompeticaoRepository extends JpaRepository<Competicao, Long>, JpaSpecificationExecutor<Competicao> {

}