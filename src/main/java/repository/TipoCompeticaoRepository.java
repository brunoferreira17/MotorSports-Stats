package repository;

import entity.TipoCompeticao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoCompeticaoRepository extends JpaRepository<TipoCompeticao, Long>, JpaSpecificationExecutor<TipoCompeticao>
{

}