package com.example.actividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cambio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cambio = findViewById(R.id.button);

        Intent segunda = new Intent(this, MainActivity2.class);
        cambio.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick (View v) {
            startActivity(segunda);
        }
        });



    }
}