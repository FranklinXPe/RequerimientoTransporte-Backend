package com.transporte.pe.RequerimientoTransporte.domain;

import com.transporte.pe.RequerimientoTransporte.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "requerimiento")
public class Requerimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrequerimiento")
    private long idRequerimiento;


    @Column(nullable = false,name = "fecharequerimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRequerimiento;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false,name = "fechaida")
    private Date fechaIda;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false,name = "fecharetorno")
    private Date fechaRetorno;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = true)
    private String observaciones;

    @Column(nullable = false, columnDefinition = "")
    private String aprobado;

    @Column(nullable = false,name = "ordenservicio")
    private String ordenServicio;

    @ManyToOne
    @JoinColumn(name = "iddestino")
    private Destino destino;


    @ManyToOne
    @JoinColumn(name = "idvehiculo")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;



    @ManyToMany
    @JoinTable(name = "Tripulacion",
            joinColumns ={ @JoinColumn(name = "idrequerimiento")},
            inverseJoinColumns = {@JoinColumn(name = "idtrabajador")}
    )
    private List<Trabajador> tripulacion=new ArrayList<Trabajador>();


    public Requerimiento() {

    }

    public Requerimiento(long idRequerimiento, Date fechaRequerimiento, Date fechaIda, Date fechaRetorno, String descripcion, String observaciones, String aprobado, String ordenServicio) {
        this.idRequerimiento = idRequerimiento;
        this.fechaRequerimiento = fechaRequerimiento;
        this.fechaIda = fechaIda;
        this.fechaRetorno = fechaRetorno;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.aprobado = aprobado;
        this.ordenServicio = ordenServicio;
    }

    public Requerimiento(long idRequerimiento, Date fechaRequerimiento, Date fechaIda, Date fechaRetorno, String descripcion, String observaciones, String aprobado, String ordenServicio, Destino destino,  Vehiculo vehiculo, Usuario usuario) {
        this.idRequerimiento = idRequerimiento;
        this.fechaRequerimiento = fechaRequerimiento;
        this.fechaIda = fechaIda;
        this.fechaRetorno = fechaRetorno;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.aprobado = aprobado;
        this.ordenServicio = ordenServicio;
        this.destino = destino;
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.tripulacion = tripulacion;
    }
    public Requerimiento(long idRequerimiento, Date fechaRequerimiento, Date fechaIda, Date fechaRetorno, String descripcion, String observaciones, String aprobado, String ordenServicio, Destino destino,  Vehiculo vehiculo, Usuario usuario, List<Trabajador> tripulacion) {
        this.idRequerimiento = idRequerimiento;
        this.fechaRequerimiento = fechaRequerimiento;
        this.fechaIda = fechaIda;
        this.fechaRetorno = fechaRetorno;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.aprobado = aprobado;
        this.ordenServicio = ordenServicio;
        this.destino = destino;
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.tripulacion = tripulacion;
    }

    public long getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(long idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public Date getFechaRequerimiento() {
       // return DateUtil.getCalculateDaysDate(fechaRequerimiento,1);
        return this.fechaRequerimiento;
    }

    public void setFechaRequerimiento(Date fechaRequerimiento) {

        //this.fechaRequerimiento =DateUtil.getCalculateDaysDate(fechaRequerimiento,1);
        this.fechaRequerimiento= fechaRequerimiento;
    }

    public Date getFechaIda() {
        //return DateUtil.getCalculateDaysDate(fechaIda,1);
        return this.fechaIda;
    }

    public void setFechaIda(Date fechaIda) {

       // this.fechaIda =  DateUtil.getCalculateDaysDate(fechaIda,1);
        this.fechaIda=fechaIda;
    }

    public Date getFechaRetorno() {

        //return DateUtil.getCalculateDaysDate(fechaRetorno,1);
        return this.fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {


       // this.fechaRetorno = DateUtil.getCalculateDaysDate(fechaRetorno,1);
        this.fechaRetorno=fechaRetorno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public String getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(String ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }



    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Trabajador> getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(List<Trabajador> tripulacion) {
        this.tripulacion = tripulacion;
    }

    @Override
    public String toString() {
        return "Requerimiento{" +
                "idRequerimiento=" + idRequerimiento +
                ", fechaRequerimiento=" + fechaRequerimiento +
                ", fechaIda=" + fechaIda +
                ", fechaRetorno=" + fechaRetorno +
                ", descripcion='" + descripcion + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", aprobado='" + aprobado + '\'' +
                ", ordenServicio='" + ordenServicio + '\'' +
                ", destino=" + destino +'\n'+
                ", vehiculo=" + vehiculo +'\n'+
                ", usuario=" + usuario +'\n'+
                ", Tripulacion=" + tripulacion.toString() +'\n'+
                '}';
    }
}
