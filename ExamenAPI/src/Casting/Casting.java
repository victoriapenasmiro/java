/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casting;

/**
 *
 * @author victoriapenas
 * Un objeto es de la clase en que se instanció, pero también es
 * un objeto de todas sus superclases
 */
public class Casting{

    public static void main(String[] args) {
        
        Superclase superclase = new Superclase();
        superclase.mostrarAtributos(); // muestra el método de la superclase
        
        Subclase subclase = new Subclase();
        subclase.mostrarAtributos(); // muestra el método de la subclase
        
        ((Superclase)subclase).mostrarAtributos();/*a través del casting de objetos
        se comportará como vehículo, y por tanto, ejecutará el de la clase padre.*/

        
    }
    
}
