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
    EditText a1, a2, a3, a4, a5, a6, a7, a8, a9, a, b, c, xo, yo, zo, tole, imax;
    int x1, x2, x3, x4, x5, x6, x7, x8, x9, x, y, z, xO, yO, zO, tolE, iMax;
    TextView X1R, X2R, X3R;
    RadioButton jacobi, gauss;
    RadioGroup rGroupMetodo;
    Button botonCalcular;
    MetodoDeJacobi jacobiM;
    MetodoDeGauss gaussM;
    SistemaDeEcuaciones sistema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = findViewById(R.id.a11);
        a2 = findViewById(R.id.a12);
        a3 = findViewById(R.id.a13);
        a4 = findViewById(R.id.a21);
        a5 = findViewById(R.id.a22);
        a6 = findViewById(R.id.a23);
        a7 = findViewById(R.id.a31);
        a8 = findViewById(R.id.a32);
        a9 = findViewById(R.id.a33);
        a = findViewById(R.id.b1);
        b = findViewById(R.id.b2);
        c = findViewById(R.id.b3);
        xo = findViewById(R.id.x0);
        yo = findViewById(R.id.y0);
        zo = findViewById(R.id.z0);
        tole = findViewById(R.id.tol);
        imax = findViewById(R.id.itmax);
        X1R = findViewById(R.id.resultx1);
        X2R = findViewById(R.id.resultx2);
        X3R = findViewById(R.id.resultx3);
        rGroupMetodo = findViewById(R.id.rGroupMetodo);
        jacobi = findViewById(R.id.jacobi);
        gauss = findViewById(R.id.gauss);
        botonCalcular = findViewById(R.id.botonCalcular);
        botonCalcular.setEnabled(false);

        jacobiM = new MetodoDeJacobi();
        gaussM = new MetodoDeGauss();
    }

    /**
     * Verifica la longitud de los datos introducidos en los campos de texto, si encuentra
     * datos/campos vacíos mantiene deshabilitado el botón Calcular y vacía las opciones de los
     * checkBox
     */
    private boolean verificacionDeDatos(){
        return a1.getText().length()!=0 && a2.getText().length()!=0 && a3.getText().length()!=0 &&
                a4.getText().length()!=0 && a5.getText().length()!=0 && a6.getText().length()!=0 &&
                a7.getText().length()!=0 && a8.getText().length()!=0 && a9.getText().length()!=0 &&
                a.getText().length()!=0 && b.getText().length()!=0 && c.getText().length()!=0 &&
                xo.getText().length()!=0 && yo.getText().length()!=0 && zo.getText().length()!=0 &&
                tole.getText().length()!=0 && imax.getText().length()!=0;
    }

    public void rGroupPerformed(View v){
        if(verificacionDeDatos())
            botonCalcular.setEnabled(true);
        else
            rGroupMetodo.clearCheck();
    }

    public void calculatePerformed(View v) {
        if (verificacionDeDatos()) {
            x1 = Integer.parseInt(a1.getText().toString());
            x2 = Integer.parseInt(a2.getText().toString());
            x3 = Integer.parseInt(a3.getText().toString());
            x4 = Integer.parseInt(a4.getText().toString());
            x5 = Integer.parseInt(a5.getText().toString());
            x6 = Integer.parseInt(a6.getText().toString());
            x7 = Integer.parseInt(a7.getText().toString());
            x8 = Integer.parseInt(a8.getText().toString());
            x9 = Integer.parseInt(a9.getText().toString());
            x = Integer.parseInt(a.getText().toString());
            y = Integer.parseInt(b.getText().toString());
            z = Integer.parseInt(c.getText().toString());
            xO = Integer.parseInt(xo.getText().toString());
            yO = Integer.parseInt(yo.getText().toString());
            zO = Integer.parseInt(zo.getText().toString());
            tolE = Integer.parseInt(tole.getText().toString());
            iMax = Integer.parseInt(imax.getText().toString());

            sistema = new SistemaDeEcuaciones(new double[][]{{x1, x2, x3, x},
                    {x4, x5, x6, y},
                    {x7, x8, x9, z}});
            int id = rGroupMetodo.getCheckedRadioButtonId();
            if (id == jacobi.getId() && verificacionDeDatos()) {
                double[] solución;
                solución = MetodoDeJacobi.ObtenerSolucion(sistema, xO, yO, zO, tolE, iMax);
                X1R.setText("X1: " + solución[0]);
                X2R.setText("X2: " + solución[1]);
                X3R.setText("X3: " + solución[2]);
            } else if (id == gauss.getId() && verificacionDeDatos()) {
                double[] solución;
                solución = MetodoDeGauss.ObtenerSolucion(sistema, xO, yO, zO, tolE, iMax);
                X1R.setText("X1: " + solución[0]);
                X2R.setText("X2: " + solución[1]);
                X3R.setText("X3: " + solución[2]);
            }
        }else {
            botonCalcular.setEnabled(false);
            rGroupMetodo.clearCheck();
            X1R.setText("X1");
            X2R.setText("X2");
            X3R.setText("X3");
        }
    }



    private void resultados(){
        SistemaDeEcuaciones sistema;
        double[] solucion;

        sistema = new SistemaDeEcuaciones(new double[][]{{10, -1,  0,  9}, {-1, 10, -2, 7}, {0,  -2, 10, 6}});

        solucion = MetodoDeJacobi.ObtenerSolucion(sistema, 0, 0, 0, 0.000000001, 10);

    }
}