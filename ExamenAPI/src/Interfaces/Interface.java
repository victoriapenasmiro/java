/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author victoriapenas
 * Una interfaz es una clase completamente abstracta, es decir, sin implementación.
 * Se pueden declarar atributos que deben llevar las palabras reservadas static final
 * y con un valor inicial ya que funcionan como constantes por lo que, por convención,
 * su nombre va en mayúsculas.
 * Sus métodos que los hijos tendrán que implementar obligatoriamente.
 */
public interface Interface {
    static final int id = 0;
    
    public double calcularVolumen();
    
    public double calcularArea(double altura, double base);
    
    public static void kaka(){
        
    }
}
