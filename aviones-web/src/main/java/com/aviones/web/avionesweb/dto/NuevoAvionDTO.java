package com.aviones.web.avionesweb.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NuevoAvionDTO {
    private String modelo;
    private float tamano;
    private String estado;
    private String aereolinea;
    private String compartimientos;
}
