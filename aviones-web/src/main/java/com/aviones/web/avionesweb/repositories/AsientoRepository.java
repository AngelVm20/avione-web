package com.aviones.web.avionesweb.repositories;


import com.aviones.web.avionesweb.models.Asiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento,Long>{
    //public List<Asiento>findByTitle(String criteria);
}
