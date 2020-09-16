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
// Programa Java para simular un StringIndexOutOfBoundsException 
class StringIndexOutOfBound_Demo {

    public static void main(String args[]) {
        try {
            String a = "Como ir en bicicleta "; // length es 21
            char c = a.charAt(24); // Accediendo al carácter 25
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException");
        }
    }
}