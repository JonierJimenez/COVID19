package com.example.sqlitecovid19;

public class DefBD {

    public static final String nameDb = "COVID199";
    public static final String tabla_per = "persona";
    public static final String col_documento = "documento";
    public static final String col_nombre="nombre";
    public static final String col_apellido="apellido";
    public static final String col_direccion="direccion";
    public static final String col_fechaPos="fechaPos";
    public static final String col_lugar="lugar";
    /*public static final String col_codigo = "codigo";
    public static final String col_nombre = "nombre";
    public static final String col_programa = "programa";*/

    public static final String create_tabla_est = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_per + " ( " +
            DefBD.col_documento + " text primary key," +
            DefBD.col_nombre + " text," +
            DefBD.col_apellido + " text," +
            DefBD.col_direccion + " text," +
            DefBD.col_fechaPos + " text," +
            DefBD.col_lugar + " text" +
            ");";

}
