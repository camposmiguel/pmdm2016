package com.miguelcr.app.localdb;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "AIRLINE".
 */
@Entity
public class Airline {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String urlLogo;

    @NotNull
    private String codigo;

    @Generated
    public Airline() {
    }

    public Airline(Long id) {
        this.id = id;
    }

    @Generated
    public Airline(Long id, String nombre, String urlLogo, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.urlLogo = urlLogo;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getNombre() {
        return nombre;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    @NotNull
    public String getUrlLogo() {
        return urlLogo;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUrlLogo(@NotNull String urlLogo) {
        this.urlLogo = urlLogo;
    }

    @NotNull
    public String getCodigo() {
        return codigo;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCodigo(@NotNull String codigo) {
        this.codigo = codigo;
    }

}
