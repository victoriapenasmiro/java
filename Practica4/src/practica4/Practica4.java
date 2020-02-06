/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.ArrayList;
import java.util.Scanner;
import static practica4.Pelicula.addPelicula;
import static practica4.Pelicula.buscarPelicula;
import static practica4.Pelicula.reservarPelicula;

/**
 *
 * @author victoriapenas
 * Gestión de un Videoclub
 */
public class Practica4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // declaro un arrayList para almacenar las películas
        ArrayList <Pelicula> Peliculas = new ArrayList <Pelicula>();
        
        //constantes
        final int limitePeliculas = 3000;
        
        //empieza el programa
        mostrarMenu(Peliculas, limitePeliculas);
        
    }
    
    public static void mostrarMenu(ArrayList <Pelicula> Peliculas, int limitePeliculas){
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Añadir Película");
            System.out.println("2. Reservar Pelicula");
            System.out.println("3. Buscar Pelicula");
            if(lector.hasNextInt()){
            int opcion = lector.nextInt();
            switch(opcion){
                case 1:
                    addPelicula(Peliculas,limitePeliculas);
                    break;
                case 2:
                    reservarPelicula(Peliculas);
                    break;
                case 3:
                    buscarPelicula(Peliculas);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("La opción indicada no es correcta,"
                            + "por favor, indica otra.");
                }
            }
            else{
                lector.nextLine();
                System.out.println("la opcion indicada no es válida. Por favor,"
                    + " escoge una opción del menu");
            }
        }while (exit == false);
        }
}
