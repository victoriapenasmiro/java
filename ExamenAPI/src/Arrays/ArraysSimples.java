/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

/**
 *
 * @author victoriapenas
 */
public class ArraysSimples {
        
        String [] arrayLiteral = {"Esto","es","una", "Array ","literal"};
        int [] arrayInstanciada = new int [6];
        double [] arrayNoInstanciada = null;
                
        /*Si instanciamos a posteriori una array, hay que hacerlo dentro de un método, sino falla*/
        public static double [] calcularTotales(){
            double [] arrayNoInstanciada = null;
            arrayNoInstanciada = new double[]{1.2,3.4};
        
            return arrayNoInstanciada;
    }
}
