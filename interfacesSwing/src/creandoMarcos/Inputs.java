/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * me quedo por el video 89
 * @author victoriapenas
 */
public class Inputs {
    public static void main(String[] args) {
        marcoTexto m1 = new marcoTexto();
        m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class marcoTexto extends JFrame{

    public marcoTexto() {
        setBounds(600,300,600,350);
        setTitle("Primer texto");
        LaminaTexto miLamina = new LaminaTexto();
        add(miLamina);
        setVisible(true);
    }
}

/**
 * @author victoriapenas
 */
class LaminaTexto extends JPanel{

    private JTextField campo1;
    private JLabel resultado;
    
    public LaminaTexto() {
        this.setLayout(new BorderLayout()); //la lamina principal tendrá este diseño
        JPanel milamina2 = new JPanel();
        milamina2.setLayout(new FlowLayout()); // la lamina secundario tendrá este diseño
        resultado = new JLabel("",JLabel.CENTER); // alineo la etiqueta en el centro
        JLabel label = new JLabel("Introduce tu nombre:");
        milamina2.add(label);
        campo1 = new JTextField(15);
        milamina2.add(campo1);
        this.add(resultado,BorderLayout.CENTER);
        JButton miboton = new JButton ("Enviar");
        DameTexto mievento = new DameTexto();
        miboton.addActionListener(mievento);
        milamina2.add(miboton);
        
        add(milamina2,BorderLayout.NORTH);//coloco la lamina dos en el top de la lamina principal
    }

    private class DameTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(campo1.getText().trim());
            //aqui hariamos el insert en la bbdd
            if (campo1.getText().trim().isEmpty() || campo1.getText().trim() == null){
                resultado.setText("Por favor, rellena todos los datos");
            }else{
                resultado.setText("Usuario creado correctamente"); //añado a la label el valor
            }
        }
    
    }
}