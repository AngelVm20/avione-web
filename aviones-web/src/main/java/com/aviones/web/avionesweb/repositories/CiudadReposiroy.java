package com.aviones.web.avionesweb.repositories;



import com.aviones.web.avionesweb.models.Ciudad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CiudadReposiroy extends JpaRepository<Ciudad,Long>{
   // public List<Ciudad>findByTitle(String criteria);
}
