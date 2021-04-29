package com.example.sqlitecovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class PersonaCursorAdapter extends CursorAdapter {

    public PersonaCursorAdapter(Context context, Cursor c,boolean autoRequery ){
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_persona_cursor_adapter,parent,false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView txtdocumento = view.findViewById(R.id.txtdocumento);
        TextView txtnombre = view.findViewById(R.id.txtnombre);
        TextView txtapellido = view.findViewById(R.id.txtapellido);
        TextView txtdireccion = view.findViewById(R.id.txtdireccion);
        TextView txtlugar = view.findViewById(R.id.txtlugar);
        TextView txtfecha = view.findViewById(R.id.txtfecha);

        String documen = cursor.getString(0);
        String nombre = cursor.getString(1);
        String apellido = cursor.getString(2);
        String direccion = cursor.getString(3);
        String fecha = cursor.getString(4);
        String lugar = cursor.getString(5);



        txtdocumento.setText(documen);
        txtnombre.setText(nombre);
        txtapellido.setText(apellido);
        txtdireccion.setText(direccion);
        txtlugar.setText(lugar);
        txtfecha.setText(fecha);
    }
}