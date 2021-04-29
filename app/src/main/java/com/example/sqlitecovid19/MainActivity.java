package com.example.sqlitecovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Persona persona;
    PersonaController perCon;

    EditText documento,nombre,apellido,direccion,fecha,lugar;
    Button guardar,listar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        documento = findViewById(R.id.idDocumento);
        nombre = findViewById(R.id.idNombre);
        apellido=findViewById(R.id.idApellido);
        direccion=findViewById(R.id.idDireccion);
        fecha=findViewById(R.id.idFecha);
        lugar=findViewById(R.id.idLugar);

        guardar = findViewById(R.id.btnGuardar);
        listar = findViewById(R.id.btnListar);
        cancelar = findViewById(R.id.btnCancelar);

        guardar.setOnClickListener(this);
        listar.setOnClickListener(this);
        cancelar.setOnClickListener(this);


        perCon = new PersonaController(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar: Guardar(); break;
            case R.id.btnListar: Intent i = new Intent(this, ListadoActivity.class); startActivity(i); break;
            case R.id.btnCancelar: documento.setText("");nombre.setText("");apellido.setText("");direccion.setText("");lugar.setText("");fecha.setText("");break;
        }
    }

    private void Guardar() {

        if(TextUtils.isEmpty(documento.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                TextUtils.isEmpty(apellido.getText().toString()) ||
                TextUtils.isEmpty(direccion.getText().toString()) ||
                TextUtils.isEmpty(fecha.getText().toString()) ||
                TextUtils.isEmpty(lugar.getText().toString()) ){

            Toast.makeText(this,"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
        }
        else{

            persona = new Persona(documento.getText().toString(),nombre.getText().toString(),
                    apellido.getText().toString(),direccion.getText().toString(),
                    fecha.getText().toString(),lugar.getText().toString());

            if (perCon.buscarPersona(persona)){
                Toast.makeText(this,"Código ya existe", Toast.LENGTH_LONG).show();
            }
            else{
                perCon.agregarPersona(persona);
                documento.setText("");
                nombre.setText("");
                apellido.setText("");
                direccion.setText("");
                fecha.setText("");
                lugar.setText("");
            }

        }
    }

}