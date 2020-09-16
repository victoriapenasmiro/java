/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

/**
 *
 * @author victoriapenas
 */
public class extraerFuenteOrdenador {
    public static void main(String[] args) {
        //con la siguiente clase me pedira un valor
        String fuente = JOptionPane.showInputDialog("introduce fuente");
        
        boolean estalafuente = false;
        
        String [] nombreFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        for(String nombredelafuente:nombreFuentes){
            if (nombredelafuente.equals(fuente)){
                estalafuente = true;
            }
        }
        
        if (estalafuente){
            System.out.println("fuente instalada");
        }else{
            System.out.println("fuente no instalada");
        }
    }
}
