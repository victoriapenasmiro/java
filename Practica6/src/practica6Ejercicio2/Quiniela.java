/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Quiniela extends Apuesta{
    private final int FILAS = 2;
    private final int COLUMNAS = 15;
    private char partidos [][];

    public Quiniela() {
        super();
    }

    public Quiniela(String nombre, String apellidos, char[][] partidos) throws ExceptionSimulador {
        super(nombre, apellidos);
        this.setPartidos(partidos);
    }

    public Quiniela(Apuesta nuevaApuesta) throws ExceptionSimulador {
        super(nuevaApuesta);
    }

    public char[][] getPartidos() {
        return partidos;
    }

    public void setPartidos(char[][] partidos) {
        if (partidos.length != COLUMNAS || partidos[0].length != FILAS){
            System.out.println("Debe haber 15 valores, uno para cada partido");
        }
        else{
            this.partidos = partidos;
        }
    }
    
    public static void crearApuestaQuiniela(int totalApuestas) throws ExceptionSimulador{
        Scanner lector = new Scanner(System.in);
        String nombre;
        String apellido;
        System.out.println("Dime tu nombre");
        nombre = lector.nextLine();
        System.out.println("Dime tu apellido");
        apellido = lector.nextLine();
        char valor;
        for (int i = 1;i<=totalApuestas;i++){
            Quiniela nuevaQuiniela = new Quiniela();
            nuevaQuiniela.setPartidos(new char [15][2]);
            nuevaQuiniela.setNombre(nombre);
            nuevaQuiniela.setApellidos(apellido);
            for (int j = 0;j<nuevaQuiniela.getPartidos().length;j++){
                for (int k = 0;k<nuevaQuiniela.getPartidos()[j].length;k++){
                    if (j == 0){
                        System.out.println("Dime el primer valor del partido: " + (j+1));
                        //cuando es un char tengo que poner este tipo de lector
                        valor = lector.next().charAt(0);
                        valor = verificarValor(valor);
                        nuevaQuiniela.getPartidos()[j][k] = valor;
                    }
                    else{
                        System.out.println("Dime otro");
                        valor = lector.next().charAt(0);
                        valor = verificarValor(valor);
                        nuevaQuiniela.getPartidos()[j][k] = valor;
                    }
                }
            }
        }
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
    
}
