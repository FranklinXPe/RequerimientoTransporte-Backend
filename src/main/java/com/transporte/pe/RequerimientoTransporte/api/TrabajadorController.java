package com.transporte.pe.RequerimientoTransporte.api;

import com.transporte.pe.RequerimientoTransporte.domain.Trabajador;
import com.transporte.pe.RequerimientoTransporte.exception.HTTP400Exception;
import com.transporte.pe.RequerimientoTransporte.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "trabajador")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Trabajador> getAllTrabajadores(){
        return trabajadorService.getAllTrabajadores();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Trabajador getVehiculo(@PathVariable("id") long id){
        return trabajadorService.getTrabajador(id);
    }


    @RequestMapping(value = "",method = RequestMethod.POST,consumes = { "application/json"},produces = { "application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Trabajador createTrabajador(@RequestBody Trabajador trabajador, HttpServletRequest request, HttpServletResponse response){

        Trabajador createdTrabajador=this.trabajadorService.createTrabajador(trabajador);

        //response.setHeader("Location",request.getRequestURL().append("/").append(createdTrabajador.getIdTrabajador()).toString());
        return trabajador;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrabajador(@PathVariable("id") Long id, @RequestBody Trabajador trabajador,HttpServletRequest request, HttpServletResponse response){
        if(id!=trabajador.getIdTrabajador())
            throw new HTTP400Exception("El ID no coincide!");
        else
            this.trabajadorService.updateTrabajador(trabajador);
    }
}
