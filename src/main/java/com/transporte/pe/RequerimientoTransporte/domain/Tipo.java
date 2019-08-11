package com.transporte.pe.RequerimientoTransporte.domain;

import javax.persistence.*;

@Entity
@Table(name="tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo")
    private long idTipo;

    @Column(nullable = false)
    private String nombre;



    public Tipo() {

    }

    public Tipo(long idTipo, String nombre) {
        this.idTipo = idTipo;
        this.nombre = nombre;
    }

    public long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(long idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "idTipo=" + idTipo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
