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
    /*Leer 5 números (con bucle por favor, no pongáis 5 scanner consecutivos) y
    mostrarlos en el mismo orden introducido.*/
    
    public static void imprimirLista() {
        int[] arrayNum = new int [5];
        for (int i=0;i<5;i++){
            System.out.println("Dame un número");
            Scanner num = new Scanner(System.in);
            int num1 = num.nextInt();
            arrayNum[i]=num1;
        }
        for (int i=0;i<arrayNum.length;i++){
            System.out.println(arrayNum[i]);
        }
    }
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
    
    /*Opción válida pero no óptima, demasiada complicación*/
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
        System.out.println("la media de los numeros positivos es: \n" +
        positivos/2 + " la media de los numeros negativos es:\n" + negativos/2 +
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
    public static void combinarTablas(){
        int tablaA[] = new int [10];
        int tablaB[] = new int [10];
        int tablaC[] = new int [20];
        int aux = 0; // contador para cargar valores a la segunda array
        int contadorA = 0; //auxiliar para tablaC
        int contadorB = 0; //auxiliar para tablaC
        Scanner num = new Scanner(System.in);
        for (int i=0; i<20; i++){
            System.out.println("Dame un numero:");
            int num1 = num.nextInt();
            if (tablaA[9] == 0){
                tablaA[i]=num1;
            }
            else {
                tablaB[aux]=num1;
                aux+=1;
            }
        }
        for (int i=1;i<21;i++){
            if (i%2!=0){
                tablaC[i-1]=tablaA[contadorA];
                contadorA+=1; //pendiente probar
            }
            else{
                tablaC[i-1]=tablaB[contadorB];
                contadorB+=1;
            }
        }
        for (int i=0;i<20;i++){
            System.out.println(tablaC[i]);
        }
    }
    
/*Leer los datos correspondientes a dos tablas de 12 elementos numéricos, y
mezclarlos en una tercera de la forma: 3 de la tabla A, 3 de la B, otros 3 de A,
otros 3 de la B, etc.*/
    
    public static void combinarTablasTres(){
        int tablaA[] = new int [12];
        int tablaB[] = new int [12];
        int tablaC[] = new int [24];
        int aux = 0;
        int posA = 0;//variable para controlar los num que se van cargando en C
        int posB = 0;
        int contadorA = 0;//var para controlar cuantos num se han cargado de a
        int contadorB = 0;
        Scanner num = new Scanner(System.in);
        for (int i=0; i<24; i++){
            System.out.println("Dame un numero:");
            int num1 = num.nextInt();
            if (tablaA[11] == 0){
                tablaA[i]=num1;
            }
            else {
                tablaB[aux]=num1;
                aux+=1;
            }
        }
        for (int i=0;i<24;i++){
            if (contadorA < 3){
                tablaC[i]=tablaA[posA];
                contadorA+=1;
                posA+=1;
                if (contadorA==3){
                    contadorB=0;
                }
            }
            else if (contadorB < 3){
                tablaC[i]=tablaB[posB];
                contadorB+=1;
                posB+=1;
                if (contadorB==3){
                    contadorA=0;
                }
            }
        }
        
        for (int i=0;i<24;i++){
            System.out.println(tablaC[i]);
        }
    }
/*Incluye los 6 ejercicios anteriores en métodos, y realiza un programa
principal que pida al usuario que método quiere ejecutar y llame a este.*/

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner num = new Scanner(System.in);
        boolean exit = false;
        while (exit == false){
            System.out.println("********************************************");
            System.out.println("*********************MENU*******************");
            System.out.println("selecciona una opción:");
            System.out.println("1.Leer 5 números mostrarlos en el mismo orden\n"
                    + "introducido");
            System.out.println("2. Leer 5 números y mostrarlos en inverso\n"
                    + "al introducido.");
            System.out.println("3. Realizar la media de números positivos, la\n"
                    + "media de los negativos y contar el número de ceros");
            System.out.println("4. Mostrar 10 numeros enteros en el siguiente\n"
                    + "orden: el primero, el último, el segundo, el penúl...");
            System.out.println("5. Leer 20 números enteros y cargarlos en dos\n"
                    + "tablas de 10 y mezclarlos en una tercera de la forma:\n"
                    + "el 1º de A,el 1º de B, el 2º de A, el 2º de B, etc.");
            System.out.println("6.Leer dos series de 12 numeros, y mezclarlos\n"
                    + " en una tercera de la forma: 3 de la tabla A,\n"
                    + "3 de la B, otros 3 de A, otros 3 de la B, etc.");
            System.out.println("7. Salir.");
            int opcion = num.nextInt();
            switch (opcion){
                case 7:
                    exit = true;
                    break;
                case 1:
                    imprimirLista();
                    break;
                case 2:
                    numerosRevertidos();
                    break;
                case 3:
                    calcularMedia();
                    break;
                case 4:
                    mostrarNumeros();
                    break;
                case 5:
                    combinarTablas();
                    break;
                case 6:
                    combinarTablasTres();
                    break;
                default:
                    System.out.println("La opción indicada no es correcta,"
                            + "por favor, indica otra.");
            }
        }
    }
}
