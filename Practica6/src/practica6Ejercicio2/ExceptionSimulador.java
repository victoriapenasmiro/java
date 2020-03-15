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
    private int codError;

    public ExceptionSimulador(int codError) {
        if (codError == 101){
            this.setMensaje("el nombre debe estar en mayúsculas. Intentalo de nuevo");
        }
        else if(codError == 102){
            this.setMensaje("el apellido debe estar en mayúsculas. Intentalo de nuevo");         
        }
        else if(codError == 300){
            this.setMensaje("El valor indicado no es válido. Intentalo de nuevo");         
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodError() {
        return codError;
    }

    public void setCodError(int codError) {
        this.codError = codError;
    }
        
}
