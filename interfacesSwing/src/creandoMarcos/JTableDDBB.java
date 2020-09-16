/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author victoriapenas
 */
public class JTableDDBB {
    
    public static void main(String[] args) {
        JFrame mimarco = new marcoClientes();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcoClientes extends JFrame{

    private JComboBox nombreTablas;
    private DatabaseMetaData datosBBDD;
    private ResultSet rs;
    private Connection con;
    private PreparedStatement pst;
    private ResulsetModeloTabla modelo;
    
    public marcoClientes() {
        this.setTitle("Tabla personalizada");
        this.setBounds(300, 300, 400, 200);
        JPanel superior = new JPanel();
        nombreTablas = new JComboBox();
        try{
            con = DriverManager.getConnection("jdbc:postgresql://81.203.19.183:5432/rentacar", "Admin", "Admin123");
            datosBBDD = con.getMetaData();
            rs = datosBBDD.getTables("rentacar","public",null,new String[]{"TABLE"});//DB, SCHEMA, NOMBRETABLA, RECUPERAMOS SOLO TABLAS
            while(rs.next()){
                nombreTablas.addItem(rs.getString("TABLE_NAME"));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        nombreTablas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tablaSeleccionada = (String) nombreTablas.getSelectedItem();
                String consulta = "select * from " + tablaSeleccionada;
                try {
                    //es necesario utilizar el siguiente constructor de pst para que se pueda ejecutar la query en la JTable
                    pst = con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_UPDATABLE);
                    rs = pst.executeQuery();
                    modelo = new ResulsetModeloTabla(rs);
                    JTable tabla = new JTable(modelo);
                    add(new JScrollPane(tabla),BorderLayout.CENTER);
                    validate();//no tengo claro para que funciona esto
                    
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        
        });
        superior.add(nombreTablas);
        add(superior,BorderLayout.NORTH);
    }  
}

class ResulsetModeloTabla extends AbstractTableModel{
    
    private ResultSet rsRegistros;
    private ResultSetMetaData rsmd;

    public ResulsetModeloTabla(ResultSet rs) {
        rsRegistros = rs;
        try {
            rsmd = rs.getMetaData();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getRowCount() {
        try {
            rsRegistros.last(); //movemos el cursor al final y de esa forma obtenemos el total de filas que hay
            return rsRegistros.getRow(); //devolvemos la posición de la ultima fila
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rsRegistros.absolute(rowIndex+1);
            return rsRegistros.getObject(columnIndex+1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String getColumnName(int c){
        try {
            return rsmd.getColumnName(c+1);
        } catch (SQLException ex) {
            return null;
        }
        
    }

}