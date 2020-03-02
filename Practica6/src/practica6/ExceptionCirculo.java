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
public class ExceptionCirculo extends Exception{

    @Override
    public String getMessage() {
        String mensajeError="Has entrado en el mensaje de error";
        return mensajeError;
    }
    
}
