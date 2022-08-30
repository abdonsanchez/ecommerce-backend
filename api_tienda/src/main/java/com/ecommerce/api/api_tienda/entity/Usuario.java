package com.ecommerce.api.api_tienda.entity;

import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import java.time.LocalDate;

@ConstructorBinding
@Entity
@Table(name = "user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id", nullable = false, unique = true)
    private int usr_Id;
    @Column(length = 15)
    private String usr_nombre;
    @Column(length = 50)
    private String usremail;
    @Column(length = 255)
    private String usr_password;
    private LocalDate usr_fecha;
    private LocalDate usr_fechNac;
    @Column(length = 1, nullable = false, precision = 0)
    private int activo;

    public Usuario() {

    }

    public Usuario(String usr_nombre, String usremail, String usr_password, LocalDate usr_fechNac) {
        this.usr_nombre = usr_nombre;
        this.usremail = usremail;
        this.usr_password = usr_password;
        this.usr_fechNac = usr_fechNac;
    }

    public int getUsr_Id() {
        return usr_Id;
    }

    public void setUsr_Id(int usr_Id) {
        this.usr_Id = usr_Id;
    }

    public String getUsr_nombre() {
        return usr_nombre;
    }

    public void setUsr_nombre(String usr_nombre) {
        this.usr_nombre = usr_nombre;
    }

    public String getUsremail() {
        return usremail;
    }

    public void setUsremail(String usremail) {
        this.usremail = usremail;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }

    public LocalDate getUsr_fecha() {
        return usr_fecha;
    }

    public void setUsr_fecha(LocalDate usr_fecha) {
        this.usr_fecha = usr_fecha;
    }

    public LocalDate getUsr_fechNac() {
        return usr_fechNac;
    }

    public void setUsr_fechNac(LocalDate usr_fechNac) {
        this.usr_fechNac = usr_fechNac;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usr_Id=" + usr_Id +
                ", usr_nombre='" + usr_nombre + '\'' +
                ", usremail='" + usremail + '\'' +
                ", usr_password='" + usr_password + '\'' +
                ", usr_fecha=" + usr_fecha +
                ", usr_fechNac=" + usr_fechNac +
                ", activo=" + activo +
                '}';
    }
}
