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
// Programa para simular un NullPointerException 
class NullPointer_Demo {

    public static void main(String args[]) {
        try {
            String a = null; // Valor null
            // charAt localiza letra de un string en la posición indicada
            System.out.println(a.charAt(0));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException..");
        }
    }
}
