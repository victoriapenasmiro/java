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
    private char partidos [];
    private int aciertos = 0;//to do getters i setters

    public Quiniela() {
        super();
    }

    public Quiniela(String nombre, String apellidos, char[] partidos) throws ExceptionSimulador {
        super(nombre, apellidos);
        this.setPartidos(partidos);
    }

    public Quiniela(Apuesta nuevaApuesta) throws ExceptionSimulador {
        super(nuevaApuesta);
    }

    public char[] getPartidos() {
        return partidos;
    }

    public void setPartidos(char [] partidos) {
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
    
    public char [] crearApuestaQuiniela() throws ExceptionSimulador{
        Scanner lector = new Scanner(System.in);
        /*solo pido el nombre una vez, si el objeto que llama a esta función
        ya existe, no le vuelvo a pedir su nombre*/
        if (this.getNombre() == null){
            super.pedirNombre();
        }
        char valor = 0;
        this.setPartidos(new char [15]);
        for (int j = 0;j<this.getPartidos().length;j++){
            System.out.println("Dame un valor para el partido: " + (j+1));
            //cuando es un char tengo que poner este tipo de lector
            valor = lector.next().charAt(0);
            valor = verificarValor(valor);
            this.getPartidos()[j] = valor;
        }
        System.out.println(this.mostrarApuesta());
        
        return this.getPartidos();
    }
    
    public static char verificarValor(char valor){
        Scanner lector = new Scanner (System.in);
        while (valor != '1' && valor != '2' && valor != 'x' && valor != 'X'){
            System.out.println("El valor introducido no es correcto. Solo pueden ser los siguientes:"
                    + "1 (gana el equipo de casa), x (empate) y 2 (gana el de fuera). Dime uno valido:");
            valor = lector.nextLine().charAt(0);
        }
        return valor;
    }

    //con el metodo arrays.toString imprime el valor de la matriz
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
    
        //no puedo hacer abstract en la clase apuesta porque el tipo de dato guardado en la matriz es diferente para primitiva y quiniela
    public boolean comprobarAciertos(ArrayList <char []> quinielasAleatorias, char [] apuesta){
        boolean acierto = false;
        int aux=0;//incremental while
        int aux2;//incremental auxiliar
        while (acierto == false && aux<quinielasAleatorias.size()){
            aux2 = 0;
            //mientras los valores coincidan ejecuta
            while(quinielasAleatorias.get(aux)[aux2] == apuesta[aux2] && aux2<apuesta.length){
                /*si nos encontramos en la ultima posicion de la array y los valores
                son los mismos es que hay un acierto*/
                if (quinielasAleatorias.get(aux).length-1 == aux2 && quinielasAleatorias.get(aux).length-1 == apuesta.length-1){
                    acierto = true;
                }
                aux2++;
            }
            if(!acierto){
                aux++;
            }
        }
        return acierto;
    }
}
