package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.AsientoDTO;
import com.aviones.web.avionesweb.dto.NuevoAsientoDTO;

public interface AsientoServices {
    
    public AsientoDTO create(Long idVuelo,NuevoAsientoDTO asientoDTO);
    public AsientoDTO retrieve(Long idVuelo,Long id);
    public AsientoDTO update(AsientoDTO asientoDTO, Long idVuelo, Long id);
    public void delete(Long idVuelo,Long id);

    public List<AsientoDTO> list(Long idVuelo);
}
