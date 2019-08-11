package com.transporte.pe.RequerimientoTransporte.api;

import com.transporte.pe.RequerimientoTransporte.domain.Vehiculo;
import com.transporte.pe.RequerimientoTransporte.exception.HTTP400Exception;
import com.transporte.pe.RequerimientoTransporte.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Vehiculo> getAllVehiculos(){
        return vehiculoService.getAllVehiculos();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Vehiculo getVehiculo(@PathVariable("id") long id){
        return vehiculoService.getVehiculo(id);
    }


    @RequestMapping(value = "",method = RequestMethod.POST,consumes = { "application/json"},produces = { "application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo, HttpServletRequest request, HttpServletResponse response){
        System.out.println("Esto es lo que se ve:"+vehiculo.toString());
        Vehiculo createdVehiculo=this.vehiculoService.createVehiculo(vehiculo);

        //response.setHeader("Location",request.getRequestURL().append("/").append(createdVehiculo.getIdVehiculo()).toString());
        return createdVehiculo;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateVehiculo(@PathVariable("id") Long id, @RequestBody Vehiculo vehiculo,HttpServletRequest request, HttpServletResponse response){
        if(id!=vehiculo.getIdVehiculo())
            throw new HTTP400Exception("El ID no coincide!");
        else
            this.vehiculoService.udpateVehiculo(vehiculo);
    }

}
