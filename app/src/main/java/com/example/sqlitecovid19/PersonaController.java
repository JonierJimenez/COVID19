package com.example.sqlitecovid19;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class PersonaController {

    private BaseDatos bd;
    private Context c;
    public PersonaController( Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }

    public void agregarPersona(Persona e){
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();

            valores.put(DefBD.col_documento, e.getDocumento());
            valores.put(DefBD.col_nombre, e.getNombre());
            valores.put(DefBD.col_apellido, e.getApellido());

            valores.put(DefBD.col_direccion, e.getDireccion());
            valores.put(DefBD.col_fechaPos, e.getFechapos());
            valores.put(DefBD.col_lugar, e.getLugarA());

            long id = sql.insert(DefBD.tabla_per, null, valores);
            //sql.execSQL("insert into " + DefBD.tabla_est + " values (" + e.getCodigo() + "," + e.getNombre() + "," + e.getPrograma() +");");
            Toast.makeText(c, "Persona registrado", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error agregando Persona " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean buscarPersona(Persona e){
        String args[] = new String[] {e.getDocumento()};
        /*String[] columnas = {DefBD.col_documento,DefBD.col_nombre};
        String col[] = new String[] {DefBD.col_documento,DefBD.col_nombre};*/
        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_per,null,"documento=?",args,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }

    public Cursor allPersonas(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur = sql.rawQuery("select documento as _id , nombre, apellido, direccion, fechaPos, Lugar from persona", null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta Personas " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public Cursor filtrarPersona(CharSequence filtro){
        SQLiteDatabase sql = bd.getWritableDatabase();
        String query = "SELECT documento as _id, nombre, apellido, direccion,fechaPos, lugar FROM persona "
                + "where direccion like '%" + filtro + "%' or fechaPos like '%" + filtro + "%' or lugar like '%" + filtro + "%'"
                + "ORDER BY nombre ASC";

        return  sql.rawQuery(query, null);

    }

    public void eliminarPersona(int doc){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {""+doc};
            sql.delete(DefBD.tabla_per,"documento=?",args);
            Toast.makeText(c, "Persona eliminado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error eliminar Persona " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarPersona(Persona e){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {""+e.getDocumento()};
            ContentValues valores = new ContentValues();

            valores.put(DefBD.col_nombre, e.getNombre());
            valores.put(DefBD.col_apellido, e.getApellido());
            valores.put(DefBD.col_direccion, e.getDireccion());
            valores.put(DefBD.col_lugar, e.getLugarA());
            valores.put(DefBD.col_fechaPos,e.getFechapos());

            sql.update(DefBD.tabla_per,valores,"documento=?",args);
            Toast.makeText(c, "Persona actualizado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error actualizar Persona " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }



}
