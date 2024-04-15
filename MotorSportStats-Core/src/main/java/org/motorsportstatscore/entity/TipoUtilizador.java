package org.motorsportstatscore.entity;

import jakarta.persistence.*;

@Table(name = "tipo_utilizador")
public enum TipoUtilizador {
    admin,
    utilizador,
    gestor
}