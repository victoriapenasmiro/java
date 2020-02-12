/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.ArrayList;
import java.util.Scanner;
import static practica4.Cliente.altaCliente;
import static practica4.Pelicula.addPelicula;
import static practica4.Pelicula.buscarPelicula;
import static practica4.Pelicula.mostrarPelisReservadas;
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
        ArrayList <Pelicula> peliculas = new ArrayList <Pelicula>();
        ArrayList <Cliente> clientes = new ArrayList <>(); //otra forma de instanciar una arrayList
        
        //constantes
        final int limitePeliculas = 3000;
        
        //empieza el programa
        mostrarMenu(clientes,peliculas,limitePeliculas);
        
    }
    
    public static void mostrarMenu(ArrayList <Cliente> clientes, ArrayList <Pelicula> peliculas, int limitePeliculas){
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        //la inicializo en -1 para utilizar en el caso 3
        int posicionCliente = -1;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Añadir Película");
            System.out.println("2. Reservar Pelicula");
            System.out.println("3. Ver peliculas que tengo reservadas");
            System.out.println("4. Ver todas las peliculas reservadas del videoclub");
            System.out.println("5. Buscar Pelicula");
            System.out.println("6. Salir");
            if(lector.hasNextInt()){
                int opcion = lector.nextInt();
                switch(opcion){
                    case 1:
                        addPelicula(peliculas,limitePeliculas);
                        break;
                    case 2:
                        posicionCliente = verInicio(clientes,peliculas);
                        reservarPelicula(peliculas,clientes.get(posicionCliente));
                        break;
                    case 3:
                        if (posicionCliente == -1){
                            posicionCliente = verInicio(clientes,peliculas);
                        }
                        else{
                            clientes.get(posicionCliente).verPeliculasReservadas();
                        }
                        break;
                    case 4:
                        mostrarPelisReservadas(clientes);
                        break;
                    case 5:
                        buscarPelicula(peliculas);
                        break;
                    case 6:
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
    
    public static int verInicio(ArrayList <Cliente> clientes, ArrayList <Pelicula> pelis){
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        //la inicializo porque me obliga el return
        int posicionCliente = 0;
        do {
            System.out.println("\n=============== INICIO ============");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            /*valido q el usuario me inserte un integer y que sea una
            de las opciones disponibles*/
            if(lector.hasNextInt()){
                int opcion = lector.nextInt();
                switch(opcion){
                    case 3:
                        exit = true;
                        break;
                    case 2:
                        altaCliente(clientes);
                        break;
                    case 1:
                        posicionCliente = iniciarSesion(clientes);
                        if (posicionCliente<clientes.size() && posicionCliente>=0){
                            exit = true;
                        }
                        else{
                            System.out.println("los datos de acceso"
                                    + " no son válidos.");
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
        
        return posicionCliente;
    }
    
    public static int iniciarSesion(ArrayList <Cliente> clientes){
        Scanner lector = new Scanner(System.in);
        int codUser;
        String password;
        int i = 0; //incremental
        System.out.println("Dime el codigo de usuario:");
        //controlo que el usuario indique un codigo numero de usuario
        if(lector.hasNextInt()){
            codUser = Integer.parseInt(lector.nextLine());
            System.out.println("Dime la constraseña:");
            password = lector.nextLine();
            //controlo que el codigo de usuario y la password coincidan, que no
            //me salgo del rango de la array y que hay datos en la array
            
            //controlo el caso de que la lista esté vacia
            if(clientes.isEmpty()){
                System.out.println("El usuario no existe, por favor, regístrate");
            }
            else{
                //tiene que ser un || porque si tengo basta con que el user o la pw sea diferente.
                while ((clientes.get(i).getCodCliente() != codUser ||
                 !clientes.get(i).getPassword().equals(password)) &&
                i != clientes.size()-1){
                    i++;
                }
                //verifico si el usuario existe con las claves instroducidas
                if(clientes.get(i).getCodCliente() == codUser &&
                        clientes.get(i).getPassword().equals(password)){
                    System.out.println("******** Bienvenido/a " +
                            clientes.get(i).getNombre() + "********");
                }
                else{
                    System.out.println("Las claves de acceso indicadas no son correctas");
                    i=-1;//-1 identifica que el usuario no existe
                }
            }
        }
        
        else{
            System.out.println("El codigo de usuario no es correcto, es un código numérico.");
        }
        
        return i;
    }
}
