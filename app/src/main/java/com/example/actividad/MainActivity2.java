package com.example.actividad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CheckBox;

public class MainActivity2 extends AppCompatActivity {

    Button regresar;
    Button enviar;

    private EditText nombre;
    private EditText apellido;
    private EditText cargo;
    private EditText SueldoBase;
    private EditText DiasLab;
    CheckBox descuento;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        enviar = findViewById(R.id.button3);
        regresar = findViewById(R.id.button2);
        nombre = findViewById(R.id.nombres);
        apellido = findViewById(R.id.apellidos);
        cargo = findViewById(R.id.cargo);
        SueldoBase = findViewById(R.id.sueldoB);
        DiasLab = findViewById(R.id.Diaslab);

        Intent primera = new Intent(this, MainActivity.class);

        regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(primera);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                String valorNombre = nombre.getText().toString();
                String valorApellido = apellido.getText().toString();
                String valorCargo = cargo.getText().toString();
                String valorSueldoBase = SueldoBase.getText().toString();
                String valorDiasLab = DiasLab.getText().toString();
                int DescuentoT =0;

                Intent datos = new Intent(MainActivity2.this, MainActivity3.class);
                datos.putExtra("nombre", valorNombre);
                datos.putExtra("apellido", valorApellido);
                datos.putExtra("cargo", valorCargo);
                datos.putExtra("sueldo", valorSueldoBase);
                datos.putExtra("diasLab", valorDiasLab);

                startActivity(datos);
            }
        });
        descuento = findViewById(R.id.descuento);
        SueldoBase = findViewById(R.id.sueldoB);



    }
}