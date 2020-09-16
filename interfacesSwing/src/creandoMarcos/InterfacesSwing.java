/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import javax.swing.*;

/**
 *
 * @author victoriapenas
 * @see https://www.youtube.com/watch?v=7q2VBGIKeYc&feature=youtu.be
 */
public class InterfacesSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        miMarco marco1 = new miMarco();
        marco1.setVisible(true); //hago visible la ventana. Este método podría estar en el contructor
        
        /*indico qué tiene que hacer la ventana al cerrarse. En este caso indico que
        cuando se cierre la ventana el programa tiene que acabar.
        
        EXIT_ON_CLOSE es una constante de la clase JFrame. Si tenemos 5 ventanas y se
        cierra la que tiene esta instrucción hace que se cierren todas las ventanas.*/
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Este método podría estar en el contructor
    }
    
}

class miMarco extends JFrame{

    public miMarco() {
        //setSize(500,300); //indicamos el alto y ancho que tendrá la ventana
        //setLocation(500,300); //establecemos la ubicacion de este frame en función de la ubicación padre, en este caso, la pantalla
        
        //con este método podemos crear la ventana indicando ubicación x, ubicación y, ancho y alto
        setBounds(500,300,550,250);
        
        //por defecto, se permiten redimensionar las ventanar con el ratón. Si ponemos false, no se permitirá hacerlo
        //setResizable(false);
        
        //Para forzar que el marco se abra a pantalla completa:
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        
        //Con esté método le damos un nombre a la ventana
        setTitle("Mi ventana");
    }
}