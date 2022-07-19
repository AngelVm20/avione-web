package com.aviones.web.avionesweb.repositories;



import com.aviones.web.avionesweb.models.Piloto;
import com.aviones.web.avionesweb.models.Vuelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotoRepository extends JpaRepository<Piloto,Long>{
    public List<Piloto>findByTitle(Vuelo vuelo);
}
