package com.aviones.web.avionesweb.controllers;

import java.util.List;

import javax.validation.Valid;

import com.aviones.web.avionesweb.dto.NuevoPilotoDTO;
import com.aviones.web.avionesweb.dto.PilotoDTO;
import com.aviones.web.avionesweb.services.PilotoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vuelos")
public class PilotoController {
    private final PilotoServices service;

 
    public PilotoController(PilotoServices srv){
        this.service =srv;
    }

    @PostMapping("/{id}/pilotos")
    public ResponseEntity<PilotoDTO> create(@PathVariable("id") Long id,@Valid @RequestBody NuevoPilotoDTO pilotoDTO){
        
            PilotoDTO pilotoDTO = service.create(id,pilotoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(pilotoDTO);
        
    }

    @GetMapping("/{idVuelo}/pilotos/{id}")
    public ResponseEntity<PilotoDTO> retrive(@PathVariable("idVuelo") Long idVuelo,@PathVariable("id") Long id){
       
            PilotoDTO result = service.retrieve(idVuelo,id);
            return ResponseEntity.ok().body(result);
       
    }

    @GetMapping("/{id}/vuelos") //el verbo es diferente a create ya que va
    public ResponseEntity<List<PilotoDTO>> list(@PathVariable("id") Long id){
        
            List <PilotoDTO> pilotos  = service.list(id);
            return ResponseEntity.ok().body(pilotos);
        
    }

    @PutMapping("/{idVuelo}/pilotos/{id}")
    public ResponseEntity<PilotoDTO> update(@RequestBody PilotoDTO pilotoDTO,@PathVariable("idVuelo") Long idVuelo, @PathVariable("id") Long id){
        
            PilotoDTO result = service.update(pilotoDTO, idVuelo,id);
            return ResponseEntity.ok().body(result);
       
    }

    @DeleteMapping("/{idVuelo}/pilotos/{id}")
    public ResponseEntity<String> delete( @PathVariable("idVuelo") Long idVuelo,@PathVariable("id") Long id){
        
             service.delete(idVuelo,id);;
            return ResponseEntity.noContent().build();
        
    }


}
