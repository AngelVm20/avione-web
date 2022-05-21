package com.aviones.web.avionesweb.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_AVION")
@Getter
@Setter
public class Avion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "TAMANO")
    private float tamano;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "AEREOLINEA")
    private String aereolinea;

    @Column(name = "COMPARTIMIENTOS")
    private String compartimientos;

    @OneToMany(mappedBy = "avion")
    private List<Vuelo> vuelos;
}
