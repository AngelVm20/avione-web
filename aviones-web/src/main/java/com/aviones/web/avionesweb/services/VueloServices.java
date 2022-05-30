package com.aviones.web.avionesweb.services;

import java.util.List;

import com.aviones.web.avionesweb.dto.VueloDTO;
import com.aviones.web.avionesweb.dto.NuevoVueloDTO;

public interface VueloServices {
    
    public VueloDTO create(NuevoVueloDTO vueloDTO);
    public VueloDTO retrieve(Long id) throws Exception;
    public VueloDTO update(VueloDTO vueloDTO, Long id) throws Exception;
    public void delete(Long id) throws Exception;

    public List<VueloDTO> list();
}
