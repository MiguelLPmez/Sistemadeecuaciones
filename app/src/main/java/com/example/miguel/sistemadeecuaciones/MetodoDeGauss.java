package com.example.miguel.sistemadeecuaciones;

public class MetodoDeGauss {
  
  public static double[] ObtenerSolucion(SistemaDeEcuaciones sistema,
                                         double x0, double y0, double z0,
                                         double tol, int iteraciones){
    // - Matriz de la soluci�n del sistema:
    double[] solucion;
    
    solucion = new double[3];
    
    solucion[0] = x0;
    solucion[1] = y0;
    solucion[2] = z0;
    
    for (int i = 0; i < iteraciones ; i++) {
      solucion[0] = sistema.obtenerX(solucion[1], solucion[2]);
      solucion[1] = sistema.obtenerY(solucion[0], solucion[2]);
      solucion[2] = sistema.obtenerZ(solucion[0], solucion[1]);
      
      if(Math.abs(x0-solucion[0]) < tol &&
          Math.abs(y0-solucion[1]) < tol &&
          Math.abs(z0-solucion[2]) < tol)
          return solucion;
      
      x0 = solucion[0];
      y0 = solucion[1];
      z0 = solucion[2];
    }
    
    return solucion;
  }
  
}
