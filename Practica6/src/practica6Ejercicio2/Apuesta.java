/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.concurrent.atomic.AtomicInteger;
import static practica6Ejercicio2.Simulador.mostrarMenu;

/**
 *
 * @author victoriapenas
 */
public class Apuesta {
    //atributos
    private String nombre;
    private String apellidos;
    //Lo creamos static para que el programa recuerde el valor de la ultima
    //instancia y final para que no se pueda modificar el valor.
    private static final AtomicInteger numApuesta = new AtomicInteger(100);

    //constructores
    public Apuesta() {
        this.getNumApuesta().incrementAndGet();
    }

    public Apuesta(String nombre, String apellidos) {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.getNumApuesta().incrementAndGet();
    }

    public Apuesta(Apuesta nuevaApuesta) {
        this.setNombre(nuevaApuesta.getNombre());
        this.setApellidos(nuevaApuesta.getApellidos());
        this.setNumApuesta(nuevaApuesta.getNumApuesta());
    }
    
    //getters i setters
    public String getNombre() {
        return nombre;
    }

    //TO DO ¿es correcto este formato?
    public void setNombre(String nombre) throws ExceptionSimulador {
        if (this.nombre != this.nombre.toUpperCase()){
  
            throw new ExceptionSimulador();

            }
        
        else{
            this.nombre = nombre;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public AtomicInteger getNumApuesta() {
        return numApuesta;
    }

    public void setNumApuesta(AtomicInteger numApuesta) {
        numApuesta.incrementAndGet();
    }
    
    //utilizo el método toString y cambio el nombre
    public String mostrarApuesta() {
        return "Apuesta{" + "nombre=" + nombre + ", apellidos=" + apellidos
                + ", numApuesta=" + numApuesta + '}';
    }

}
