package com.aviones.web.avionesweb.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_PASAJEROS")
@Getter
@Setter
public class Pasajero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CEDULA")
    private String cedula;

    @OneToOne(mappedBy = "pasajero")//anotacion 
    private Asiento asiento;//propiedad
}
