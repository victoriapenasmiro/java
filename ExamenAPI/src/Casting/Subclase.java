/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casting;

/**
 *
 * @author victoriapenas
 */
public class Subclase extends Superclase{
    private int numRuedas;

    public Subclase() {
    }

    public Subclase(int numRuedas) {
        this.numRuedas = numRuedas;
    }
    
    public Subclase(Subclase s1) {
        super((Superclase)s1);
        this.setNumRuedas(s1.getNumRuedas());
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }
    
    @Override //sobreescribo el metodo del padre. tienen la misma firma
    public String mostrarAtributos(){
        System.out.println(super.mostrarAtributos());//invoco al metodo del padre
        return "Subclase{" + "numRuedas=" + numRuedas + '}';
    }
    
}
