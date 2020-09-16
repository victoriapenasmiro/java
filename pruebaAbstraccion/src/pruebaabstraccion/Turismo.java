/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaabstraccion;

/**
 *
 * @author victoriapenas
 */
public class Turismo extends vehiculo{
    
    int cavallos;

    public Turismo() {
    }

    public Turismo(int cavallos, String matricula, int licencia) {
        super(matricula, licencia);
        this.cavallos = cavallos;
    }

    public Turismo(int cavallos) {
        this.cavallos = cavallos;
    }

    public int getCavallos() {
        return cavallos;
    }

    public void setCavallos(int cavallos) {
        this.cavallos = cavallos;
    }
    

    @Override
    public void mostrarAbstraccion(int i) {
        //este mensaje sale automáticamente para que salte en caso de que no se haya implementado
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
