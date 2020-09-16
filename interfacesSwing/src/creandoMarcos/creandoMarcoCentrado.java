/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.*;
import static java.awt.Toolkit.getDefaultToolkit;
import javax.swing.*;

/**
 *
 * @author victoriapenas
 */
public class creandoMarcoCentrado {
    public static void main(String[] args) {
        marcoCentrado miMarco = new marcoCentrado();
        
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class marcoCentrado extends JFrame{

    public marcoCentrado() {
        
        //obtenemos la resolución de la pantalla que ejecuta el programa
        Toolkit miPantalla = getDefaultToolkit();
        
        Dimension medidaPantalla = miPantalla.getScreenSize();
        
        int alturaPantalla = medidaPantalla.height;
        int anchoPantalla = medidaPantalla.width;
        
        /*doy un tamaña a la ventana que se corresponde con la mitad del alto y del ancho
        del monitor que está abriendo el programa*/
        setSize(anchoPantalla/2,alturaPantalla/2);
        
        /*Colocamos la ventana en el centro del monitor. Para hacerlo, como la ventana,
        por defecto, se situa en la esquina superior izquierda, divimos la pantalla en cuartos,
        de forma que la esquina superior izquierda de la pantalla se situe en un cuarto y como ocupa la mitad,
        es decir, dos cuartos, quedará centrado.*/
        setLocation(anchoPantalla/4,alturaPantalla/4);
        
        setTitle("marco centrado");
        
        /*ponemos un icono a la ventana. A TENER EN CUENTA: MAC no soporta estos métodos, por lo que no se
        ven los iconos. Más info en:
        https://stackoverflow.com/questions/23378119/setimageicon-doesnt-set-jframe-icon-on-mac-swing-window*/
        Image icono = miPantalla.getImage("facebook.png");
        setIconImage(icono);
        
    } 
    
}