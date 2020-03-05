/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

/**
 *
 * @author victoriapenas
 */
public class ExceptionSimulador extends Exception{
    private String mensaje;

    public ExceptionSimulador() {
        this.setMensaje("el nombre debe estar en mayúsculas");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
