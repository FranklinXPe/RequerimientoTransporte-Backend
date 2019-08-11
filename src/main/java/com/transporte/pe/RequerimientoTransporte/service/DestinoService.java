package com.transporte.pe.RequerimientoTransporte.service;

import com.transporte.pe.RequerimientoTransporte.dao.DestinoRepository;
import com.transporte.pe.RequerimientoTransporte.domain.Destino;
import com.transporte.pe.RequerimientoTransporte.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DestinoService {
    @Autowired
    private DestinoRepository destinoRepository;



    public List<Destino> getAllDestinos(){
        return (List<Destino>) destinoRepository.findAll();

    }

    public Destino getDestino(long id){
        return destinoRepository.findById(id).get();
    }

    public Destino createDestino(Destino destino){
        return  this.destinoRepository.save(destino);
    }

    public void updateDestino(Destino destino){
        destinoRepository.save(destino);
    }
}
