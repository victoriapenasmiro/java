/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LecturaEcritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author victoriapenas
 */
public class Buffers {
    public static void leoLineas(String [] encabezados){
        String linea = "";
        String [] frase = null;
        File entrada = new File("origen.txt");
        File salida = new File("destino.txt");
        try (BufferedReader lector = new BufferedReader(new FileReader(entrada));
                BufferedWriter writer = new BufferedWriter(new FileWriter(salida, true))){
            do{
                linea = lector.readLine();//leo hasta q encuentra un salto de linea
                if (linea != null){//tengo que poner este if, porque sino me salta la excepcion nullpointer exception
                    frase = linea.split(" "); // obtengo una array de palabras, que he splietado por espacios
                    for (int i = 0;i<frase.length;i++){
                        writer.write(frase[i]);//escribo los encabezados
                        writer.newLine();//salto de linea
                    }
                }
            }while(linea != null); //cuando llegamos al final del fichero, el buffer devuelve un null      
        } catch (FileNotFoundException ex) {
            //fichero no encontrado
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error inesperado. Más detalles:");
            System.out.println(ex.getCause());
        }
    }
}
