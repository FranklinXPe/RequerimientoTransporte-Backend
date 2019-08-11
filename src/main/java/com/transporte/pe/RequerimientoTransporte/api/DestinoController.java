package com.transporte.pe.RequerimientoTransporte.api;


import com.transporte.pe.RequerimientoTransporte.domain.Destino;
import com.transporte.pe.RequerimientoTransporte.exception.HTTP400Exception;
import com.transporte.pe.RequerimientoTransporte.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Destino> getAllDestinos(){
        return destinoService.getAllDestinos();

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Destino getDestino(@PathVariable("id") Long id){
        return destinoService.getDestino(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes = { "application/json"},produces = { "application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Destino createdDestino(@RequestBody Destino tipo, HttpServletRequest request, HttpServletResponse response){
        Destino createDestino=this.destinoService.createDestino(tipo);
        //response.setHeader("Location",request.getRequestURL().append("/").append(createdTipo.getIdTipo()).toString());
        return createDestino;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void udpateDestino(@PathVariable("id") Long id, @RequestBody Destino destino,HttpServletRequest request, HttpServletResponse response){
        if(id != destino.getIdDestino())
            throw new HTTP400Exception("El ID no coincide!");
        else
            destinoService.updateDestino(destino);
    }
}
