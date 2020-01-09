/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    /*Leer 5 números y mostrarlos en orden inverso al introducido.*/
    public static void numerosRevertidos(){
        int lista_num[] = new int [5];
        Scanner num = new Scanner(System.in);
        for (int i=0;i<5;i++){
            System.out.println("Dame un número");
            int num1 = num.nextInt();
            lista_num[i] = num1;
        }
        for (int i=4;i>=0;i--){
            System.out.println(lista_num[i]);
        }
    }
    
    /*Leer 5 números por teclado y a continuación realizar la media de los
    números positivos, la media de los negativos y contar el número de ceros.*/
    
    /*Opción válida pero no óptima*/
    /*public static void calcularMedia(){
        //utilizo floats para que al calcular la media se contemplen
        float num_positivos[] = new float [5];
        float num_negativos[] = new float [5];
        float sumatorio_positivos = 0;
        float sumatorio_negativos = 0;
        int numero; // variable auxiliar para guardar la parte entera del num
        float res = 0; // variable auxiliar para calcular las medias
        int contador = 0; // variable auxiliar para contar los ceros
        Scanner num = new Scanner(System.in);
        for (int i=0;i<5;i++){
            System.out.println("Dame un número");
            float num1 = num.nextFloat();
            if (num1<0){
                int j = 0;
                while (num_negativos[j] != 0){
                    j+=1;
                }
                num_negativos[j] = num1;
            }
            else{
                int k = 0;
                //Para saber si la posicion de la array esta vacía, = 0.
                while (num_positivos[k] != 0){ 
                    k+=1;
                }
                num_positivos[k] = num1;
            }
        }
        
        for (int i=0;i<num_positivos.length;i++){
        sumatorio_positivos+=num_positivos[i];
        res = sumatorio_positivos/2;
        }
        
        System.out.println("La media de los números positivos es: " + res);
        
        numero = (int)res; //me quedo con la parte entera del número para
        //pasarlo a string
        
        String numCadena=String.valueOf(numero); //convierto el numero a string
        
        for (int i=0;i<numCadena.length();i++){
            char c = numCadena.charAt(i);
            if (c == 0){
                contador+=1; //no entra nunca en la condición
                System.out.println(c);
            }
        }
        
        System.out.println("El total de ceros incluidos en la parte entera del"
                + " num son:" + contador);
        
        for (int i=0;i<num_negativos.length;i++){
            sumatorio_negativos+=num_negativos[i];
            res = sumatorio_negativos/2;
        }
        
        System.out.println("La media de los números negativos es: " + res);
    }*/
    /*mejor opción*/
    public static void calcularMedia(){
        float positivos = 0;
        float negativos = 0;
        int contador_ceros = 0;
        Scanner num = new Scanner(System.in);
        for (int i=0;i<5;i++){
            System.out.println("Dime un numero:");
            float num1 = num.nextFloat();
            if (num1<0){
                negativos+=num1;
            }
            else if (num1 == 0){
                contador_ceros+=1;
            }
            else{
                positivos+=num1;
            }
        }
        System.out.println("la media de los numeros positivos es: " +
        positivos/2 + " la media de los numeros negativos es: " + negativos/2 +
        " Hay " + contador_ceros + "ceros.");
    }
/*Leer 10 números enteros. Debemos mostrarlos en el siguiente orden: el primero,
el último, el segundo, el penúltimo, el tercero, etc.*/
    
    public static void mostrarNumeros(){
        int numeros[] = new int [10];
        Scanner num = new Scanner(System.in);
        for (int i=0;i<10;i++){
            System.out.println("Dime un numero:");
            int num1 = num.nextInt();
            numeros[i] = num1;
        }
        for (int i=0;i<(numeros.length/2);i++){
            System.out.println(numeros[i] + "," + numeros[numeros.length-1-i]);
        }
    }
/*Leer por teclado dos tablas de 10 números enteros y mezclarlas en una
tercera de la forma: el 1º de A, el 1º de B, el 2º de A, el 2º de B, etc.*/
    public static void mostrarTablas(){
        int tablaA[] = new int [10];
        int tablaB[] = new int [10];
        int tablaC[] = new int [20];
        int aux = 0; // contador para cargar valores a la segunda array
        int contador = 0; //auxiliar para tablaC
        Scanner num = new Scanner(System.in);
        for (int i=0; i<20; i++){
            System.out.println("Dame un numero:");
            int num1 = num.nextInt();
            if (tablaA.length != 10){
                tablaA[i]=num1;
            }
            else {
                tablaB[aux]=num1;
                aux=+1;//el operador bien puesto como += no lo coge
            }
        }
        for (int i=1;i<21;i++){
            if (contador <=10){
                if (i%2==0){
                    tablaC[i-1]=tablaA[contador];
                    contador+=1; //pendiente probar
                }
                else{
                    tablaC[i-1]=tablaB[i-1];
                }
            }
            else{
                
            }
        }
        for (int i=0;i<20;i++){
            System.out.println(tablaC[i]);
        }
    }
    
/*Leer los datos correspondientes a dos tablas de 12 elementos numéricos, y
mezclarlos en una tercera de la forma: 3 de la tabla A, 3 de la B, otros 3 de A,
otros 3 de la B, etc.*/
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        mostrarTablas();
    }
}
