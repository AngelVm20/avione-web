package com.aviones.web.avionesweb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_ASIENTOS")
@Getter
@Setter
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NUMERO_ASIENTO")
    private String numeroAsiento;

    @Column(name = "ESTADO_ASIENTO")
    private String estadoAsiento;

    @ManyToOne
    @JoinColumn(name = "VUELO_ID",nullable = false)
    private Vuelo vuelo;
    
}
