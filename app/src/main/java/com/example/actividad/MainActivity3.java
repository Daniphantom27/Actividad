package com.example.actividad;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView traerNombre;
    private TextView traerApellido;
    private TextView traerCargo;
    private TextView traerSueldo;
    private TextView traerDias;
    private TextView ValorxDias;
    private TextView Subtotal;
    private TextView traerDescuento;
    private TextView traerPrueba;

    @SuppressLint({"MissingInflatedId", "WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent datos = getIntent();

        String datoNombre = datos.getStringExtra("nombre");
        String datoApellido = datos.getStringExtra("apellido");
        String datoCargo = datos.getStringExtra("cargo");
        String datoSueldo = datos.getStringExtra("sueldo");
        String datoDias = datos.getStringExtra("diasLab");
        boolean datoDescuento = datos.getBooleanExtra("descuento", false);
        boolean datoSalud = datos.getBooleanExtra("salud", false);
        boolean datoPension = datos.getBooleanExtra("pension", false);


        int sueldoInt = Integer.parseInt(datoSueldo);
        int diasInt = Integer.parseInt(datoDias);

        int valorxdias = sueldoInt / 30;

        int subtotal = valorxdias * diasInt;

        double DescuentoX = 0;
        double DescuentoT = 0;
        if (datoDescuento) {
            DescuentoX = subtotal * 0.04;
            DescuentoT = subtotal  - DescuentoX;
        }

        double SaludX = 0;
        double SaludT = 0;
        if (datoSalud) {
            SaludX = subtotal * 0.04;
            SaludT = subtotal  - SaludX;
        }

        double PensionX = 0;
        double PensionT = 0;
        if (datoPension) {
            PensionX = subtotal * 0.04;
            PensionT = subtotal  - PensionX;
        }

        double SueldoNeto = 0;
        if (datoDescuento && datoSalud && datoPension) {
            SueldoNeto = (subtotal) - (DescuentoT + SaludT + PensionT);

        } else if (datoDescuento && datoSalud) {
            SueldoNeto = (subtotal) - (DescuentoT + SaludT);

        } else if (datoDescuento && datoPension) {
            SueldoNeto = (subtotal) - (DescuentoT + PensionT);

        } else if (datoSalud && datoPension) {
            SueldoNeto = (subtotal) - (SaludT + PensionT);
            ;
        }



        traerNombre = findViewById(R.id.traeNombre);
        traerNombre.setText(datoNombre);

        traerApellido = findViewById(R.id.TraeApellido);
        traerApellido.setText(datoApellido);

        traerCargo = findViewById(R.id.traeCargo);
        traerCargo.setText(datoCargo);

        traerSueldo = findViewById(R.id.traeSueldo);
        traerSueldo.setText(datoSueldo);

        traerDias = findViewById(R.id.traeDias);
        traerDias.setText(datoDias);

        ValorxDias = findViewById(R.id.valorxdia);
        String resultadoValorxdia = Integer.toString(valorxdias);
        ValorxDias.setText("Valor x Dia: " + resultadoValorxdia);

        Subtotal = findViewById(R.id.subtotal);
        String resultadoSubtotal = Integer.toString(subtotal);
        Subtotal.setText("Subtotal: " + resultadoSubtotal);

        traerPrueba = findViewById(R.id.pruebita);
        traerPrueba.setText("Sueldo Neto: " + SueldoNeto);


    }
}