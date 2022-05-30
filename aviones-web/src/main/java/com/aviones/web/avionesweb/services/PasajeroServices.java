package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.PasajeroDTO;
import com.aviones.web.avionesweb.dto.NuevoPasajeroDTO;

public interface PasajeroServices {
    
    public PasajeroDTO create(NuevoPasajeroDTO pasajeroDTO);
    public PasajeroDTO retrieve(Long id) throws Exception;
    public PasajeroDTO update(PasajeroDTO pasajeroDTO, Long id) throws Exception;
    public void delete(Long id) throws Exception;

    public List<PasajeroDTO> list();
}
