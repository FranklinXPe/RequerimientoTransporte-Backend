package com.transporte.pe.RequerimientoTransporte.dao;

import com.transporte.pe.RequerimientoTransporte.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    Usuario getByEmailAndPassword(String email,String password);
}
