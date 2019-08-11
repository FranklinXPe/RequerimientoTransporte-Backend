package com.transporte.pe.RequerimientoTransporte.api;

import com.transporte.pe.RequerimientoTransporte.domain.Unidad;
import com.transporte.pe.RequerimientoTransporte.exception.HTTP400Exception;
import com.transporte.pe.RequerimientoTransporte.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "unidad")
public class UnidadController {
    @Autowired
    private UnidadService unidadService;


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Unidad> getAllUnidad(){
        return unidadService.getAllUnidad();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Unidad getUnidad(@PathVariable("id") long id){
        return unidadService.getUnidad(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Unidad createdUnidad(@RequestBody Unidad unidad, HttpServletRequest request, HttpServletResponse response){
        Unidad createdUnidad=this.unidadService.createUnidad(unidad);
        //response.setHeader("Location",request.getRequestURL().append("/").append(createdUnidad.getIdUnidad()).toString());
        return createdUnidad;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void udpateUnidad(@PathVariable("id") Long id, @RequestBody Unidad unidad,HttpServletRequest request, HttpServletResponse response){
        if(id != unidad.getIdUnidad())
            throw new HTTP400Exception("El ID no coincide!");
        else
            unidadService.updateUnidad(unidad);
    }





} // UnidadController
