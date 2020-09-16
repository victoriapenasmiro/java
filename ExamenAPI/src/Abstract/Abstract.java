/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;

/**
 *
 * Una clase de la que no se tiene intención de crear objetos, sino que únicamente
 * sirve para unificar datos u operaciones de subclases, puede declararse de
 * forma especial en Java: como clase abstracta.
 */
public abstract class Abstract {
    private String nombre;
    private int telefono;

    /*Los métodos abstract son de obligada implementacion en las subclases.
    El código debe especificarse en la subclase.
    Sólo pueden existir dentro de una clase abstracta.*/
    public abstract String mostrarAtributos();
        
}
