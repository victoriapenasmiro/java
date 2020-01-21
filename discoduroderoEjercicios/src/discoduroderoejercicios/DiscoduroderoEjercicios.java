/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discoduroderoejercicios;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
Este listado de ejercicios están publicados en:
https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-basicos-java/
 */
public class DiscoduroderoEjercicios {

    /**
     * @param args the command line arguments
     */
    
    /*1) Declara dos variables numéricas (con el valor que desees),
    muestra por consola la suma, resta, multiplicación, división y módulo*/
    
    public static void calculosNum(){
        System.out.println("Dame un número");
        Scanner numero1 = new Scanner(System.in);
        int num1 = numero1.nextInt();
        System.out.println("Dame otro número");
        Scanner numero2 = new Scanner(System.in);
        int num2 = numero2.nextInt();
        System.out.println("suma: " + (num1+num2));
        System.out.println("resta: " + (num1-num2));
        System.out.println("multiplicación: " + (num1*num2));
        System.out.println("división: " + (num1/num2));
        System.out.println("modulo: " + (num1%num2));
    }
    
    /*2) Declara 2 variables numéricas (con el valor que desees),
    he indica cual es mayor de los dos. Si son iguales indicarlo también.
    Ves cambiando los valores para comprobar que funciona.*/
    
    public static void numeroMayor(){
        System.out.println("Dame un número");
        Scanner numero1 = new Scanner(System.in);
        int num1 = numero1.nextInt();
        System.out.println("Dame otro número");
        Scanner numero2 = new Scanner(System.in);
        int num2 = numero2.nextInt();
        if (num1<num2){
            System.out.println(num2 + " Es el mayor.");
        }
        else if (num1==num2){
            System.out.println(num1 + " y " + num2 + " Son iguales.");
        }
        
        else{
            System.out.println(num1 + " Es el mayor.");
        }
    }
    
    /*3) Declara un String que contenga tu nombre, después muestra un mensaje
    de bienvenida por consola. Por ejemplo: si introduzco “Fernando”, me
    aparezca “Bienvenido Fernando”.
    
    4) Modifica la aplicación anterior, para que nos pida el nombre que
    queremos introducir (recuerda usar JOptionPane).*/
    
    public static void saludoBienvenida(){
        System.out.println("Dime tu nombre: ");
        Scanner nombre = new Scanner(System.in);
        String saludo = nombre.next();
        System.out.println("Bienvenid@ " + saludo);
    }
    
    /*5) Haz una aplicación que calcule el área de un círculo(pi*R2). El
    radio se pedirá por teclado (recuerda pasar de String a double con
    Double.parseDouble). Usa la constante PI y el método pow de Math.*/
    
    public static void areaCirculo(){
        System.out.println("Dime el radio del triángulo: ");
        Scanner radio = new Scanner(System.in);
        //pido el radio como String para pasarlo a double
        String circulo = radio.next();
        //convierto la String a double
        double circulo_double = Double.parseDouble(circulo);
        //utilizo la clase java.lang.Math para invocar la constante PI 
        //Math.pow() devuelve la  base elevada al exponente
        System.out.println("El área del circulo es: \n"
                + (Math.pow(circulo_double, 2) * Math.PI));
        
    }
    
    /*6) Lee un número por teclado e indica si es divisible entre 2
    (resto = 0). Si no lo es, también debemos indicarlo.*/
    
    public static void divisible2(){
        Scanner num = new Scanner(System.in);
        System.out.println("Dime un numero entero:");
        /*tengo que indicar que la variable numero es double para que en el
        print de la opcion no divisible muestre el resultado decimal de
        la operación*/
        double numero = num.nextDouble();
        if (numero%2 == 0){
            System.out.println("Es divisible entre dos, da 0");
        }
        else{
            double resto_num=numero/2;
            System.out.println("No es divible entre dos." + numero + "/2 = "
                    + resto_num);
        }
    }
    
    /*7) Lee un número por teclado y muestra por consola, el carácter al que
    pertenece en la tabla ASCII. Ej: si introduzco un 97, me muestre una a.
    ayuda en:
https://www.lawebdelprogramador.com/foros/Java/769306-paso-de-codigo-ascii-a-su-caracter.html*/
    
    public static void convertirNumeroASCII(){
        Scanner num = new Scanner (System.in);
        System.out.println("Dame un valor: ");
        int entero = num.nextInt();
        char ascii = (char)entero;
        
        System.out.println("el codigo ASCII de este número es " + ascii);
    }
    
    /*8) Modifica el ejercicio anterior, para que en lugar de pedir un número,
    pida un carácter (char) y muestre su código en la tabla ASCII.
    Empiezo: 20:55 a 21:00
    ayuda en: https://www.geeksforgeeks.org/gfact-51-java-scanner-nextchar/*/
    
    public static void convertirCaracterASCII(){
        Scanner num = new Scanner (System.in);
        System.out.println("Dime una letra: ");
        char caracter = num.next().charAt(0); //metodo para pedir por teclado
                                               //un dato tipo chart
        int ascii = (int)caracter;
        System.out.println("el codigo ASCII de este número es " + ascii);
    }
    
    /*9) Lee un número por teclado que pida el precio de un producto
    (puede tener decimales) y calcule el precio final con IVA. El IVA sera una
    constante que sera del 21%.
    Empiezo: 21:05 a 21:20*/
    
    public static void calcularIVA(){
        final double iva = 0.21;
        Scanner num =  new Scanner (System.in);
        System.out.println("Dime un precio: ");
        float pvp = num.nextFloat();
        System.out.println("El precio con IVA es: " + (pvp+(pvp*iva)));
    }
    
    /*10) Muestra los números del 1 al 100 (ambos incluidos).
    Usa un bucle while.
    Empiezo: 16:10 - 16:12*/
    
    public static void mostrar100NumWhile(){
        int i = 1;
        while (i<=100){
            System.out.println(i);
            i+=1;
        }
    }
    
    /*11) Haz el mismo ejercicio anterior con un bucle for.
    Empiezo: 17:40 a 17:41*/
    
    public static void mostrar100NumFor(){
        for (int i=1;i<=100;i++){
            System.out.println(i);
        }
    }
    
    /*12) Muestra los números del 1 al 100 (ambos incluidos) divisibles entre
    2 y 3. Utiliza el bucle que desees.
    Empiezo a: 19:15-19:20*/
    
    public static void divisiblesEntre2y3(){
        int i=1;
        System.out.println("Los numeros divisibles entre 2 y 3 dentro"
                        + "del rango del 1 al 100 son:");
        while (i<=100){
            if (i%2==0 && i%3==0){
                System.out.println(i);
            }
            i++;
        }
    }
    
    /*13) Realiza una aplicación que nos pida un número de ventas a introducir,
    después nos pedirá tantas ventas por teclado como número de ventas se hayan
    indicado. Al final mostrara la suma de todas las ventas. Piensa que es lo
    que se repite y lo que no. Empiezo: 19:25 a 19:35*/
    
    public static void introducirVentas(){
        Scanner num = new Scanner(System.in);
        double sumatorio=0;
        System.out.println("Dime el numero de ventas que vas a introducir:");
        int ventas = num.nextInt();
        for(int i=0;i<ventas;i++){
            System.out.println("Dime el importe de la venta " + (i+1) +":");
            double suma=num.nextDouble();
            sumatorio+=suma;
        }
        System.out.println("el total de ventas asciende a: " + sumatorio);
    }
    
    /*14) Realiza una aplicación que nos calcule una ecuación de segundo grado.
    Debes pedir las variables a, b y c por teclado y comprobar antes que el
    discriminante (operación en la raíz cuadrada). Para la raíz cuadrada usa
    el método sqlrt de Math. Te recomiendo que uses mensajes de traza.
    Empiezo: 19:35 - 19:55. No lo he realizado yo, no recuerdo como se realizan
    las ecuaciones de segundo grado y no se como resolverlo técnicamente*/
    
    public static void calcularEcuacion(){
        Scanner var = new Scanner (System.in);
        System.out.println("Dime el valor de a:");
        double a=var.nextDouble();
        System.out.println("Dime el valor de b:");
        double b=var.nextDouble();
        System.out.println("Dime el valor de c:");
        double c=var.nextDouble();
        double discriminante=Math.pow(b, 2)-(4*a*c);
  
        //Mensaje de traza
        System.out.println(">>"+discriminante);
  
        if (discriminante>0){
            //Tambien se puede hacer por parte si lo ves más facil
            //recuerda que debes tener en cuenta la prioridad de elementos
            double x1=((b*(-1))+Math.sqrt(discriminante))/(2*a);
            double x2=((b*(-1))-Math.sqrt(discriminante))/(2*a);
            System.out.println("El valor de x1 es "+x1+" y el de x2 es "+x2);
        }
        else{
            System.out.println("El discriminante es negativo");
        }
    }
}
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //calculosNum();
        //numeroMayor();
        //saludoBienvenida();
        //areaCirculo();
        //divisible2();
        //convertirNumeroASCII();
        //convertirCaracterASCII();
        //calcularIVA();
        //mostrar100NumWhile();
        //mostrar100NumFor();
        //divisiblesEntre2y3();
        //introducirVentas();
        calcularEcuacion();
    }
    
}
