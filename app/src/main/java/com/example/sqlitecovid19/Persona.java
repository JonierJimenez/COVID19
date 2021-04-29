package com.example.sqlitecovid19;

public class Persona {

    private String documento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String fechapos;
    private String lugarA;

    public Persona(String documento, String nombre, String apellido, String direccion, String fechapos, String lugarA) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechapos = fechapos;
        this.lugarA = lugarA;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechapos() {
        return fechapos;
    }

    public void setFechapos(String fechapos) {
        this.fechapos = fechapos;
    }

    public String getLugarA() {
        return lugarA;
    }

    public void setLugarA(String lugarA) {
        this.lugarA = lugarA;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechapos='" + fechapos + '\'' +
                ", lugarA='" + lugarA + '\'' +
                '}';
    }

}
