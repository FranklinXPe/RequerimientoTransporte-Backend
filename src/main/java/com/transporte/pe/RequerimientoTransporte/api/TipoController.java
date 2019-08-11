package com.transporte.pe.RequerimientoTransporte.api;

import com.transporte.pe.RequerimientoTransporte.domain.Tipo;
import com.transporte.pe.RequerimientoTransporte.exception.HTTP400Exception;
import com.transporte.pe.RequerimientoTransporte.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tipo> getAllTipos(){
       return tipoService.getAllTipo();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Tipo getTipo(@PathVariable("id") Long id){
        return tipoService.getTipo(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST,consumes = { "application/json"},produces = { "application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Tipo createdTipo(@RequestBody Tipo tipo, HttpServletRequest request, HttpServletResponse response){
        Tipo createdTipo=this.tipoService.createTipo(tipo);
        //response.setHeader("Location",request.getRequestURL().append("/").append(createdTipo.getIdTipo()).toString());
        return createdTipo;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void udpateTipo(@PathVariable("id") Long id, @RequestBody Tipo tipo,HttpServletRequest request, HttpServletResponse response){
        if(id != tipo.getIdTipo())
            throw new HTTP400Exception("El ID no coincide!");
        else
            tipoService.udpateTipo(tipo);
    }

}
