package com.pm.factor_abono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Calibration extends AppCompatActivity {

    private Spinner spProducto;
    private Spinner spEstado;
    private Spinner spAbonadora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibration);

        spProducto = (Spinner) findViewById(R.id.spProducto);
        spEstado = (Spinner) findViewById(R.id.spEstado);
        spAbonadora = (Spinner) findViewById(R.id.spAbonadora);

        String[] opProducto ={"Urea","Mezcla"};
        String[] opEstado ={"Plantilla","Soca"};
        String[] opAbonadora ={"119222","121111","121112","121113"};

        ArrayAdapter<String> prodcutos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opProducto);
        spProducto.setAdapter(prodcutos);
        ArrayAdapter<String> estados = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opEstado);
        spEstado.setAdapter(estados);
        ArrayAdapter<String> abonadoras = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opAbonadora);
        spAbonadora.setAdapter(abonadoras);
    }
}