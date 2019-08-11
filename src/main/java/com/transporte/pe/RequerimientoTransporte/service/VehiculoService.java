package com.transporte.pe.RequerimientoTransporte.service;

import com.transporte.pe.RequerimientoTransporte.dao.VehiculoRepository;
import com.transporte.pe.RequerimientoTransporte.domain.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getAllVehiculos(){
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    public Vehiculo getVehiculo(long id){
        return vehiculoRepository.findById(id).get();
    }



    public Vehiculo createVehiculo(Vehiculo vehiculo){
       return  this.vehiculoRepository.save(vehiculo);
    }

    public void udpateVehiculo(Vehiculo vehiculo){
        vehiculoRepository.save(vehiculo);
    }
}
