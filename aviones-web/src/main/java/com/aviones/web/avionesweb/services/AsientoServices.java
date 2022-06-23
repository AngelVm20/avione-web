package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.AsientoDTO;
import com.aviones.web.avionesweb.dto.NuevoAsientoDTO;

public interface AsientoServices {
    
    public AsientoDTO create(NuevoAsientoDTO asientoDTO);
    public AsientoDTO retrieve(Long id);
    public AsientoDTO update(AsientoDTO asientoDTO, Long id);
    public void delete(Long id);

    public List<AsientoDTO> list();
}
