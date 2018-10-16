package com.example.ricindigus.empove2018.modelo.pojos;

public class Usuario {
    private int _id;
    private String nombre;
    private String password;

    public Usuario() {
    }

    public Usuario(int _id, String nombre, String password) {
        this._id = _id;
        this.nombre = nombre;
        this.password = password;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
