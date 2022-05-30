package com.aviones.web.avionesweb.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PilotoDTO {
    
    private Long id;
    private String nombre;
    private String licencia;
}
