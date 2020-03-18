/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.ArrayList;
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
        if (!nombre.equals(nombre.toUpperCase())){  
            throw new ExceptionSimulador(101);
        }
        else{
            this.nombre = nombre;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) throws ExceptionSimulador {
        if (!apellidos.equals(apellidos.toUpperCase())){  
            throw new ExceptionSimulador(102);
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
    
    public Apuesta pedirNombre() throws ExceptionSimulador{
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime tu nombre");
        this.setNombre(lector.nextLine());
        System.out.println("Dime tu apellido");
        this.setApellidos(lector.nextLine());
        
        return this;
    }
    
    public boolean comprobarAciertos(ArrayList <Apuesta> apuestasUsuario, int [] apuesta){
        boolean acierto = false;
        boolean salir = false;
        int aux;//incremental while
        for (int i = 0; i<apuestasUsuario.size();i++){
            aux = 0;//reseteo el contador en cada comienzo
            salir = false;//reseteo la auxiliar para la nueva apuesta
            if(apuestasUsuario.get(i) instanceof Primitiva){
                while (salir == false && ((Primitiva)apuestasUsuario.get(i)).getListaNum()[aux] == apuesta[aux]
                    && aux<((Primitiva)apuestasUsuario.get(i)).getListaNum().length){
                
                    if (((Primitiva)apuestasUsuario.get(i)).getListaNum().length-1 == aux){
                        //Si llego a la última posicion es que todos los números coinciden. Actualizo lo aciertos
                        ((Primitiva)apuestasUsuario.get(i)).setAciertos(((Primitiva)apuestasUsuario.get(i)).getAciertos() + 1);
                        acierto = true;
                        salir = true;
                    }
                    else{
                        aux++;
                    }
                }
            }
            else if(apuestasUsuario.get(i) instanceof Quiniela){
                while (salir == false && ((Quiniela)apuestasUsuario.get(i)).getPartidos()[aux] == apuesta[aux]
                    && aux<((Quiniela)apuestasUsuario.get(i)).getPartidos().length){
                
                    if (((Quiniela)apuestasUsuario.get(i)).getPartidos().length-1 == aux){
                        //Si llego a la última posicion es que todos los números coinciden. Actualizo lo aciertos
                        ((Quiniela)apuestasUsuario.get(i)).setAciertos(((Quiniela)apuestasUsuario.get(i)).getAciertos() + 1);
                        acierto = true;
                        salir = true;
                    }
                    else{
                        aux++;
                    }
                }
            }
        }
        return acierto;
    
    }
}
