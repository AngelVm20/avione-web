package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.CiudadDTO;
import com.aviones.web.avionesweb.dto.NuevoCiudad;

public interface CiudadServices {
    
    public CiudadDTO create(NuevoCiudad ciudadDTO);
    public CiudadDTO retrieve(Long id);
    public CiudadDTO update(CiudadDTO ciudadDTO, Long id);
    public void delete(Long id);

    public List<CiudadDTO> list();
}
