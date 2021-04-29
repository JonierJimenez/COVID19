package com.example.sqlitecovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class ListadoActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,View.OnClickListener {
    ListView listado;
    PersonaController personaController;
    SearchView filtro;
    PersonaCursorAdapter adapter;
    Button regresar;
    private BaseDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        regresar = findViewById(R.id.Regresar);
        regresar.setOnClickListener(this);

        listado = findViewById(R.id.lsList);
        filtro = findViewById(R.id.sFiltro);
        personaController = new PersonaController(this);
        Cursor c = personaController.allPersonas();

        adapter = new PersonaCursorAdapter(this,c,false);
        listado.setAdapter(adapter);
        listado.setTextFilterEnabled(true);
        adapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                return personaController.filtrarPersona(constraint);
            }
        });
        filtro.setOnQueryTextListener(this);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtdocumento = view.findViewById(R.id.txtdocumento);
                TextView nombre = view.findViewById(R.id.txtnombre);
                TextView apellido = view.findViewById(R.id.txtapellido);
                TextView direccion = view.findViewById(R.id.txtdireccion);
                TextView lugar = view.findViewById(R.id.txtlugar);
                TextView fecha = view.findViewById(R.id.txtfecha);

                Intent i = new Intent(getApplicationContext(), EdicionActivity.class);
                i.putExtra("documento", txtdocumento.getText().toString());
                i.putExtra("nombre", nombre.getText().toString());
                i.putExtra("apellido", apellido.getText().toString());
                i.putExtra("direccion", direccion.getText().toString());
                i.putExtra("lugar", lugar.getText().toString());
                i.putExtra("fecha", fecha.getText().toString());
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("search", newText);
        String text = newText;
        adapter.getFilter().filter(newText);
        adapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Regresar: Intent i = new Intent(getApplicationContext(),MainActivity.class); startActivity(i); finish(); break;
        }
    }
}