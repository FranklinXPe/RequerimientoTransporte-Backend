package com.transporte.pe.RequerimientoTransporte.service;

import com.transporte.pe.RequerimientoTransporte.dao.TipoRepository;
import com.transporte.pe.RequerimientoTransporte.domain.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;


    public List<Tipo> getAllTipo(){
        return (List<Tipo>) tipoRepository.findAll();
    }

    public Tipo getTipo(long id){
        return tipoRepository.findById(id).get();
    }


    public Tipo createTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }

    public void udpateTipo(Tipo tipo){
         tipoRepository.save(tipo);
    }

}
