package com.aviones.web.avionesweb.repositories;



import com.aviones.web.avionesweb.models.Pasajero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero,Long>{
    //public List<Pasajero>findByTitle(String criteria);
}
