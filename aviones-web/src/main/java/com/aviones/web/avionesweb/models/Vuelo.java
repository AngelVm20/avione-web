package com.aviones.web.avionesweb.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.ManyToOne;
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

    @OneToMany(mappedBy = "vuelo")
    private List<Piloto> pilotos;

    @OneToMany(mappedBy = "vuelo")
    private List<Ciudad> ciudades;

    @Column(name = "CREATED_DATE")    
    private Calendar createdDate;
    @Column(name = "CREATED_BY")    
    private String createdBy;  

    @Column(name = "UPDATED_DATE")    
    private Calendar updatedDate;
    @Column(name = "UPDATED_BY")    
    private String updatedBy;  

    @PrePersist
    public void prePersist(){
        createdDate = Calendar.getInstance();
        createdBy = "user1";
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = Calendar.getInstance();
        updatedBy = "user2";
    }
    
    @ManyToOne
    @JoinColumn(name = "AVION_ID",nullable = false)
    private Avion avion;//propiedad

}

