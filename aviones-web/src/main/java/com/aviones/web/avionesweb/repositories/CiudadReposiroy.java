package com.aviones.web.avionesweb.repositories;



import com.aviones.web.avionesweb.models.Ciudad;
import com.aviones.web.avionesweb.models.Vuelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadReposiroy extends JpaRepository<Ciudad,Long>{
   public List<Ciudad>findByTitle(Vuelo vuelo);
}
