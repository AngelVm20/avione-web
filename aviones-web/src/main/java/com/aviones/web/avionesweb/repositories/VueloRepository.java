package com.aviones.web.avionesweb.repositories;

import com.aviones.web.avionesweb.models.Vuelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Long>{
    
}
