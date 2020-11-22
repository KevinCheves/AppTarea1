package com.appmovil.apptarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtFecha;
    Button btnFecha;
    private int dia, mes, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFecha = (EditText)findViewById(R.id.txtFecha);
        btnFecha = (Button)findViewById(R.id.btnFecha);
        btnFecha.setOnClickListener(this);
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
        if(txtNombre.length()>0 && txtFecha.length()>0 && genero.length()>0 && txtTelefono.length()>0)
        {
          startActivity(intent);
        }else{
            Snackbar.make(view,"llene todos los campos",Snackbar.LENGTH_SHORT).show();
        }
    }
    public void cargarFecha(View view)
    {

    }

    @Override
    public void onClick(View v) {
        if(v==btnFecha){
            final Calendar c = Calendar.getInstance();
            dia =  c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            year = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    txtFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia,mes,year);
            datePickerDialog.show();
        }
    }
}