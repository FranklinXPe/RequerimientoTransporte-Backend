package com.transporte.pe.RequerimientoTransporte.service;

import com.transporte.pe.RequerimientoTransporte.dao.RequerimientoRepository;
import com.transporte.pe.RequerimientoTransporte.domain.Requerimiento;
import com.transporte.pe.RequerimientoTransporte.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RequerimientoService {
    @Autowired
    private RequerimientoRepository requerimientoRepository;

    public List<Requerimiento> getAllRequerimiento(){
       return (List<Requerimiento>) requerimientoRepository.findAll();
    }
    public List<Requerimiento> getAllRequerimientoOrderByIdRequerimientoDesc(){
        return (List<Requerimiento>) requerimientoRepository.findByOrderByIdRequerimientoDesc();
    }

    public Requerimiento getRequerimiento(long id){
        return requerimientoRepository.findById(id).get();
    }

    public Requerimiento createRequerimiento(Requerimiento requerimiento){
        return  this.requerimientoRepository.save(requerimiento);
    }

    public void updateRequerimiento(Requerimiento requerimiento){
        requerimientoRepository.save(requerimiento);
    }
    public void deleteRequerimiento(Requerimiento requerimiento){
        requerimientoRepository.delete(requerimiento);
    }


    public List<Requerimiento>  getAllRequerimientosByUsuario(Usuario usuario){
        return requerimientoRepository.findByUsuario(usuario);
    }

    public List<Requerimiento>  getAllRequerimientosByAprobado(){
        return requerimientoRepository.findByAprobado("APROBADO");
    }

}
