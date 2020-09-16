/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author victoriapenas
 * este tipo de excepcion controla que me inserte un valor por teclado del tipo que esperamos
 */
public class InputMismatchException_Demo {
    
    public static void main(String args[]){
        try{
            Scanner lector = new Scanner(System.in);
            System.out.println("Dime el tamaño en metros de la arista:");
            double arista = lector.nextDouble();
        }catch (InputMismatchException e){
    //este tipo de excepcion controla que me inserte un valor por teclado del tipo que esperamos
            System.out.println("Por favor, indtroduce un valor numérico. Inténtalo de nuevo");
        }
    }
}
