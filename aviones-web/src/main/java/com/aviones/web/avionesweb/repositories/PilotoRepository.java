package com.aviones.web.avionesweb.repositories;

import com.aviones.web.avionesweb.models.Piloto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PilotoRepository extends JpaRepository<Piloto,Long>{
    
}
