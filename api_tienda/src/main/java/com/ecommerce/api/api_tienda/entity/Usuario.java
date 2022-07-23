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
    private String usr_email;
    @Column(length = 255)
    private String usr_password;
    private LocalDate usr_fecha;
    private LocalDate usr_fechNac;

    public Usuario() {

    }

    public Usuario(String usr_nombre, String usr_email, String usr_password, LocalDate usr_fechNac) {
        this.usr_nombre = usr_nombre;
        this.usr_email = usr_email;
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

    public String getUsr_email() {
        return usr_email;
    }

    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "usr_Id=" + usr_Id +
                ", usr_nombre='" + usr_nombre + '\'' +
                ", usr_email='" + usr_email + '\'' +
                ", usr_password='" + usr_password + '\'' +
                ", usr_fecha=" + usr_fecha +
                ", usr_fechNac=" + usr_fechNac +
                '}';
    }
}
