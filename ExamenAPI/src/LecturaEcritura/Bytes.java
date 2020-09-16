/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LecturaEcritura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author victoriapenas
 */
public class Bytes {
    /*Para que se lea y escriba bien un fichero byte a byte es necesario
    guardarlo como fichero de texto con el encoding UTF-8. En la consola no
    imprime bien los acentos, pero si se guardan bien en el fichero de origen*/
    public static void leemosEscribimosBytes(){
        String texto = "prueba";
        int letra; //cada letra es un byte
        File origen = new File ("docOrigen.txt");
        File destino = new File ("docDestino.txt");
        /*utilizando el try with resources no es necesario cerrar los recursos*/
        try (FileInputStream reader = new FileInputStream(origen);
                   FileOutputStream writer = new FileOutputStream(destino, true)){
                /*convierto a bytes una palabra*/
                writer.write(texto.getBytes());
                do{
                    letra = reader.read(); //leo la primera letra localizada en el fichero origen
                    if(letra != -1){//cuando se terminan las letras, el sistema devuelve un -1
                        System.out.print((char)letra); //convierto los bytes leidos a un char para imprimirlo por consola
                        writer.write(letra); //escribo bytes
                    }
                }while(letra != -1);//cuando se terminan las letras, el sistema devuelve un -1
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
