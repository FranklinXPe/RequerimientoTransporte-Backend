package com.transporte.pe.RequerimientoTransporte.domain;

import javax.persistence.*;

@Entity
@Table(name="unidad")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idunidad")
    private long idUnidad;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ubicacion;


    public Unidad() {
    }

    public Unidad(long idUnidad, String nombre, String ubicacion) {
        this.idUnidad = idUnidad;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }



    public long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "idUnidad=" + idUnidad +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
