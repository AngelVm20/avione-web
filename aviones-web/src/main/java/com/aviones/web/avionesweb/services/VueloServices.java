package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.VueloDTO;
import com.aviones.web.avionesweb.dto.NuevoVueloDTO;

public interface VueloServices {
    
    public VueloDTO create(NuevoVueloDTO vueloDTO);
    public VueloDTO retrieve(Long id);
    public VueloDTO update(VueloDTO vueloDTO, Long id);
    public void delete(Long id);

    public List<VueloDTO> list();
}
