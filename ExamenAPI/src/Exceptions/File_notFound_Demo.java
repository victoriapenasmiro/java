/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author chema
 */
// Programa Java para simular un FileNotFoundException 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class File_notFound_Demo {

    public static void main(String args[]) {
        try {
            // Following file does not exist 
            File file = new File("E://archivo.txt");

            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo...");
        }
    }
}
