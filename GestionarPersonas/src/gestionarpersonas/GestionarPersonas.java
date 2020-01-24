/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpersonas;

/**
 *
 * @author victoriapenas
 */
public class GestionarPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*cuando vamos a utilizar un constructor, si hacemos ctrl+space
        dentro del parentesis nos da ayuda*/
        //Persona adrian=new Persona("adrian","apellido1","apellido2",18,"x111111111");
        //Persona copia=new Persona(adrian);
        /*haciendo esta copia creamos dos objetos iguales con su propia referencia.*/
        Persona user=new Persona();
        user.solicitarDatos();
        user.mostrarAtributos();

    }
    
}
