/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica2;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Pratica2 {

    /**
     * @param args the command line arguments
     */
    
    /*1. Crea un proyecto Java, y en el programa principal incluye un menú
    (con switch) que llame a los siguiente métodos. Este menú debe permitir al
    usuario seleccionar el método que desea ejecutar, por tanto, los siguientes
    ejercicios se incluirán en métodos (recuerda que el nombrado del método
    debe ser representativo sobre la función que realiza).
    Empiezo: 18:50 - 19:00 + pendiente terminar*/
    
    public static void mostrarMenu(){
        Scanner num = new Scanner(System.in);
        boolean exit = false;
        while (exit == false){
            System.out.println("=============== MENU PRINCIPAL ============");
            System.out.println("Por favor, elige una opción:");
            System.out.println("1. Mostrar tabla bidimensional de tamaño 5x5.");
            System.out.println("2. Comprobar si una matriz es asimetrica.");
            System.out.println("7. Salir.");
            int opcion = num.nextInt();
            switch (opcion){
                case 7:
                    exit = true;
                    break;
                case 1:
                    rellenarTablaBidimensional();
                    break;
                case 2:
                    tablaSimetrica();
                    break;
                default:
                    System.out.println("La opción indicada no es correcta,"
                            + "por favor, indica otra.");
            }
        }
    }
    
    /*2. Crear una tabla bidimensional de tamaño 5x5 y rellenarla de la
    siguiente forma: la posición T[n,m] debe contener n+m. Después se debe
    mostrar su contenido. Empiezo: 19:01 - 19:30*/
    
    public static void rellenarTablaBidimensional(){
        //declaro la matriz
        int tabla[][] = new int [5][5];
        //relleno la matriz
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                tabla [i][j] = i+j;
            }
        }
        //imprimo la matriz
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                if (j==tabla[i].length-1){ // accedo a la última posición de j
                    System.out.println(tabla[i][j]);
                }
                else{
                    System.out.print(tabla[i][j]);
                }
            }
        }
    }
    
    /*3. Crear y cargar una tabla de tamaño 4x4 y decir si es simétrica o no,
    es decir, si se obtiene la misma tabla al cambiar filas por columnas.
    Empiezo: 19:35 - 19:45 - pendiente continuar*/
    
    public static void tablaSimetrica(){
        //creo la matriz
        int tabla [][] = new int [4][4];
        Scanner num = new Scanner(System.in);
        //relleno la matriz pidiendo enteros al usuario
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                int valor = num.nextInt();
                tabla[i][j]= valor;
            }
        }
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                if (j==tabla[i].length-1){
                    System.out.println(tabla[i][j]);
                }
                else{
                    System.out.print(tabla[i][j]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        mostrarMenu();
    }
    
}
