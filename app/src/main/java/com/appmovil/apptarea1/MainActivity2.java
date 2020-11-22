package com.appmovil.apptarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Localizar los controles  TextView
        TextView txtSaludo = (TextView) findViewById(R.id.txtSaludo);
        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        //Construimos el mensaje a mostrar
        String datos = "Nombre: " + bundle.getString("NOMBRE")+" \n Fecha Nac: "+ bundle.getString("FECHA") +" \n Genero: "+ bundle.getString("GENERO") + " \n Telefono: "+ bundle.getString("TELEFONO");
        txtSaludo.setText("Su información personal es: \n " + datos);

    }
}