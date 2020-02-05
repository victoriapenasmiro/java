/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.util.ArrayList;
import java.util.Scanner;
import static practica3.Cuenta.crearCuenta;
import static practica3.Cuenta.iniciarSesion;
import static practica3.Cuenta.verificarCuenta;

/**
 *
 * @author victoriapenas
1. Escribe una clase Cuenta para representar una cuenta bancaria.
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
    b. Un reintegro consiste en disminuir el saldo en una cantidad pero antes
    se debe comprobar que hay saldo suficiente. La cantidad no puede ser negativa.  
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

* 2. Versión 2 del ejercicio anterior (opcional). Aprovechando que hemos visto
* los arraylist, podemos realizar una nueva rama (github) del programa anterior,
* aplicando los siguientes cambios que se describen:
    a. El programa principal tendrá un arraylist de cuentas. 
    b. Cuando se inicie el programa te llevará a un menú que ofrecerá mientras
    no selecciones la opción “salir”, las siguiente opciones:
    Iniciar sesión, alta de cuenta. 
    c. El método iniciarSesión recibirá como parámetro un arraylist de cuentas,
    el número de cuenta y código pin (añade este atributo a la cuenta). Si
    encuentra el número de cuenta y el código pin es incorrecto, mostrará un
    mensaje informando de la situación. En cualquier caso devolverá un número
    entero, -1 si no lo ha encontrado y un número distinto de -1 que indicará
    el número donde se encuentra dentro de la lista.
    d. Si el número obtenido en el paso anterior es distinto de -1, permitirá
    el acceso un nuevo submenú, que básicamente ofrecerá la opción de
    realizar transferencia a una cuenta destino, y realizar ingreso mediante
    efectivo en la propia cuenta. Por ello, adapta los métodos de transferencia
    e ingreso teniendo en cuenta que ahora cuentas con la posición donde se
    encuentra la cuenta del cliente que está operando en estos momentos, y un
    arraylist de cuentas.
 */
public class Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creo cuentas para operar con ellas
        
        //Declaro una cuenta utilizando el constructor vacío
        //No utilizo el objeto, pero lo he declarado para tenerlo en cuenta.
        Cuenta Cuenta1 = new Cuenta();
        Cuenta1.setNombreCliente("Ana");
        Cuenta1.setNumCuenta("12345");
        Cuenta1.setSaldo(0);
        Cuenta1.setTipoInteres(0.25);
        Cuenta1.setPin("1234");
        
        //Declaro una cuenta utilizando el constructor con parámetros
        //No utilizo el objeto, pero lo he declarado para tenerlo en cuenta.
        Cuenta Cuenta2 = new Cuenta("Mario","00990",0,0.10,"1111");
        
        //Declaro una arrayList de Cuentas
        ArrayList <Cuenta> Cuentas = new ArrayList <Cuenta>();
        
        //empieza el programa
        mostrarMenu(Cuentas);
    }
    
    public static void mostrarMenu(ArrayList <Cuenta> Cuentas){
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Alta de cuenta");
            System.out.println("3. Salir");
            /*valido q el usuario me inserte un integer y que sea una
            de las opciones disponibles*/
            if(lector.hasNextInt()){
            int opcion = lector.nextInt();
            int posicion;
            switch(opcion){
                case 3:
                    exit = true;
                    break;
                case 2:
                    Cuenta.crearCuenta(Cuentas);
                    break;
                case 1:
                    System.out.println("Dime el numero de cuenta:");
                    String numcuenta = lector.next();
                    System.out.println("Dime el pin:");
                    String pin = lector.next();
                    posicion=iniciarSesion(Cuentas,numcuenta,pin);
                    if(posicion<Cuentas.size() && posicion != -1){
                        mostrarsubmenu(Cuentas, Cuentas.get(posicion));
                    }
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
    
    public static void mostrarsubmenu(ArrayList <Cuenta> Cuentas,Cuenta cuentaOrigen){
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        //inicializo la variable para que el swich funcione
        do{
            System.out.println("\n====ELIGE UNA DE LAS SIGUIENTES OPCIONES====");
            System.out.println("1. Realizar ingreso");
            System.out.println("2. Sacar dinero");
            System.out.println("3. Realizar transferencia");
            System.out.println("4. Salir");
            /*valido q el usuario me inserte un integer y que sea una
            de las opciones disponibles*/
            if(lector.hasNextInt()){
                int opcion = lector.nextInt();
                switch(opcion){
                case 4:
                    exit = true;
                    break;
                case 1:
                    cuentaOrigen.realizarIngreso();
                    break;
                case 2:
                    cuentaOrigen.realizarReintegro();
                    break;
                case 3:
                    System.out.println("Dime el importe a transferir:");
                    double importe = lector.nextDouble();
                    System.out.println("¿A qué num de cuenta quieres realizar"
                            + " la tranferencia?");
                    String cuentaDestino = lector.next();
                    int posicionDestino = verificarCuenta(Cuentas, cuentaDestino);
                    //-1 es el valor que le asigno si no existe la cuenta
                    if(posicionDestino<Cuentas.size() &&
                            posicionDestino != -1){
                        cuentaOrigen.realizarTransferencia
        (Cuentas.get(posicionDestino), importe);
                    }
                    else{
                        System.out.println("La operacion no se puede realizar");
                    }
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
        } while (exit == false);
}
}
