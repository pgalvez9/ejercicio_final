package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public TextView c0;
    public TextView c1;
    public TextView c2;
    public TextView c3;
    public TextView c4;
    public TextView c5;
    public TextView c6;
    public TextView c7;
    public TextView c8;
    public TextView c9;

    public int contador_secuencia;
    public int contador_meta;

    public Button azul_Button;
    public Button verde_Button;
    public Button rojo_Button;
    public Button amarillo_Button;

    public int[] secuencia;
    public TextView[] colores;

    public void iniciar(View view) {
        azul_Button = (Button) findViewById(R.id.bazul);
        azul_Button.setVisibility(View.VISIBLE);
        azul_Button.setText("AZUL");
        rojo_Button = (Button) findViewById(R.id.brojo);
        rojo_Button.setVisibility(View.VISIBLE);
        rojo_Button.setText("ROJO");
        verde_Button = (Button) findViewById(R.id.bverde);
        verde_Button.setVisibility(View.VISIBLE);
        verde_Button.setText("VERDE");
        amarillo_Button = (Button) findViewById(R.id.bamarillo);
        amarillo_Button.setVisibility(View.VISIBLE);
        amarillo_Button.setText("AMARILLO");

        secuencia = new int[10];
        contador_secuencia = 0;
        contador_meta = 1;

        for(int i = 0; i <= 9 ; i++)
        {
            Random ran = new Random();
            int entero_aleatorio = ran.nextInt(4); //numero aleatorio del 0 - 3
            if(entero_aleatorio == 0)
                secuencia[i] = ContextCompat.getColor(this, R.color.blue);; //azul
            if(entero_aleatorio == 1)
                secuencia[i] = ContextCompat.getColor(this, R.color.red); //rojo
            if(entero_aleatorio == 2)
                secuencia[i] = ContextCompat.getColor(this, R.color.green); //verde
            if(entero_aleatorio == 3)
                secuencia[i] = ContextCompat.getColor(this, R.color.yellow); //amarillo


            String color_imprimir = "";
            if(entero_aleatorio == 0)
                color_imprimir = "azul";
            if(entero_aleatorio == 1)
                color_imprimir = "rojo";
            if(entero_aleatorio == 2)
                color_imprimir = "verde";
            if(entero_aleatorio == 3)
                color_imprimir = "amarillo";

            Log.d("Secuencia",String.valueOf(i) +" "+ color_imprimir +" "+secuencia[i]);
        }

        c0 = (TextView) findViewById(R.id.c0);
        c1 = (TextView) findViewById(R.id.c1);
        c2 = (TextView) findViewById(R.id.c2);
        c3 = (TextView) findViewById(R.id.c3);
        c4 = (TextView) findViewById(R.id.c4);
        c5 = (TextView) findViewById(R.id.c5);
        c6 = (TextView) findViewById(R.id.c6);
        c7 = (TextView) findViewById(R.id.c7);
        c8 = (TextView) findViewById(R.id.c8);
        c9 = (TextView) findViewById(R.id.c9);
        c0.setBackgroundColor(secuencia[0]);
        c1.setBackgroundColor(secuencia[1]);
        c2.setBackgroundColor(secuencia[2]);
        c3.setBackgroundColor(secuencia[3]);
        c4.setBackgroundColor(secuencia[4]);
        c5.setBackgroundColor(secuencia[5]);
        c6.setBackgroundColor(secuencia[6]);
        c7.setBackgroundColor(secuencia[7]);
        c8.setBackgroundColor(secuencia[8]);
        c9.setBackgroundColor(secuencia[9]);

        colores = new TextView[10];
        colores[0] = c0;
        colores[1] = c1;
        colores[2] = c2;
        colores[3] = c3;
        colores[4] = c4;
        colores[5] = c5;
        colores[6] = c6;
        colores[7] = c7;
        colores[8] = c8;
        colores[9] = c9;
        invisible(9);
        visible(0);


    }
    public void visible(int tvi)
    {
        if(tvi>9)
        {
            Log.v("Error", "TVI es mayor a 9 "+String.valueOf(tvi));
        }
        else
        {
            for(int i = 0; i <= tvi ; i++)
            {
                colores[i].setVisibility(View.VISIBLE);
            }
        }



    }
    public void invisible(int tvi)
    {
        if(tvi>9)
        {
            Log.v("Error", "TVI es mayor a 9 "+String.valueOf(tvi));
        }
        else
        {
            for(int i = 0; i <= tvi ; i++)
            {
                colores[i].setVisibility(View.INVISIBLE);
            }
        }
    }
    public void boton(int i)
    {
        invisible(9);
        Log.d("Contador Secuencia", String.valueOf(contador_secuencia));
        Log.d("Contador Meta", String.valueOf(contador_meta));
        if(secuencia[contador_secuencia] == i)
        {
            contador_secuencia++;
            if(contador_secuencia == contador_meta)
            {
                contador_secuencia = 0;
                visible(contador_meta);
                contador_meta++;
            }
            if(contador_secuencia == 9 && contador_meta == 10)
            {
                ganar_perder("Ganaste");
            }
        }
        else
        {
            ganar_perder("Perdiste");
        }
    }

    public void ganar_perder(String texto)
    {
        azul_Button = (Button) findViewById(R.id.bazul);
        azul_Button.setText(texto);
        rojo_Button = (Button) findViewById(R.id.brojo);
        rojo_Button.setText(texto);
        verde_Button = (Button) findViewById(R.id.bverde);
        verde_Button.setText(texto);
        amarillo_Button = (Button) findViewById(R.id.bamarillo);
        amarillo_Button.setText(texto);
    }
    public void azul_press(View view) {
        boton(ContextCompat.getColor(this, R.color.blue));
    }
    public void rojo_press(View view) {
        boton(ContextCompat.getColor(this, R.color.red));
    }
    public void verde_press(View view) {
        boton(ContextCompat.getColor(this, R.color.green));
    }
    public void amarillo_press(View view) {
        boton(ContextCompat.getColor(this, R.color.yellow));
    }
}