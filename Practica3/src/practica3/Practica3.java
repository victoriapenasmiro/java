/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.util.ArrayList;
import java.util.Scanner;
import static practica3.Cuenta.verificarCuenta;

/**
 *
 * @author victoriapenas
Escribe una clase Cuenta para representar una cuenta bancaria.
Los datos de la cuenta son: nombre del cliente (String),
número de cuenta (String), tipo de interés (double) y saldo (double).
La clase contendrá los siguientes métodos: 
1. Constructor por defecto. 
2. Constructor con todos los parámetros. 
3. Constructor copia. 
4. Métodos setters/getters para asignar y obtener los datos de la cuenta. 
5. Métodos ingreso y reintegro.  
    a. Un ingreso consiste en aumentar el saldo en la cantidad que se indique.
Esa cantidad no puede ser negativa.  
    b. Un reintegro consiste en disminuir el saldo en una cantidad pero antes se debe
comprobar que hay saldo suficiente. La cantidad no puede ser negativa.  
    c. Los métodos ingreso y reintegro devuelven true si la operación se ha podido
realizar o false en caso contrario. 
6. Método transferencia. Debe permitir pasar dinero de una cuenta a otra siempre
que en la cuenta de origen haya dinero suficiente para poder hacerla.
    a. Ejemplo de uso del método transferencia:
cuentaOrigen.transferencia(cuentaDestino, importe) que indica que queremos 
hacer una transferencia desde cuentaOrigen a cuentaDestino del importe indicado. 
7. Clase main. Desarrolla otra clase que tenga el main, y ponga a prueba todos
los métodos de la clase Cuenta mediante un menú de usuario que se ejecutará
indefinidamente hasta que este quiera salir.

 */
public class Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creo cuentas para operar con ellas
        
        //Declaro una cuenta utilizando el constructor vacío
        Cuenta Cuenta1 = new Cuenta();
        Cuenta1.setNombreCliente("Ana");
        Cuenta1.setNumCuenta("12345");
        Cuenta1.setSaldo(0);
        Cuenta1.setTipoInteres(0.25);
        
        //Declaro una cuenta utilizando el constructor con parámetros
        Cuenta Cuenta2 = new Cuenta("Mario","00990",0,0.10);
        
        //Declaro una arrayList de Cuentas
        ArrayList <Cuenta> Cuentas = new ArrayList <Cuenta>();
        
        //empieza el programa
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        boolean wenttocatch = false; //valido q el usuario me inserta un numero
        //inicializo la variable para que el swich funcione
        //pendiente probar si el swich hay que meterlo en el do
        int opcion = -1;
        int posicion; //esta variable la utilizo el switch
        do{
            System.out.println("=============== MENU PRINCIPAL ============");
            System.out.println("0. Crear Nueva Cuenta");
            System.out.println("1. Realizar ingreso");
            System.out.println("2. Sacar dinero");
            System.out.println("3. Realizar transferencia");
            System.out.println("4. Salir");
            System.out.println("¿Qué opción quieres realizar?");
            if(lector.hasNextInt()){
                opcion = lector.nextInt();
            }
            else{
                lector.nextLine();
                System.out.println("la opcion indicada no es válida. Por favor,"
                    + "escoge una opción del menu");
            }
            switch(opcion){
                case 4:
                    exit = true;
                    break;
                case 0:
                    Cuenta nuevaCuenta = new Cuenta();
                    nuevaCuenta.crearCuenta(Cuentas);
                    break;
                case 1:
                    posicion=verificarCuenta(Cuentas);
                    if(posicion<=Cuentas.size()){
                        Cuentas.get(posicion).realizarIngreso();  
                    }
                    //-1 es el valor que le asigno si no existe la cuenta
                    else if(posicion==-1){
                        System.out.println("La cuenta indicada no existe");
                    }
                    break;
                case 2:
                    posicion=verificarCuenta(Cuentas);
                    if(posicion<=Cuentas.size()){
                        Cuentas.get(posicion).realizarReintegro();
                    }
                    else if(posicion==-1){
                        System.out.println("La cuenta indicada no existe");
                    }
                    break;
                case 3:
                    System.out.println("Dime el importe a transferir:");
                    double importe = lector.nextDouble();
                    System.out.println("A continuación, indica los datos de la cuenta origen");
                    int posicionOrigen = verificarCuenta(Cuentas);
                    System.out.println("A continuación, indica los datos de la cuenta destino");
                    int posicionDestino = verificarCuenta(Cuentas);
                    if(posicionOrigen<=Cuentas.size() && posicionDestino<=Cuentas.size()){
                        Cuentas.get(posicionOrigen).realizarTransferencia(Cuentas.get(posicionDestino), importe);
                    }
                    else{
                        System.out.println("La operacion no se puede realizar");
                    }
                    break;
                default:
                    if (!lector.hasNextInt()){
                        System.out.println("La opción indicada no es correcta,"
                            + "por favor, indica otra.");
                    }
                    else{
                        System.out.println("indica na opcion correcta");
                    }
            }
        } while (exit == false && wenttocatch == false);
    }
}
