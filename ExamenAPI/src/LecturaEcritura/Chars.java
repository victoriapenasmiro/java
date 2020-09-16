/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LecturaEcritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author victoriapenas
 */
public class Chars {
    public static void leoChars(String [] encabezados){
        //con el siguiente metodo podré añadir un salto de linea
        String nuevaLinea = System.getProperty("line.separator");
        int letra;
        File entrada = new File("origen.txt");
        File destino = new File("destino.txt");
        try (FileReader reader = new FileReader(entrada);FileWriter writer = new FileWriter(destino,true)){
            do{
                //leo la primera letra que se encuentra en el fichero de origen/entrada
                letra = reader.read();
                System.out.print((char)letra);
                if (letra != -1){//mientras no se llegue al final del fichero, escribo
                    writer.write(letra);
                }
            }while(letra != -1);//cuando el reader llega al final del fichero, se obtiene un -1 
        } catch (UnsupportedEncodingException ex) {
            ex = new UnsupportedEncodingException("El encoding indicado no es correcto.");
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            //fichero no encontrado
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error inesperado. Más detalles:");
            System.out.println(ex.getCause());
        }
    }
    
}
