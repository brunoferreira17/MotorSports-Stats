package org.motorsportstatswebapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tipo_competicao")
public class TipoCompeticao {
    @Id
    @ColumnDefault("nextval('tipo_competicao_id_tipo_competicao_seq'::regclass)")
    @Column(name = "id_tipo_competicao", nullable = false)
    private Integer id;

    @Column(name = "tipo_competicao", nullable = false, length = 50)
    private String tipoCompeticao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCompeticao() {
        return tipoCompeticao;
    }

    public void setTipoCompeticao(String tipoCompeticao) {
        this.tipoCompeticao = tipoCompeticao;
    }

}