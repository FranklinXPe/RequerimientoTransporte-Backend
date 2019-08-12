package com.transporte.pe.RequerimientoTransporte.service;

import com.transporte.pe.RequerimientoTransporte.dao.RequerimientoRepository;
import com.transporte.pe.RequerimientoTransporte.domain.Requerimiento;
import com.transporte.pe.RequerimientoTransporte.domain.Usuario;
import com.transporte.pe.RequerimientoTransporte.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RequerimientoService {
    @Autowired
    private RequerimientoRepository requerimientoRepository;

    public List<Requerimiento> getAllRequerimiento(){
       return (List<Requerimiento>) requerimientoRepository.findAll();
    }

    public List<Requerimiento> getAllRequerimientoEntreFechasSolicitud(String fechaInicio,String fechaFin){

           Date fInicio = DateUtil.parse(new SimpleDateFormat("dd-MM-yyyy"),fechaInicio);
           Date fFin = DateUtil.parse(new SimpleDateFormat("dd-MM-yyyy"), fechaFin);

           return (List<Requerimiento>) requerimientoRepository.findByFechaRequerimientoBetween(fInicio,fFin);

    }

    public List<Requerimiento> getAllRequerimientoOrderByIdRequerimientoDesc(){
        return (List<Requerimiento>) requerimientoRepository.findByOrderByIdRequerimientoDesc();
    }

    public Requerimiento getRequerimiento(long id){
        return requerimientoRepository.findById(id).get();
    }

    public Requerimiento createRequerimiento(Requerimiento requerimiento){
        requerimiento.setFechaRequerimiento(DateUtil.getCalculateDaysDate(new Date(),0));
        requerimiento.setFechaIda(DateUtil.getCalculateDaysDate(requerimiento.getFechaIda(),1));
        requerimiento.setFechaRetorno(DateUtil.getCalculateDaysDate(requerimiento.getFechaRetorno(),1));
        return  this.requerimientoRepository.save(requerimiento);
    }

    public void updateRequerimiento(Requerimiento requerimiento){
        requerimiento.setFechaIda(DateUtil.getCalculateDaysDate(requerimiento.getFechaIda(),1));
        requerimiento.setFechaRetorno(DateUtil.getCalculateDaysDate(requerimiento.getFechaRetorno(),1));

        requerimientoRepository.save(requerimiento);
    }
    public void deleteRequerimiento(Requerimiento requerimiento){
        requerimientoRepository.delete(requerimiento);
    }


    public List<Requerimiento>  getAllRequerimientosByUsuario(Usuario usuario){
        return requerimientoRepository.findByUsuario(usuario);
    }

    public  List<Requerimiento> getAllRequerimientosByUsuarioAndFechaSolicitud(Usuario usuario,String fechaInicio,String fechaFin){
        //try {
        Date fInicio = DateUtil.parse(new SimpleDateFormat("dd-MM-yyyy"),fechaInicio);
        Date fFin = DateUtil.parse(new SimpleDateFormat("dd-MM-yyyy"), fechaFin);

        return this.requerimientoRepository.findByUsuarioAndFechaRequerimientoBetween(usuario,fInicio,fFin);
    }

    public List<Requerimiento>  getAllRequerimientosByAprobado(){
        return requerimientoRepository.findByAprobado("APROBADO");
    }

}
