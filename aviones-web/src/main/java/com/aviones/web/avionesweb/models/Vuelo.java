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
@Table(name="TBL_VUELOS")
@Getter
@Setter
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "HORA_SALIDA")
    private String horaSalida;
    
    @Column(name = "HORA_LLEGADA")
    private String horaLlegada;
    
    @Column(name = "ORIGEN_VUELO")
    private String origenVuelo;
    
    @Column(name = "DESTINO_VUELO")
    private String destinoVuelo;
    
    @Column(name = "TIPO_VUELO")
    private String tipoVuelo;

    @OneToMany(mappedBy = "vuelo")
    private List<Asiento> asientos;
}
