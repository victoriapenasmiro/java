/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;

/**
 *
 * @author victoriapenas
 */
//podemos prohibir que se creen nuevas subclases de esta clase con final
final public class subclase extends Abstract {

    //tengo que implementar los métodos abstract de la clase padre obligatoriamente
    @Override
    public String mostrarAtributos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
