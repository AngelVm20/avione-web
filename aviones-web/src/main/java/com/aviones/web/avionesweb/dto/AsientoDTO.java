package com.aviones.web.avionesweb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AsientoDTO {
    
    private Long id;
    private String numeroAsiento;
    private String estadoAsiento;
}
