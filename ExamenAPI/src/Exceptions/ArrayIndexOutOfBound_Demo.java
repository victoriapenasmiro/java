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
// Programa Java para simular un ArrayIndexOutOfBoundException 
class ArrayIndexOutOfBound_Demo {

    public static void main(String args[]) {
        try {
            int lista[] = new int[5];
        // Accediendo al séptimo elemento de un array que tiene un máximo de 5
            lista[6] = 9;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index is Out Of Bounds");
        }
    }
}
