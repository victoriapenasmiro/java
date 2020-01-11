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
    pertenece en la tabla ASCII. Ej: si introduzco un 97, me muestre una a.*/
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //calculosNum();
        //numeroMayor();
        //saludoBienvenida();
        //areaCirculo();
        //divisible2();
    }
    
}
