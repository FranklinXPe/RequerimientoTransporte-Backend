package com.transporte.pe.RequerimientoTransporte.domain;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idusuario")
    private long idUsuario;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private boolean habilitado;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idtrabajador")
    private Trabajador trabajador;


    public Usuario() {
        // Requisito en JPA, un constructor sin argumentos
    }

    public Usuario(long idUsuario, String email, String password, String tipo, boolean habilitado,Trabajador trabajador) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.habilitado = habilitado;
        this.trabajador=trabajador;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (getIdUsuario() != usuario.getIdUsuario()) return false;
        if (isHabilitado() != usuario.isHabilitado()) return false;
        if (getEmail() != null ? !getEmail().equals(usuario.getEmail()) : usuario.getEmail() != null) return false;
        if (getPassword() != null ? !getPassword().equals(usuario.getPassword()) : usuario.getPassword() != null)
            return false;
        if (getTipo() != null ? !getTipo().equals(usuario.getTipo()) : usuario.getTipo() != null) return false;
        return getTrabajador() != null ? getTrabajador().equals(usuario.getTrabajador()) : usuario.getTrabajador() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getIdUsuario() ^ (getIdUsuario() >>> 32));
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getTipo() != null ? getTipo().hashCode() : 0);
        result = 31 * result + (isHabilitado() ? 1 : 0);
        result = 31 * result + (getTrabajador() != null ? getTrabajador().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                ", habilitado=" + habilitado +
                ", trabajador=" + trabajador +
                '}';
    }
}
