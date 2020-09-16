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
public class Superclase {
    private String marca;
    private int modelo;

    public Superclase() {
    }

    public Superclase(String marca, int modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public Superclase(Superclase s1) {
        this.marca = s1.marca;
        this.modelo = s1.modelo;
    }
    
    public String mostrarAtributos() {
        return "Superclase{" + "marca=" + marca + ", modelo=" + modelo + '}';
    }
}
