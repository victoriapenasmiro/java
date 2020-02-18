/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author victoriapenas
 */
public class Entrada {

    //static String inicializar() {
    static int inicializar() {
        //String buzon = "";
        int buzon = 0;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        try {
            //buzon = teclado.readLine();
            buzon = Integer.parseInt(teclado.readLine());
        } catch (Exception e) {

            System.out.append("Entrada incorrecta");
        }
        return buzon;
    }

    static int entero() {
        //int valor = Integer.parseInt(inicializar());
        int valor = inicializar();
        return valor;
    }

    static double real() {
        double valor = Double.parseDouble(inicializar());
        return valor;
    }

    static String cadena() {
        String valor = inicializar();
        return valor;
    }

    static char caracter() {
        String valor = inicializar();
        return valor.charAt(0);
    }
}
