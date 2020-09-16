/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author victoriapenas
 */
public class escribiendoenMarcos {
    public static void main(String[] args) {
        
       marcoConTexto miMarco = new marcoConTexto();
       miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcoConTexto extends JFrame{

    public marcoConTexto() {
        setVisible(true);
        setSize(600,450);
        setLocation(400,200);
        setTitle("Primer texto");
        Lamina miLamina = new Lamina();
        add(miLamina); //con este método añadimos la lamina al marco
        //El siguiente método hace que todo lo que se escriba sea en el mismo color
        //miLamina.setForeground(Color.BLUE);
    }
}

/**
 * esta clase la utilizaremos para crear laminas donde pintaremos los diferentes
 * elementos en las ventanas.
 * @author victoriapenas
 */
class Lamina extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);        
        Graphics2D g2 = (Graphics2D) g;
        Font mifuente = new Font("Curier",Font.BOLD,26); //creo un tipo de letra
        g2.setFont(mifuente);
        g2.setColor(Color.RED);//indico el color de la letra
        g2.drawString("estamos aprendiendo swing", 100, 100); //con este metodo escribo texto en la posicion indicada
        
        
        //creamos otra fuente
        
        g2.setFont(new Font ("Arial",Font.ITALIC,18));
        g2.setColor(new Color(0,222,211).darker());//con el metodo darker pongo el color más ocuro
        g2.drawString("estamos aprendiendo swing", 100, 200);


    }
}