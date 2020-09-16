/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenapi;

import java.util.Random;

/**
 *
 * @author victoriapenas
 * fuente: http://chuwiki.chuidiang.org/index.php?title=Generar_n%C3%BAmeros_aleatorios_en_Java
 * fuente, generar caracteres aleatorios: https://es.stackoverflow.com/questions/159410/como-se-puede-generar-caracteres-aleatorios-con-math-random/159670
 * 
 */
public class MathRandom {
    double numeros = Math.random()*6;   // Esto da valores de 0.0 a 6.0, excluido el 6.0
    double numeros2 = Math.random()*6 + 1;   // Esto da valores entre 1.0 y 7.0 excluido el 7.0
    int numeroEntero = (int) Math.floor(Math.random()*6+1); //quitamos los decimales usando la clase Math.floor()
    
    /*Otra opción:*/
    Random r = new Random();
    int valorDado = r.nextInt(6)+1;  // Entre 0 y 5, más 1. // Entre 0 y 5, más 1. // Entre 0 y 5, más 1. // Entre 0 y 5, más 1.

    public static void pruebas(){
    Random r = new Random();
        //Para generar 5 enteros entre 0 y 6:
        for(int i=1; i<=5; i++){
            System.out.println(r.nextInt(7));
        }

        //Para generar 5 enteros entre 1 y 6:
        for(int j = 1; j<=5; j++){
            System.out.println(r.nextInt(6)+1);
        }
    
        /*En general, para generar enteros al azar entre dos límites DESDE , HASTA, ambos incluidos:
        rnd.nextInt(HASTA-DESDE+1)+DESDE*/

        //Por ejemplo, para generar 5 números aleatorios entre 10 y 20:

        for(int k = 1; k<=5; k++){
            System.out.println(r.nextInt(20-10+1)+10);
        }
    }
}
