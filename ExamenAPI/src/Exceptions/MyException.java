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
// Programa Java para simular una Excepción creada por nosotros  
// Este programa lanza una excepción cuando el saldo es inferior a 1000
class MyException extends Exception {

    //store account information 
    private static int numCuenta[] = {1001, 1002, 1003, 1004};

    private static String nombre[]
            = {"Juan", "Paco", "Maria", "Alberto", "Chema"};

    private static double saldo[]
            = {10000.00, 12000.00, 5600.0, 999.00, 1100.55};

    // Constructor vacío 
    MyException() {
    }

    // Constructor parametrizado
    MyException(String str) {
        super(str);
    }

    // Main
    public static void main(String[] args) {
        try {
            // Printa la cabecera de la tabla
            System.out.println("Número Cuenta" + "\t" + "Cliente"
                    + "\t" + "Saldo");

            // Muestra la información actual de la cuenta
            for (int i = 0; i < 5; i++) {
                System.out.println(numCuenta[i] + "\t" + nombre[i]
                        + "\t" + saldo[i]);

                // Muestra una excepción si saldo < 1000
                if (saldo[i] < 1000) {
                    MyException miExcepcion
                            = new MyException("El saldo es inferior a 1000");
                    throw miExcepcion;
                }
            }
        } //end of try 
        catch (MyException excepcion) {
            excepcion.printStackTrace();
        }
    }
}