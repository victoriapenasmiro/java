/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 * Desarrolla un programa que diferentes cálculos para distintas figuras
 * figuras geométricas (al menos 4). Apoyándote en lo que hemos aprendido,
 * utiliza las interfaces para definir la necesidad de tener implementados
 * los métodos:
 */
public class Practica6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            mostrarMenu();
        } catch (Exception ex) {
            System.out.println("Se ha producido un error, por favor, inténtalo de nuevo");
        }

    }
    
    public static void mostrarMenu() throws Exception{
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("¿Qué figura te interesa?");
            System.out.println("1. Circulo o esfera");
            System.out.println("2. Cuadrado o Cubo");
            System.out.println("3. Triángulo o Pirámide");
            System.out.println("4. Cilindro");
            System.out.println("5. Salir");
            if (lector.hasNextInt()) {
                int opcion = lector.nextInt();
                switch (opcion) {
                    case 1:
                        new Circulo().mostrarMenu();
                        break;
                    case 2:
                        new Cuadrado().mostrarMenu();
                        break;
                    case 3:
                        new TrianguloPiramide().mostrarMenu();
                        break;
                    case 4:
                        new Cilindro().mostrarMenu();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("La opción indicada no es correcta,"
                                + "por favor, indica otra.");
                }             
            } else {
                lector.nextLine();
                System.out.println("la opcion indicada no es válida. Por favor,"
                        + " escoge una opción del menu");
            }
        } while (exit == false);  
    }   
}
