/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laescoba;

import Modelo.BarajaEspanyola;
import java.util.Collections;

/**
 *
 * @author victoriapenas
 * @version 1.0
 * @since July 2020
 * @see https://github.com/rgion/LaEscoba
 */
public class LaEscoba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //pruebas de baraja
        BarajaEspanyola baraja = new BarajaEspanyola();
        baraja.inicializarBaraja();
        
        /* Sorting in decreasing order*/
	Collections.sort(baraja.getCartasSinRepartir(), Collections.reverseOrder());
        for (int i = 0; i< baraja.getCartasSinRepartir().size();i++){
            System.out.print(baraja.getCartasSinRepartir().get(i) + ", ");
        }
    }
    
}
