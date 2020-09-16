/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victoriapenas
 */
public class JTablev4 {
        
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://81.203.19.183:5432/rentacar", "Admin", "Admin123");
                PreparedStatement pst = con.prepareStatement("select * from clientes");ResultSet rs = pst.executeQuery();){
            JFrame mimarco = new JFrame();
            mimarco.setBounds(300, 300, 400, 200);
            mimarco.setVisible(true);
            JPanel lamina = new JPanel();
            
            DefaultTableModel modelo = new DefaultTableModel();
            
            // Creamos las columnas.
            modelo.addColumn("nif");
            modelo.addColumn("nombre");
            modelo.addColumn("apellido1");
            modelo.addColumn("apellido2");
            modelo.addColumn("telefono");
            modelo.addColumn("email");

            // Bucle para cada resultado en la consulta
            while (rs.next())
            {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[6]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i=0;i<6;i++)
                   fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
            JTable tabla = new JTable(modelo);
            lamina.add(new JScrollPane(tabla),BorderLayout.CENTER);
            mimarco.add(lamina,BorderLayout.CENTER);
            mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
