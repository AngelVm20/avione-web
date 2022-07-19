package com.aviones.web.avionesweb.repositories;


import com.aviones.web.avionesweb.models.Avion;
import com.aviones.web.avionesweb.models.Vuelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo,Long>{
    public List<Vuelo>findByTitle(Avion avion);
}
