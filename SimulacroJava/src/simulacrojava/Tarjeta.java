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
public abstract class Tarjeta {
    private String NIF;
    private int PIN;
    private String nombre;
    private String apellido;

    public Tarjeta() {
    }

    public Tarjeta(String NIF, int PIN, String nombre, String apellido) {
        this.setNIF(NIF);
        this.setPIN(PIN);
        this.setNombre(nombre);
        this.setApellido(apellido);
    }
    
    public Tarjeta(Tarjeta tarjeta) {
        this.setNIF(tarjeta.getNIF());
        this.setPIN(tarjeta.getPIN());
        this.setNombre(tarjeta.getNombre());
        this.setApellido(tarjeta.getApellido());
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    //Crear un método abstract obliga a las hijas a que lo implementen implementerlo.
    public abstract boolean disminuirSaldoDisponible(int importe);
    
    public String mostrarTarjeta() {
        return "Tarjeta{" + "NIF=" + NIF + ", PIN=" + PIN + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
}
