package com.transporte.pe.RequerimientoTransporte.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtrabajador")
    private long idTrabajador;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = true)
    private String direccion;

    @Column(nullable = true)
    private String telefono;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false)
    private String cargo;

    @ManyToOne
    @JoinColumn(name="idunidad")
    private Unidad unidad;




    public Trabajador() {

    }

    public Trabajador(long idTrabajador, String nombres, String sexo, String dni, String direccion, String telefono, String email, String cargo) {
        this.idTrabajador = idTrabajador;
        this.nombres = nombres;
        this.sexo = sexo;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.cargo = cargo;
    }
    public Trabajador(long idTrabajador, String nombres, String sexo, String dni, String direccion, String telefono, String email, String cargo,Unidad unidad) {
        this.idTrabajador = idTrabajador;
        this.nombres = nombres;
        this.sexo = sexo;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.cargo = cargo;
        this.unidad=unidad;
    }

    public long getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "idTrabajador=" + idTrabajador +
                ", nombres='" + nombres + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                ", unidad=" + unidad +
                '}';
    }
}
