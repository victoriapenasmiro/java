/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

/**
 *
 * @author victoriapenas
 */
public class incluyendoImagenes {
    public static void main(String[] args) {
        marcoImagen ventana = new marcoImagen();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class marcoImagen extends JFrame{

    public marcoImagen() {
        this.setTitle("Marco con imagen");
        this.setBounds(750, 300, 700, 400);
        LaminaConImagen lamina = new LaminaConImagen();
        this.add(lamina);
    }
}

class LaminaConImagen extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        Image imagen = null;
        super.paintComponent(g);
        
        try {
            imagen = ImageIO.read(new File("rentacar_logo_400.jpg"));
        } catch (IOException ex) {
            System.out.println("La imagen no se encuentra");
        }
        
        g.drawImage(imagen, 5, 5, null);
    }
}
