package com.appmovil.apptarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnEnviar(View view)
    {
        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        EditText txtFecha = (EditText)findViewById(R.id.txtFecha);
        EditText txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        RadioButton rbMasculino = (RadioButton)findViewById(R.id.rbMasculino);
        RadioButton rbFemenino = (RadioButton)findViewById(R.id.rbFemenino);
        String genero ="";
        if(rbMasculino.isChecked()==true)
        {
            genero = rbMasculino.getText().toString();
        }
        if(rbFemenino.isChecked()==true)
        {
            genero = rbFemenino.getText().toString();
        }
        //Creamos la información a pasar entre actividades - Pares Key-Value     
        Bundle b = new Bundle();      
        b.putString("NOMBRE", txtNombre.getText().toString());
        b.putString("FECHA", txtFecha.getText().toString());
        b.putString("TELEFONO", txtTelefono.getText().toString());
        b.putString("GENERO", genero);
        //Añadimos la información al intent      
        intent.putExtras(b);     
        // Iniciamos la nueva actividad      
        startActivity(intent);
    }

    }