/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creandoMarcos;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author victoriapenas
 */
public class JTablev3 {
    public static void main(String[] args) {

    JFrame mimarco = new marcoTablaPersonalizado();
    mimarco.setVisible(true);
    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class marcoTablaPersonalizado extends JFrame{

    public marcoTablaPersonalizado() {
        this.setTitle("Tabla personalizada");
        this.setBounds(300, 300, 400, 200);
        TableModel newmodelo = new modeloTablaPeronalizada();
        JTable mitabla = new JTable(newmodelo);
        
        add(new JScrollPane(mitabla));
    }  
}


class modeloTablaPeronalizada extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int z = rowIndex + 1;
        int y = columnIndex + 2;
        
        return " " + z + " " + y;
    }
    
    @Override
    public String getColumnName (int c){
        return "Columna " + c;
    }
    
}