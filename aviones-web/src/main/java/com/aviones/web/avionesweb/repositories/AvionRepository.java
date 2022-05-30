package com.aviones.web.avionesweb.repositories;



import com.aviones.web.avionesweb.models.Avion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AvionRepository extends JpaRepository<Avion,Long> {
    //public List<Avion>findByTitle(String criteria);
}
