package com.transporte.pe.RequerimientoTransporte.api;

import com.transporte.pe.RequerimientoTransporte.domain.Usuario;
import com.transporte.pe.RequerimientoTransporte.exception.HTTP400Exception;
import com.transporte.pe.RequerimientoTransporte.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuario(@PathVariable("id") Long id){
        return usuarioService.getUsuario(id);
    }

    @RequestMapping(value = "/autenticar", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Usuario getAutenticarUsuario(@RequestParam("user") String user,@RequestParam("pass") String pass){
       // System.out.println(user +" y "+pass);
        Usuario u= usuarioService.getByUsuarioAndPassword(user, pass);
        if(u == null)
            throw new HTTP400Exception("Las credenciales de "+user+" y " +pass+" no coinciden!");
       else
        return u;
    }



    @RequestMapping(value = "",method = RequestMethod.POST,consumes = { "application/json"},produces = { "application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUsuario(@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response){
       /* System.out.println("El usuario enviado por el front es:");
        System.out.println(usuario.toString()); */

        Usuario createdUsuario=this.usuarioService.createUsuario(usuario);

        //response.setHeader("Location",request.getRequestURL().append("/").append(createdUsuario.getIdUsuario()).toString());
       // response.setHeader("Location",String.valueOf( request.getRequestURL().append("/").append(createdUsuario.getIdUsuario())));

        return createdUsuario;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = {"application/json"},produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario,HttpServletRequest request, HttpServletResponse response){
        if(id!=usuario.getIdUsuario())
            throw new HTTP400Exception("El ID no coincide!");
        else
            this.usuarioService.udpateUsuario(usuario);
    }



}
