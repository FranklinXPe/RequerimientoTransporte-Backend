package com.transporte.pe.RequerimientoTransporte.domain;


import javax.persistence.*;

@Entity
@Table(name = "destino")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddestino")
    private long idDestino;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String distrito;


    public Destino() {


    }

    public Destino(long idDestino, String provincia, String distrito) {
        this.idDestino = idDestino;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    public long getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(long idDestino) {
        this.idDestino = idDestino;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "idDestino=" + idDestino +
                ", provincia='" + provincia + '\'' +
                ", distrito='" + distrito + '\'' +
                '}';
    }
}
