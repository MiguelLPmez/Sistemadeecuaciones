package com.example.miguel.sistemadeecuaciones;

/*


  Sistema de 3 ecuaciones lineales con 3 inc�gnitas.
*/

public class SistemaDeEcuaciones {
  private final double[][] matriz_ecuacion;
  
  public SistemaDeEcuaciones(double[][] matriz_ecuacion){
    this.matriz_ecuacion = matriz_ecuacion;
  }  
  
  public void setCoeficiente(int i, int j, int nuevo_valor){
    matriz_ecuacion[i][j] = nuevo_valor;
  }
  
  public double getCoeficiente(int i, int j){
    return matriz_ecuacion[i][j];
  }
  
  // - M�todos para la aplicaci�n de los m�todos de soluci�n...
  
  public double obtenerX(double y, double z){
    return (matriz_ecuacion[0][3] - matriz_ecuacion[0][1] * y
            - matriz_ecuacion[0][2] * z) / matriz_ecuacion[0][0];
  }
  
  public double obtenerY(double x, double z){
    return (matriz_ecuacion[1][3] - matriz_ecuacion[1][0] * x
            - matriz_ecuacion[1][2] * z) / matriz_ecuacion[1][1];
  }
  
  public double obtenerZ(double x, double y){
    return (matriz_ecuacion[2][3] - matriz_ecuacion[2][0] * x
            - matriz_ecuacion[2][1] * y) / matriz_ecuacion[2][2];
  }
}
