/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacrojava;

import java.util.Scanner;
/**
 *
 * @author victoriapenas
 */
public class SimulacroJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[][] carga_billetes = {{500, 10}, {200, 0}, {100, 0}, {50, 27},
        {20, 0}, {10, 18}, {5, 25}};
        
        CajeroAutomatico micajero = new CajeroAutomatico();
        
        micajero.setListaBilletes(carga_billetes);
        
        TarjetaDebito mitarj1 = new TarjetaDebito("33888999m", 1111, "Jorge",
        "Lorenzo", 20000);

        TarjetaCredito mitarj2 = new TarjetaCredito("34888999m", 2222, "Rafa",
        "Nadal", 1000, 5000);
        
        micajero.addTarjeta(mitarj1);//añade una tarjeta a la lista de tarjetas
        micajero.addTarjeta(mitarj2);
        
        TarjetaCredito mitarj3 = new TarjetaCredito(mitarj2); //copiamos con constructor copia
        
        //empieza el programa
        mostrarMenu(micajero);

    }
    
    public static void mostrarMenu(CajeroAutomatico micajero){
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("Los billetes disponibles son:");
            micajero.mostrarCajero();
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Sacar dinero");
            System.out.println("2. Salir");
            int opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        micajero.sacarDinero();
                    } catch (ExcepcionCajero ex) {
                        System.out.println(ex.getMensaje());
                    }
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("La opción indicada no es correcta,"
                            + "por favor, indica otra.");
            }
        } while (exit == false); 
    }
}
