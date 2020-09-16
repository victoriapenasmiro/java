/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseString;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class metodos {
    
    /*explicación de los caracteres de conversion: http://javaparanulos.blogspot.com/2012/06/formateo-de-textos-en-java.html
    %[argument_index] [flags] [width] [precision] conversion

    donde % marca el inicio de un especificador.
    [argument_index] indica cuál de los argumentos se va a utilizar. Se hace con un número seguido de $. Por ejemplo:

       String str = "Año, mes, día: %3$s-%2$-%1$s";
       System.out.printf(str, 5, "Febrero", 2012);

    producirá la salida

       Año, mes, día: 2012-Febrero-5

    Los flags o banderas son opcionales, e indican (los coloco entre comillas aquí, pero no las llevarían en el código):

       "-":  justifica el argumento a la izquierda.
       "#":  incluye un radical para enteros y una coma para decimales.
       "+":  incluye el signo(+ o -).
       "  ":  espacio en los valores positivos.
       "0":  se llenan los espacios con ceros en los valores positivos.
       ",":  usa un separador de grupo específico según la zona geográfica.
       "(":  encierra los números negativos en paréntesis.

    Width indica el número mínimo de caracteres que tendrá la salida. 
    Precision indica el número máximo de dígitos después de la como en un decimal.*/
    
    /*esta función me rellena espacios a la derecha*/
    //info sobre el metodo format en: https://www.lawebdelprogramador.com/foros/Java/1500981-String.format.html
    public static String rightpad(String string, int length) {
        //el % hace referencia al argumento que formatea, el - me justifica el
        //texto a la izquierda, el lenght asigna el ancho total, la s indica que es una string
        return String.format("%-" + length + "s", string);
    }
    /*esta función me rellena espacios a la izquierda*/
    private String leftpad(String text, int length) {
        return String.format("%" + length + "." + length + "s", text);
    }
    
    public static void conviertoString(){
        int horas = 5;
        String.valueOf(horas).contains("test"); //convierto horas a string y compruebo si tiene el valor test en la cadena
    }
    
    public static void dividirFrase(){
        String [] frase;
        String linea = "Hola que ase";
        frase = linea.split(" "); // obtengo una array de palabras, que he splietado por espacios
    }
    
    //Capturar un enter
        
    public static void capturarEnter(){
        Scanner lector = new Scanner(System.in);
        String ruta = null;
        //Si ruta esta vacia o al eliminar los espacios de cada lado está vacia ejecuta
        while ((ruta == null) || (ruta.trim().isEmpty())) {
            ruta = lector.nextLine();
        }
    }

}
