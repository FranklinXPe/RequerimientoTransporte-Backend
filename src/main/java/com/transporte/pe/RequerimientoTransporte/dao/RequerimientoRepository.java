package com.transporte.pe.RequerimientoTransporte.dao;

import com.transporte.pe.RequerimientoTransporte.domain.Requerimiento;
import com.transporte.pe.RequerimientoTransporte.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RequerimientoRepository extends CrudRepository<Requerimiento,Long> {

    List<Requerimiento> findByUsuario(Usuario usuario);

    List<Requerimiento> findByAprobado(String estado);


    List<Requerimiento> findByOrderByIdRequerimientoDesc();

    List<Requerimiento> findByFechaRequerimientoBetween(Date fechaInicio,Date fechaFin);

    List<Requerimiento> findByUsuarioAndFechaRequerimientoBetween(Usuario user, Date fechaInicio,Date fechaFin);
}
