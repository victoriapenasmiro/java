/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Quiniela extends Apuesta{
    private final int COLUMNAS = 15;
    private int partidos [];
    private int aciertos = 0;

    public Quiniela() {
        super();
    }

    public Quiniela(String nombre, String apellidos, int[] partidos) throws ExceptionSimulador {
        super(nombre, apellidos);
        this.setPartidos(partidos);
    }

    public Quiniela(Apuesta nuevaApuesta) throws ExceptionSimulador {
        super(nuevaApuesta);
    }

    public int[] getPartidos() {
        return partidos;
    }

    public void setPartidos(int[] partidos) {
        if (partidos.length != COLUMNAS){
            System.out.println("Debe haber 15 valores, uno para cada partido");
        }
        else{
            this.partidos = partidos;
        }
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
    
    public Apuesta crearApuestaQuiniela(ArrayList <Apuesta> apuestasUsuarios)
            throws ExceptionSimulador{
        Scanner lector = new Scanner(System.in);
        char valor = 0; //la inicializo vacía
        int valorCorrecto;
        /*solo pido el nombre una vez, si el objeto que llama a esta función
        ya existe, no le vuelvo a pedir su nombre*/
        if (this.getNombre() == null){
            super.pedirNombre();
        }
        this.setPartidos(new int [15]);
        for (int j = 0;j<this.getPartidos().length;j++){
            System.out.println("Dame un valor para el partido: " + (j+1));
            //leo char para que el usuario me indique los empates con 'x' pero almaceno int.
            valor = lector.next().charAt(0);
            valorCorrecto = verificarValor(valor);
            while (valorCorrecto == 3){
                valor = lector.next().charAt(0);
                valorCorrecto = verificarValor(valor);
            }
            //lo pongo fuera del try para que se ejecute si entra en el catch
            this.getPartidos()[j] = valorCorrecto;
        }
        System.out.println(this.mostrarApuesta());
        
        return this;
    }
    
    public static int verificarValor(char valor){
        int valorConvertido = 0;
        if(valor == 'x' || valor =='X'){
            valorConvertido = 0;
        }
        else if(valor == '1'){
            valorConvertido = 1;
        }
        else if(valor == '2'){
            valorConvertido = 2;
        }
        else{
            System.out.println("El valor introducido no es correcto. Solo pueden ser los siguientes:"
            + "1 (gana el equipo de casa), x (empate) y 2 (gana el de fuera). Dime uno valido:");
            valorConvertido = 3; //el 3 indica que el valor indicado no es valido
        }
        return valorConvertido;
    }

    //con el metodo arrays.toString imprime el valor de la array
    @Override
    public String mostrarApuesta() {
        return super.mostrarApuesta() + "Quiniela{" + "partidos=" + Arrays.toString(this.getPartidos()) + '}';
    }
    
    //habia pensado en hacer un metodo abstract en Apuesta, pero como este metodo es static no puedo hacerlo.
    public static int pedirCantidadQuinielas(){
        Scanner lector = new Scanner (System.in);
        int totalQuinielas;
        totalQuinielas = lector.nextInt();
        return totalQuinielas;
    }        
}
