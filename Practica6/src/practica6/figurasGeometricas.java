/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

/**
 *
 * @author victoriapenas
 */
public interface figurasGeometricas {
    /*public static void calcularArea(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el radio");*/
        //en función de la figura será un cálculo u otro, por lo que
        //el resto de código debe estar en los hijos
        //return 0;
    public double calcularArea() throws Exception;//calculará el área de dicha figura y el cálculo será
                       //almacenado en las características del propio objeto.
    public double calcularVolumen();//calculará el volumen de dicha figura y el cálculo
                     //será almacenado en las características del propio objeto.
    public void imprimirCaracteristicas() throws Exception;/*imprimirá por pantalla un texto
"Calculadora de nombre+apellidos", y a continuación imprimirá las características
de cada figura geométrica así como su volumen y área.*/
}
