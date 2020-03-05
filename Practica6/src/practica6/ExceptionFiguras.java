/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

/**
 *
 * @author victoriapenas
 */
public class ExceptionFiguras extends Exception{

    @Override
    public String getMessage() {
        String mensajeError="Has entrado en el mensaje de error";
        return mensajeError;
    }

    //Quiero controlar que si el usuario pone 0 o negativo salte esta excepción. Puedo 
    public void controlarValor(){
        System.out.println("El valor introducido no puede ser 0 o negativo");
    }
            
    
}
