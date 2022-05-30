package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.PilotoDTO;
import com.aviones.web.avionesweb.dto.NuevoPilotoDTO;

public interface PilotoServices {
    
    public PilotoDTO create(NuevoPilotoDTO pilotoDTO);
    public PilotoDTO retrieve(Long id) throws Exception;
    public PilotoDTO update(PilotoDTO pilotoDTO, Long id) throws Exception;
    public void delete(Long id) throws Exception;

    public List<PilotoDTO> list();
}
