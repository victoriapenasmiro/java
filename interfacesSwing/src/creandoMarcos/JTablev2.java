/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author victoriapenas
 */
public class JTablev2 {
        public static void main(String[] args) {
            
            JFrame mimarco = new marcoTabla();
            mimarco.setVisible(true);
            mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class marcoTabla extends JFrame{
    
    private String [] nombreColumnas = {"nombre","radio","satelites","gaseoso"};
    private Object [][] datosFila = {
        {"Mercurio", 1440.0,0,false},
        {"Venus", 3440.0,0,false},
        {"Tierra", 4440.0,0,true},
        {"Saturno", 11440.0,0,false},
        {"Pluton", 1230.0,0,true},
        {"Neptunoo", 8440.0,0,false}
    };

    public marcoTabla() {
        this.setTitle("Los planetas");
        this.setBounds(300, 300, 400, 200);
        JTable tablaPlanetas = new JTable(datosFila,nombreColumnas);
        add(new JScrollPane(tablaPlanetas),BorderLayout.CENTER);
        JButton botonImprimir = new JButton("Imprimir tabla");
        
        botonImprimir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    tablaPlanetas.print();
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

            }
            
        });
        
        JPanel laminaboton = new JPanel();
        laminaboton.add(botonImprimir);
        add(laminaboton,BorderLayout.SOUTH);
    }
    
}