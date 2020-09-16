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
public class Bidimensionales {
    
    public static void rellenarTablaBidimensional(){
        //declaro la matriz
        int tabla[][] = new int [5][5];
        //relleno la matriz
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                tabla [i][j] = i+j;
            }
        }
        //imprimo la matriz
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                if (j==tabla[i].length-1){ // accedo a la última posición de j
                    System.out.println(tabla[i][j]);
                }
                else{
                    System.out.print(tabla[i][j]);
                }
            }
        }
    }
}
