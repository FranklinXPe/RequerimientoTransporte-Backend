package com.transporte.pe.RequerimientoTransporte.api;

import com.transporte.pe.RequerimientoTransporte.domain.Requerimiento;
import com.transporte.pe.RequerimientoTransporte.domain.Usuario;
import com.transporte.pe.RequerimientoTransporte.exception.HTTP400Exception;
import com.transporte.pe.RequerimientoTransporte.service.RequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "requerimiento")
public class RequerimientoController {
    @Autowired
    private RequerimientoService requerimientoService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Requerimiento> getAllRequerimientos(){
        return requerimientoService.getAllRequerimiento();
    }


    @RequestMapping(value = "/all/solicitudes",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Requerimiento> getAllRequerimientosEntreFechasSolicitud(
            @RequestParam(value = "fi") String fechInicio, @RequestParam(value = "ff") String fechaFin
    ){
        return requerimientoService.getAllRequerimientoEntreFechasSolicitud(fechInicio,fechaFin);
    }

    @RequestMapping(value = "/all/descendente",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Requerimiento> getAllRequerimientosDescendente(){
        return requerimientoService.getAllRequerimientoOrderByIdRequerimientoDesc();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Requerimiento getRequerimiento(@PathVariable Long id){
        return requerimientoService.getRequerimiento(id);
    }



    @RequestMapping(value = "",method = RequestMethod.POST,consumes = { "application/json"},produces = { "application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Requerimiento createRequerimiento(@RequestBody Requerimiento requerimiento, HttpServletRequest request, HttpServletResponse response){

        Requerimiento createdRequerimiento=this.requerimientoService.createRequerimiento(requerimiento);
        //response.setHeader("Location",request.getRequestURL().append("/").append(createdRequerimiento.getIdRequerimiento()).toString());
        return createdRequerimiento;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRequerimiento(@PathVariable("id") Long id, @RequestBody Requerimiento requerimiento,HttpServletRequest request, HttpServletResponse response){
        if(id!=requerimiento.getIdRequerimiento())
            throw new HTTP400Exception("El ID no coincide!");
        else
            this.requerimientoService.updateRequerimiento(requerimiento);
    }



    @RequestMapping(value = "/usuario/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Requerimiento> getAllRequerimientosByUsuario(@PathVariable Long id){
        Usuario usuario=new Usuario();
        usuario.setIdUsuario(id);
        return requerimientoService.getAllRequerimientosByUsuario(usuario);
    }

    @RequestMapping(value = "/usuario/{id}/fecha",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Requerimiento> getAllRequerimientosByUsuarioYFecha(@PathVariable Long id,
                                                             @RequestParam(value = "fi") String fechaInicio, @RequestParam(value = "ff") String fechaFin
    ){
        Usuario usuario=new Usuario();
        usuario.setIdUsuario(id);
        return requerimientoService.getAllRequerimientosByUsuarioAndFechaSolicitud(usuario,fechaInicio,fechaFin);
    }

    @RequestMapping(value = "/aprobados",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Requerimiento> getAllRequerimientosByAprobados(){

        return requerimientoService.getAllRequerimientosByAprobado();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRequerimiento(@PathVariable("id") Long id, @RequestBody Requerimiento requerimiento,HttpServletRequest request, HttpServletResponse response){
        if(id!=requerimiento.getIdRequerimiento())
            throw new HTTP400Exception("El ID no coincide!");
        else
            this.requerimientoService.deleteRequerimiento(requerimiento);
    }

}
