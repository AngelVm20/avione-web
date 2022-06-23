package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.AvionDTO;
import com.aviones.web.avionesweb.dto.NuevoAvionDTO;

public interface AvionServices {

    public AvionDTO create(NuevoAvionDTO avionDTO);
    public AvionDTO retrieve(Long id);
    public AvionDTO update(AvionDTO avionDTO, Long id);
    public void delete(Long id);

    public List<AvionDTO> list();
}
