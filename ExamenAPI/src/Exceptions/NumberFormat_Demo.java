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
// Programa Java para simular un NumberFormatException 
class NumberFormat_Demo {

    public static void main(String args[]) {
        try {
            // "Hola" No es un número 
            int num = Integer.parseInt("Hola");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Number format exception");
        }
    }
}