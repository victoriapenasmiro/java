/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author victoriapenas Práctica 5 - Herencia y polimorfismo
 *
 */
public class Practica5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // declaro un arrayList para almacenar los empleados
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        
        //Empieza el programa
        mostrarMenu(empleados);

    }

    public static void mostrarMenu(ArrayList <Empleado> empleados) {
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Añadir nuevo empleado");
            System.out.println("2. Añadir nuevo Comercial");
            System.out.println("3. Añadir nuevo Repartidor");
            System.out.println("4. Ver los atributos de los empleados");
            System.out.println("5. Ver los atributos de los comerciales");
            System.out.println("6. Ver los atributos de los repartidores");
            System.out.println("7. Salir");
            if (lector.hasNextInt()) {
                int opcion = lector.nextInt();
                switch (opcion) {
                    case 1:
                        empleados.add(new Empleado().pedirAlta());
                        break;
                    case 2:
                        empleados.add(new Comercial().pedirAlta());
                        break;
                    case 3:
                        empleados.add(new Repartidor().pedirAlta());
                        break;
                    case 4:
                        opcion = 1;
                        mostrarDatos (empleados,opcion);
                        break;
                    case 5:
                        opcion = 2;
                        mostrarDatos (empleados,opcion);
                        break;
                    case 6:
                        opcion = 3;
                        mostrarDatos (empleados,opcion);
                        break;
                    case 7:
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
    
    public static void mostrarDatos (ArrayList <Empleado> empleados, int opcion){
        int j = 0; //aux para el while
        int vueltas = 0; //contador para el while
        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados");
        }
        else{
            switch (opcion) {
                case 1:
                    for (int i=0; i<empleados.size();i++){
                        if(!(empleados.get(i) instanceof Comercial) &&
                            !(empleados.get(i) instanceof Repartidor)){
                            empleados.get(i).mostrarAtributos();
                        }
                    }   break;
                case 2:
                    //bucle para comprobar si hay comerciales creados
                    //sino los hay salta mensaje
                    while (j == 0 && vueltas<empleados.size()){
                        if(empleados.get(vueltas) instanceof Comercial){
                            j++;
                        }
                        vueltas +=1;
                    }
                    if (j !=0){
                        for (int i=0; i<empleados.size();i++){
                            if(empleados.get(i) instanceof Comercial){
                                empleados.get(i).mostrarAtributos();
                            }
                        }
                    } else{
                        System.out.println("No hay comerciales registrados");
                    }   break;
                case 3:
                    while (j == 0 && vueltas<empleados.size()){
                        if(empleados.get(vueltas) instanceof Repartidor){
                            j++;
                        }
                        vueltas +=1;
                    }
                    if (j !=0){
                        for (int i=0; i<empleados.size();i++){
                            if(empleados.get(i) instanceof Repartidor){
                                empleados.get(i).mostrarAtributos();
                            }
                        }
                    }
                    else{
                        System.out.println("No hay repartidores registrados");
                    }   break;
                default:
                    break;
            }
        }
        
    }
}
