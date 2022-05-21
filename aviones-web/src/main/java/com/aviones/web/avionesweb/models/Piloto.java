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
@Table(name="TBL_PILOTOS")
@Getter
@Setter
public class Piloto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "LICENCIA")
    private String licencia;

    @ManyToOne
    @JoinColumn(name = "VUELO_ID",nullable = false)
    private Vuelo vuelo;//propiedad
}
