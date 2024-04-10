package org.motorsportstatscore.entity;

import javax.persistence.*;

@Entity
@Table(name = "tipo_utilizador")
public enum TipoUtilizador {
    ADMIN,
    UTILIZADOR,
    GESTOR
}