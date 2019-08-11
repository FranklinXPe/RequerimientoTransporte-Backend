package com.transporte.pe.RequerimientoTransporte.service;

import com.transporte.pe.RequerimientoTransporte.dao.TrabajadorRepository;
import com.transporte.pe.RequerimientoTransporte.domain.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> getAllTrabajadores(){
        return (List<Trabajador>) trabajadorRepository.findAll();
    }

    public Trabajador getTrabajador(long id){
        return trabajadorRepository.findById(id).get();
    }



    public Trabajador createTrabajador(Trabajador trabajador){
        return  this.trabajadorRepository.save(trabajador);
    }

    public void updateTrabajador(Trabajador trabajador){
        trabajadorRepository.save(trabajador);
    }
}
