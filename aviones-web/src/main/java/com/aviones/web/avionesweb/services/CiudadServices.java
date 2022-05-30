package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.CiudadDTO;
import com.aviones.web.avionesweb.dto.NuevoCiudad;

public interface CiudadServices {
    
    public CiudadDTO create(NuevoCiudad ciudadDTO);
    public CiudadDTO retrieve(Long id) throws Exception;
    public CiudadDTO update(CiudadDTO ciudadDTO, Long id) throws Exception;
    public void delete(Long id) throws Exception;

    public List<CiudadDTO> list();
}
