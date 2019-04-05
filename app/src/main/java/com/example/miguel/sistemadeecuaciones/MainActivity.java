package com.example.miguel.sistemadeecuaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void resultados(){
        SistemaDeEcuaciones sistema;
        double[] solucion;

        sistema = new SistemaDeEcuaciones(new double[][]{{10, -1,  0,  9},
                                                          {-1, 10, -2, 7},
                                                          {0,  -2, 10, 6}});

        solucion = MetodoDeJacobi.ObtenerSolucion(sistema, 0, 0, 0, 0.000000001, 10);

    }
}
