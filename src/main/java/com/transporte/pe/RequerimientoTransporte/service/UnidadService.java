package com.transporte.pe.RequerimientoTransporte.service;

import com.transporte.pe.RequerimientoTransporte.dao.UnidadRepository;
import com.transporte.pe.RequerimientoTransporte.domain.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadService {

    @Autowired
    private UnidadRepository unidadRepository;

    public List<Unidad> getAllUnidad(){
        return (List<Unidad>) unidadRepository.findAll();
    }

    public Unidad getUnidad(long id){
        return unidadRepository.findById(id).get();
    }

    public Unidad createUnidad(Unidad unidad){
        return unidadRepository.save(unidad);
    }

    public void updateUnidad(Unidad unidad){
        unidadRepository.save(unidad);
    }
}
