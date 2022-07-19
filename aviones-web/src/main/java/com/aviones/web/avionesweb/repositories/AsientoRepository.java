package com.aviones.web.avionesweb.repositories;


import com.aviones.web.avionesweb.models.Asiento;
import com.aviones.web.avionesweb.models.Vuelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AsientoRepository extends JpaRepository<Asiento,Long>{
    public List<Asiento>findByTitle(Vuelo vuelo);
}
