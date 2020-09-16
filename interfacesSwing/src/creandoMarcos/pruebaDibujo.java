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
public class pruebaDibujo {
    public static void main(String[] args) {
        
        marcoconDibujos miMarco = new marcoconDibujos();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

class marcoconDibujos extends JFrame{

    public marcoconDibujos() {
        setTitle("Prueba de dibujo");
        setBounds(500,300,400,400);
        LaminaConFiguras miLamina = new LaminaConFiguras();
        add(miLamina); //agregamos la lamina a la ventana
   
    }
}

class LaminaConFiguras extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
        //g.drawRect(50, 50, 200, 200); //dibujamos un rectangulo de 200*200
        
        /*los dos primeros parámetros corresponden a x e y del punto inicial.
        Y los otros dos, x e y del punto final*/
        //g.drawLine(100, 100, 300, 200); //linea
        
        
        Graphics2D g2 = (Graphics2D) g; //objeto tipo shape
        Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150); //creo el rectángulo
        g2.draw(rectangulo); //pinto el rectangulo
        
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rectangulo);
        g2.draw(ellipse);
        
        g2.draw(new Line2D.Double(100,100,300,250));
        
        //a continuación dibujamos un circulo que engoble toda la figura
        double centroenX = rectangulo.getCenterX(); //almacenamos en centroenX el centro del rectángulo en Y
        double centroenY = rectangulo.getCenterY();
        
        double radio = 150;        
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroenX, centroenY, centroenX+radio, centroenY+radio);
        g2.draw(circulo);
        
    }
}