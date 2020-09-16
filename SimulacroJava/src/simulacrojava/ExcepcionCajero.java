/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacrojava;

/**
 *
 * @author victoriapenas
 */
public class ExcepcionCajero extends Exception{
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public ExcepcionCajero(int importe) {
        mensaje = "Actualmente el cajero no dispone de efectivo "
                + "suficiente para satisfacer la cantidad de " + importe +
                " de su tarjeta.";
        this.setMensaje(mensaje);
    }
    
}
