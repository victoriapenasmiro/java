/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author victoriapenas
 */
public class pintandoFiguras {
    public static void main(String[] args) {     
        Ventana miMarco = new Ventana();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Ventana extends JFrame{

    public Ventana() {
        this.setTitle("pintando figuras");
        this.setBounds(500, 500, 600, 450);
        Capa capa =new Capa();
        this.add(capa);
        /*Con esto doy un color a la lamina con el color por defecto que
        tienen las ventanas del sistema operativo*/
        capa.setBackground(SystemColor.window);
    }
    
}

class Capa extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //clase para dibujar figuras
        Graphics2D g2 = (Graphics2D) g; //recibe un objeto de tipo shape
        
        Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150); //creo el rectángulo
        //indico el color para las figuras que pintará g2
        g2.setPaint(Color.BLACK);//utilizo la constante BLACK de la clase color
        g2.draw(rectangulo); //pinto el contorno del rectangulo de negro
        g2.setPaint(Color.LIGHT_GRAY);
        g2.fill(rectangulo); //pinto el relleno del rectangulo de gris
        
        //creo una elipse
        Ellipse2D ellipse = new Ellipse2D.Double();
        g2.setPaint(new Color(134,122,0).brighter()); //con a clase Color puedo crear colores RGB.
        //Con el método brighter() aclaro el color, puedo poner tantas veces como quiera.
        //Con el metodo darker() hace el efecto contrario
        ellipse.setFrame(rectangulo);
        g2.fill(ellipse);
    }
}