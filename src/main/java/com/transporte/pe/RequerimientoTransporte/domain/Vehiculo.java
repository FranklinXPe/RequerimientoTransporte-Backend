package com.transporte.pe.RequerimientoTransporte.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehiculo")
    private long idVehiculo;

    @Column(nullable = false)
    private String clase;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false,name = "nroasientos")
    private short nroAsientos;

    @Column(nullable = false,name = "capacidadcarga")
    private String capacidadCarga;


    @ManyToOne
    @JoinColumn(name = "idtipo")
    private Tipo tipo;


    public Vehiculo() {

    }

    public Vehiculo(long idVehiculo, String clase, String placa, short nroAsientos, String capacidadCarga) {
        this.idVehiculo = idVehiculo;
        this.clase = clase;
        this.placa = placa;
        this.nroAsientos = nroAsientos;
        this.capacidadCarga = capacidadCarga;
    }
    public Vehiculo(long idVehiculo, String clase, String placa, short nroAsientos, String capacidadCarga,Tipo tipo) {
        this.idVehiculo = idVehiculo;
        this.clase = clase;
        this.placa = placa;
        this.nroAsientos = nroAsientos;
        this.capacidadCarga = capacidadCarga;
        this.tipo=tipo;
    }

    /*====== Getters y Setters ======*/
    public long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public short getNroAsientos() {
        return nroAsientos;
    }

    public void setNroAsientos(short nroAsientos) {
        this.nroAsientos = nroAsientos;
    }

    public String getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(String capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculo=" + idVehiculo +
                ", clase='" + clase + '\'' +
                ", placa='" + placa + '\'' +
                ", nroAsientos=" + nroAsientos +
                ", capacidadCarga='" + capacidadCarga + '\'' +
                ", tipos=" + tipo.toString() +
                '}';
    }
}
