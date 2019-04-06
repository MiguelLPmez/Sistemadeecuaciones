package com.example.miguel.sistemadeecuaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText a11, a12, a13, a21, a22, a23, a31, a32, a33, b1, b2, b3, x0, y0, z0, tol, itmax;
    int x1, x2, x3, x4, x5, x6, x7, x8, x9, a, b, c, xo, yo, zo, tole, imax;
    TextView X1, X2, X3;
    RadioButton jacobi, gauss;
    RadioGroup rGroupMetodo;
    Button botonCalcular;
    MetodoDeJacobi jacobiM;
    MetodoDeGauss gaussM;
    SistemaDeEcuaciones sistema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        a11 = findViewById(R.id.a11);
        a12 = findViewById(R.id.a12);
        a13 = findViewById(R.id.a13);
        a21 = findViewById(R.id.a21);
        a22 = findViewById(R.id.a22);
        a23 = findViewById(R.id.a23);
        a31 = findViewById(R.id.a31);
        a32 = findViewById(R.id.a32);
        a33 = findViewById(R.id.a33);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        x0 = findViewById(R.id.x0);
        y0 = findViewById(R.id.y0);
        z0 = findViewById(R.id.z0);
        tol = findViewById(R.id.tol);
        itmax = findViewById(R.id.itmax);
        rGroupMetodo = findViewById(R.id.rGroupMetodo);
        botonCalcular = findViewById(R.id.botonCalcular);
        X1 = findViewById(R.id.resultx1);
        X1 = findViewById(R.id.resultx2);
        X1 = findViewById(R.id.resultx3);

        jacobiM = new MetodoDeJacobi();
        gaussM = new MetodoDeGauss();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Verifica la longitud de los datos introducidos en los campos de texto, si encuentra
     * datos/campos vacíos mantiene deshabilitado el botón Calcular y vacía las opciones de los
     * checkBox
     */
    private boolean verificacionDeDatos(){
        if(a11.getText().length()==0 || a12.getText().length()==0 || a13.getText().length()==0 ||
            a21.getText().length()==0 || a22.getText().length()==0 || a23.getText().length()==0 ||
            a31.getText().length()==0 || a32.getText().length()==0 || a33.getText().length()==0 ||
            b1.getText().length()==0 || b2.getText().length()==0 || b3.getText().length()==0 ||
            x0.getText().length()==0 || y0.getText().length()==0 || z0.getText().length()==0 ||
            tol.getText().length()==0 || itmax.getText().length()==0) {
            botonCalcular.setEnabled(false);
            rGroupMetodo.clearCheck();
            return false;
        }else
        return true;
    }

    private void convertirStrings(){
        x1 = Integer.parseInt(a11.getText().toString());
        x2 = Integer.parseInt(a12.getText().toString());
        x3 = Integer.parseInt(a13.getText().toString());
        x4 = Integer.parseInt(a21.getText().toString());
        x5 = Integer.parseInt(a22.getText().toString());
        x6 = Integer.parseInt(a23.getText().toString());
        x7 = Integer.parseInt(a31.getText().toString());
        x8 = Integer.parseInt(a32.getText().toString());
        x9 = Integer.parseInt(a33.getText().toString());
        a = Integer.parseInt(b1.getText().toString());
        b = Integer.parseInt(b2.getText().toString());
        c = Integer.parseInt(b3.getText().toString());
        xo = Integer.parseInt(x0.getText().toString());
        yo = Integer.parseInt(y0.getText().toString());
        zo = Integer.parseInt(z0.getText().toString());
        tole = Integer.parseInt(tol.getText().toString());
        imax = Integer.parseInt(itmax.getText().toString());
    }



    public void calculatePerformed(View v){
        convertirStrings();
        sistema = new SistemaDeEcuaciones(new double[][]{{x1, x2, x3, a},
                {x4, x5, x6, b},
                {x7, x8, x9, c}});
        int id = rGroupMetodo.getCheckedRadioButtonId();
        verificacionDeDatos();
        if(id==jacobi.getId()&&verificacionDeDatos()==true){
            double[] solución;
            solución = MetodoDeJacobi.ObtenerSolucion(sistema,xo,yo,zo,tole,imax);
            X1.setText("X1: "+solución);
            X2.setText("X2: "+solución);
            X3.setText("X3: "+solución);
        }else if(id==jacobi.getId()&&verificacionDeDatos()==true){
            double[] solución;
            solución = MetodoDeGauss.ObtenerSolucion(sistema,xo,xo,zo,tole,imax);
            X1.setText("X1: "+solución);
            X2.setText("X2: "+solución);
            X3.setText("X3: "+solución);
        }
    }



    private void resultados(){
        SistemaDeEcuaciones sistema;
        double[] solucion;

        sistema = new SistemaDeEcuaciones(new double[][]{{10, -1,  0,  9}, {-1, 10, -2, 7}, {0,  -2, 10, 6}});

        solucion = MetodoDeJacobi.ObtenerSolucion(sistema, 0, 0, 0, 0.000000001, 10);

    }
}