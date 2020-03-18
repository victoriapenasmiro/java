/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.ArrayList;

/**
 *
 * @author victoriapenas
 */
public class Simulador {
    
    public static void main(String[] args) {
        
        //ArrayList de sorteos aleatorios
        ArrayList <Apuesta> apuestasAleatorias = new ArrayList();
        
        //ArrayList de sorteos de usuarios
        ArrayList <Apuesta> apuestasUsuarios = new ArrayList();
        
        try {
            SimulacionLoteria.mostrarMenu(apuestasUsuarios, apuestasAleatorias);
        } catch (ExceptionSimulador ex) {
            System.out.println(ex.getMensaje());
        }       
    }
}
