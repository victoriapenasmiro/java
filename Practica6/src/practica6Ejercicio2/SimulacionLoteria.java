/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static practica6Ejercicio2.Primitiva.crearApuestaPrimitiva;
import static practica6Ejercicio2.Quiniela.crearApuestaQuiniela;

/**
 *
 * @author victoriapenas
 */
public class SimulacionLoteria {
    
    public static void mostrarMenu() throws ExceptionSimulador{
        Scanner lector = new Scanner(System.in);
        int opcion;
        int totalApuestas;
        boolean exit = false;
        do{
            System.out.println("============MENU=============");
            System.out.println("1) crear apuesta Primitiva");
            System.out.println("2) crear apuesta Quiniela");
            System.out.println("3) realizar simulación");
            System.out.println("4) salir");
            System.out.println("¿Qué opción deseas?");
            opcion = lector.nextInt();
            System.out.println("¿Cuántas apuestas quieres realizar?");
            totalApuestas = lector.nextInt();
            switch (opcion){
                case 1:
                    crearApuestaPrimitiva(totalApuestas);
                    break;
                case 2:
                    crearApuestaQuiniela(totalApuestas);
                    break;
                case 3:
                    realizarSimulacion();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("La opción indicada no es correcta.");
            }
        } while (exit == false);
    }
    
    public static void realizarSimulacion(){
        Scanner lector = new Scanner (System.in);
        Random r = new Random();
        ArrayList <Apuesta> apuestasAleatorias = new ArrayList<Apuesta>();
        int totalPrimitivas;
        int totalQuinielas;
        char [] valoresQuiniela = {'1','2','x'};
        System.out.println("¿Cuántas primitivas quieres simular");
        totalPrimitivas = lector.nextInt();
        System.out.println("¿Cuántas quinielas quieres simular");
        totalQuinielas = lector.nextInt();
        
        //genero las primitivas
        for(int i = 0;i<totalPrimitivas;i++){
            Primitiva nuevaPrimitiva = new Primitiva();
            for(int j = 0; j<nuevaPrimitiva.getListaNum().length;j++){
                nuevaPrimitiva.getListaNum()[j] = r.nextInt(49)+1;//genero enteros entre 1 y 49:
            }
            apuestasAleatorias.add(nuevaPrimitiva);
        }
        
        //genero las quinielas
        for(int i = 0;i<totalQuinielas;i++){
            Quiniela nuevaQuiniela = new Quiniela();
            nuevaQuiniela.setPartidos(new char [15][2]);
            for(int j = 0; j<nuevaQuiniela.getPartidos().length;j++){
                for(int k = 0; k<nuevaQuiniela.getPartidos()[j].length;k++){
                    /*la siguiente solucion es válida pero no optima
                    //uso la tabla de caracteres ASCII para obtener las letras a
                    //partir de la conversión de números enteros a caracteres.
                    // Con esta instrucción se genera un número aleatorio entre
                    // 49 y 88. Luego se convierte a un caracter ASCII.
                    nuevaQuiniela.getPartidos()[j][k] = nuevaQuiniela.getPartidos()[j+1][(char)r.nextInt(88)+49];
                    //mientras no me de un valor valido, sigo sacando aleatorios
                    while (nuevaQuiniela.getPartidos()[j][k] != '1' ||
                            nuevaQuiniela.getPartidos()[j][k] != '2' || nuevaQuiniela.getPartidos()[j][k] != 'X'){
                        nuevaQuiniela.getPartidos()[j][k] = nuevaQuiniela.getPartidos()[j+1][(char)r.nextInt(88)+49];
                    }   */
                    //mejor opcion:
                    nuevaQuiniela.getPartidos()[j][k] = nuevaQuiniela.getPartidos()[j+1][getRandom(valoresQuiniela)];
                    
                }
            apuestasAleatorias.add(nuevaQuiniela);
            
            }
        }
    }
    
    //saco aleatorios de los valores posibles de quiniela
    public static char getRandom(char[] valoresQuiniela) {
        int rnd = new Random().nextInt(valoresQuiniela.length);
        return valoresQuiniela[rnd];
    }
}
