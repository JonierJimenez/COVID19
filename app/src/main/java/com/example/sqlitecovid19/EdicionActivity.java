package com.example.sqlitecovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EdicionActivity extends AppCompatActivity {

    EditText documentoo, nombree, apellidoo, direcionn, lugarr, fechaa;
    Button actualizar, eliminar, regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);

        Intent i = getIntent();
        String doc = i.getStringExtra("documento");
        String nom = i.getStringExtra("nombre");
        String ape = i.getStringExtra("apellido");
        String dir = i.getStringExtra("direccion");
        String lug = i.getStringExtra("lugar");
        String fec = i.getStringExtra("fecha");

        documentoo = findViewById(R.id.edtdocumentoo);
        nombree = findViewById(R.id.edtnombree);
        apellidoo = findViewById(R.id.edtapellidoo);
        direcionn = findViewById(R.id.edtdireccionn);
        lugarr = findViewById(R.id.edtlugarr);
        fechaa = findViewById(R.id.edtfechaa);

        actualizar = findViewById(R.id.btnactualizar);
        eliminar = findViewById(R.id.btneliminar);
        regresar = findViewById(R.id.btnregresar);

        documentoo.setText(doc);
        documentoo.setEnabled(false);

        nombree.setText(nom);
        apellidoo.setText(ape);
        direcionn.setText(dir);
        lugarr.setText(lug);
        fechaa.setText(fec);


        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonaController ec = new PersonaController(getApplication());
                ec.eliminarPersona(Integer.parseInt(documentoo.getText().toString()));
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona e = new Persona(documentoo.getText().toString(),nombree.getText().toString(),
                        apellidoo.getText().toString(),direcionn.getText().toString(),
                        fechaa.getText().toString(),lugarr.getText().toString());
                PersonaController ec = new PersonaController(getApplication());
                ec.actualizarPersona(e);
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}