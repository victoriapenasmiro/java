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
// Programa Java para simular un ArithmeticException 
class ArithmeticException_Demo {

    public static void main(String args[]) {
        try {
            int a = 30, b = 0;
            int c = a / b;  // No es posible dividir entre 0.
            System.out.println("Resultado = " + c);
        } catch (ArithmeticException e) {
            System.out.println("Imposible dividir entre 0");
        }
    }
}