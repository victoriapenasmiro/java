/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;
import static practica5Ejercicio2.Taxi.buscarTaxiLibre;
import static practica5Ejercicio2.Taxi.cambiarEstadoLibre;
import static practica5Ejercicio2.Vehiculo.buscarVehiculo;
import static practica5Ejercicio2.Vehiculo.mostrarVehiculos;

/**
 *
 * @author victoriapenas
 */
public class Practica5Ejercicio2 {
    
    public static void main(String[] args) {
        
        //contador de instancias
        int contador = 0;
        
        //contador para asignar una licencia de tres cifras de forma automática a los taxis
        int contadorLicencias = 99;
        
        //arrayList de vehiculos
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        
        //Empieza el programa
        mostrarMenu(vehiculos, contador, contadorLicencias);
    }
    
    public static void mostrarMenu(ArrayList<Vehiculo> vehiculos, int contador, int contadorLicencias){
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Dar de alta un taxi");
            System.out.println("2. Dar de alta un autobus");
            System.out.println("3. Dar de alta un VTC");
            System.out.println("4. Buscar un vehiculo");
            System.out.println("5. Buscar un taxi libre");
            System.out.println("6. Cambiar estado de un taxi a libre");
            System.out.println("7. Ver todos los vehiculos existentes");
            System.out.println("8. Salir");
            if (lector.hasNextInt()) {
                int opcion = lector.nextInt();
                switch (opcion) {
                    case 1:
                        Taxi nuevoTaxi = new Taxi();
                        //una vez añadido el taxi a la lista,
                        //le asigno el id en función del contador general
                        //y el codigo de licencia
                        if(vehiculos.add(nuevoTaxi.crearVehiculo())){
                            contador+=1;
                            contadorLicencias+=1;
                            nuevoTaxi.setId(contador);
                            nuevoTaxi.setLicencia(contadorLicencias);
                            System.out.println("El numero de licencia asignado"
                                    + " es el: " + nuevoTaxi.getLicencia());
                        }
                        break;
                    case 2:
                        Autobus nuevoBus = new Autobus();
                        if(vehiculos.add(nuevoBus.crearVehiculo())){
                            contador+=1;
                            nuevoBus.setId(contador);
                        }
                        break;
                    case 3:
                        VTC nuevoVTC = new VTC();
                        if(vehiculos.add(nuevoVTC.crearVehiculo())){
                            contador+=1;
                            nuevoVTC.setId(contador);
                        }
                        break;
                    case 4:
                        buscarVehiculo(vehiculos);
                        break;
                    case 5:
                        buscarTaxiLibre(vehiculos);
                        break;
                    case 6:
                        cambiarEstadoLibre(vehiculos);
                        break;
                    case 7:
                        mostrarVehiculos(vehiculos);
                        break;
                    case 8:
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
