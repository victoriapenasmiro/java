/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author victoriapenas
 */
public abstract class Apuesta {
    //atributos
    private String nombre;
    private String apellidos;
    private int numApuesta;
    //Lo creamos static para que el programa recuerde el valor de la ultima
    //instancia y final para que no se pueda modificar el valor.
    private static final AtomicInteger incrementalApuesta = new AtomicInteger(99);

    //constructores
    public Apuesta() {
        this.setNumApuesta(getIncrementalApuesta().incrementAndGet());
    }

    public Apuesta(String nombre, String apellidos) throws ExceptionSimulador {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        //no recibe por parametro el num de apuesta, lo incremento automaticamente
        this.setNumApuesta(getIncrementalApuesta().incrementAndGet());
    }

    public Apuesta(Apuesta nuevaApuesta) throws ExceptionSimulador {
        this.setNombre(nuevaApuesta.getNombre());
        this.setApellidos(nuevaApuesta.getApellidos());
        this.setNumApuesta(nuevaApuesta.getNumApuesta());
    }
    
    //getters i setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ExceptionSimulador {
        if (nombre != nombre.toUpperCase()){  
            throw new ExceptionSimulador();
        }
        else{
            this.nombre = nombre;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) throws ExceptionSimulador {
        if (apellidos != apellidos.toUpperCase()){  
            throw new ExceptionSimulador();
        }
        else{
            this.apellidos = apellidos;
        }
    }

    public int getNumApuesta() {
        return numApuesta;
    }

    public void setNumApuesta(int numApuesta) {
        this.numApuesta = numApuesta;
    }

    public static AtomicInteger getIncrementalApuesta() {
        return incrementalApuesta;
    }
    
    //utilizo el método toString y cambio el nombre
    public String mostrarApuesta() {
        return "Apuesta{" + "nombre=" + nombre + ", apellidos=" + apellidos
                + ", numApuesta=" + numApuesta + '}';
    }
    
}
