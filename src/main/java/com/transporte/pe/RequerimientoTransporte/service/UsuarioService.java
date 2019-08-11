package com.transporte.pe.RequerimientoTransporte.service;

import com.transporte.pe.RequerimientoTransporte.dao.UsuarioRepository;
import com.transporte.pe.RequerimientoTransporte.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {

    }

   public Usuario getUsuario(long id){
        return usuarioRepository.findById(id).get();
   }


    public Usuario getByUsuarioAndPassword(String usuario, String password){
        return usuarioRepository.getByEmailAndPassword(usuario,password);
    }

    public List<Usuario> getAllUsuarios(){
        return (List<Usuario>) usuarioRepository.findAll();

    }


    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void udpateUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }


}// end class UsuarioService
