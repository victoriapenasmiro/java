/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    
    /*1. Crea un proyecto Java, y en el programa principal incluye un menú
    (con switch) que llame a los siguiente métodos. Este menú debe permitir al
    usuario seleccionar el método que desea ejecutar, por tanto, los siguientes
    ejercicios se incluirán en métodos (recuerda que el nombrado del método
    debe ser representativo sobre la función que realiza).
    Empiezo: 18:50 - 19:00 + 5m + 5m */
    
    public static void mostrarMenu(){
        Scanner num = new Scanner(System.in);
        boolean exit = false;
        while (exit == false){
            System.out.println("=============== MENU PRINCIPAL ============");
            System.out.println("Por favor, elige una opción:");
            System.out.println("1. Mostrar tabla bidimensional de tamaño 5x5.");
            System.out.println("2. Comprobar si una matriz es asimetrica.");
            System.out.println("3. Sumar dos matrices 3*3");
            System.out.println("4. Matriz con diagonal ppal a 1 y resto a 0");
            System.out.println("5. Matriz 8x6 rellena de 0 con los bordes a 1");
            System.out.println("6. Crear matriz rellena de 0 con bordes a 1");
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
                case 3:
                    sumarMatrices();
                    break;
                case 4:
                    rellenarTabla7X7();
                    break;
                case 5:
                    matrizConBordes();
                    break;
                case 6:
                    Scanner valor = new Scanner (System.in);
                    System.out.println("Dame dos numeros enteros:");
                    int num1 = num.nextInt();
                    int num2 = num.nextInt();
                    matrizCreadaBordes(num1,num2);
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
    Empiezo: 19:35 a 19:45 + 19:20 a 19:45*/
    
    public static void tablaSimetrica(){
        //creo la matriz
        int tabla [][] = new int [4][4];
        int aux1 = 0; //variable auxiliar para comprobar si es simetrica
        int aux2 = 0; //variable auxiliar para comprobar si es simetrica
        boolean simetrica = true;
        Scanner num = new Scanner(System.in);
        //relleno la matriz pidiendo enteros al usuario
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[i].length;j++){
                System.out.println("Dame un valor:");
                int valor = num.nextInt();
                tabla[i][j]= valor;
            }
        }
        //compruebo si la matriz es simétrica
        while (simetrica==true && aux1<tabla.length){
            while (simetrica==true && aux2<tabla[aux1].length){
                if (tabla[aux1][aux2]==tabla[aux2][aux1]){
                    simetrica=true;
                    aux2++;
                }
                else{
                    simetrica=false;
                }
            }
            aux1++;
            aux2=0;//reseteo el valor para chequear la siguiente fila
        }
        
        if (simetrica==true){
           System.out.println("La matriz es simetrica.");
        }
        
        else{
             System.out.println("La matriz es asimetrica.");
        }
        //imprimo la array para comprobarlo
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
    
    /*4. Crear y cargar dos matrices de tamaño 3x3, sumarlas y mostrar su suma.
    empiezo: 19:45 a 21:15 - 18:45 a 19:20*/
    
    public static void sumarMatrices(){
        int matriz1 [][] = new int [3][3];
        int matriz2 [][] = new int [3][3];
        int matriz_suma [][] = new int [3][3];
        int aux1=0; //auxiliar para controlar las filas
        int aux2=0; // auxiliar para controlas las columnas
        Scanner num = new Scanner(System.in);
        
        //controlo que mientras haya huecos en las matrices inserte. Accedo a
        //la última posicion de la primera dimensión y a la ultima de la segunda
        while (matriz1[matriz1.length-1][matriz1[0].length-1] == 0 ||
                matriz2[matriz2.length-1][matriz2[0].length-1] == 0){
            System.out.println("dame un entero:");
            int valor = num.nextInt();
            if (matriz1[matriz1.length-1][matriz1[0].length-1] == 0){
                if (aux1<matriz1.length){
                    matriz1[aux1][aux2] = valor;
                    if (aux2+1<matriz1[aux1].length){//sumo 1 para que si aux2
                    //llega al llenar la segunda dimensión no incremente
                        aux2++;
                    }
                
                    else if (matriz1[aux1].length-1 != 0){
                    //controlo que la ultima posicion esté ocupada
                        aux2=0;//reseteo el valor para que la siguiente fila
                               //empiece en la columna 0
                        aux1++;//empieza la siguiente fila
                    }
                }
            }
            else if(matriz2[matriz2.length-1][matriz2[0].length-1] == 0){
                if (matriz2[0][0] == 0){
                    aux1=0; //reseteo el contador para rellenar la matriz2
                }
                matriz2[aux1][aux2] = valor;
                if (aux2+1<matriz2[aux1].length){
                    aux2++;
                }
                else if (matriz2[aux1].length-1 != 0){                 
                    aux2=0;
                    aux1++;
                } 
            }
        }
        
        //sumo las matrices
        for (int i=0;i<matriz_suma.length;i++){
            for (int j=0;j<matriz_suma[i].length;j++){
                matriz_suma[i][j]=(matriz1[i][j]+matriz2[i][j]);
            }
        }
        
        //muestro la matriz sumada
        for (int i=0;i<matriz_suma.length;i++){
            for (int j=0;j<matriz_suma[i].length;j++){
                if (j==matriz_suma[i].length-1){
                    System.out.println(matriz_suma[i][j]);
                }
                else{
                    System.out.print(matriz_suma[i][j]);
                }
            }
        }
    }
    
    /*5. Crear una tabla de tamaño 7x7 y rellenarla de forma que los elementos de
    la diagonal principal sean 1 y el resto 0.
    empiezo: 19:25 a 19:30*/
    
    public static void rellenarTabla7X7(){
        int matriz[][] = new int [7][7];
        for(int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                //cuando las coordenada son el mismo nº hay que cargar 1
                if(j==i){
                    matriz[i][j] = 1;
                }
                else{
                    matriz[i][j] = 0;
                }
            }
        }
        
        //muestro la matriz sumada
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                if (j==matriz[i].length-1){
                    System.out.println(matriz[i][j]);
                }
                else{
                    System.out.print(matriz[i][j]);
                }
            }
        }
    }
    
   /*6. Crear una matriz marco de tamaño 8x6: todos sus elementos deben ser 0
    salvo los de los bordes que deben ser 1. Mostrar la matriz.
    Empiezo: 19:45 a 19:55*/
    
    public static void matrizConBordes(){
        int matriz[][] = new int [8][6];
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                //pongo 1 cuando i o j estén es la primera/ultima fila/columna
                if (i==0|| i==matriz.length-1|| j==0|| j==matriz[i].length-1){
                    matriz[i][j]=1;
                }
                else{
                    matriz[i][j]=0;
                }
            }
        }
        
        //muestro la matriz
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                if (j==matriz[i].length-1){
                    System.out.println(matriz[i][j]);
                }
                else{
                    System.out.print(matriz[i][j]);
                }
            }
        }
    }
    
    /* 7. Crear una matriz marco cuyo tamaño se pedirá al usuario por
    teclado. Todos sus elementos deben ser 0 salvo los de los bordes que deben
    ser 1. Mostrar la matriz. empiezo: 19:55*/
    
    public static void matrizCreadaBordes(int dimension1,int dimension2){
        int matriz [][] = new int [dimension1][dimension2];
        
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                //pongo 1 cuando i o j estén es la primera/ultima fila/columna
                if (i==0|| i==matriz.length-1|| j==0|| j==matriz[i].length-1){
                    matriz[i][j]=1;
                }
                else{
                    matriz[i][j]=0;
                }
            }
        }
        
        //muestro la matriz
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[i].length;j++){
                if (j==matriz[i].length-1){
                    System.out.println(matriz[i][j]);
                }
                else{
                    System.out.print(matriz[i][j]);
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        mostrarMenu();
    }
    
}
