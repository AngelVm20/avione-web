package com.aviones.web.avionesweb.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NuevoVueloDTO {
    
    private String horaSalida;
    private String horaLlegada;
    private String origenVuelo;
    private String destinoVuelo;
    private String tipoVuelo;
}
