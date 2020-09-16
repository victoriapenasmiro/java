/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayList;

import java.util.ArrayList;

/**
 *
 * @author victoriapenas
 */

public class MetodosArrayList {
    public static void main(String[] args) {
        //formas de instanciar una arrayList
        ArrayList <String> stringTest = new ArrayList <>();
        ArrayList <Integer> intTest = new ArrayList <>();
        ArrayList <Double> doubleTest = new ArrayList <Double>();
        
        stringTest.add("hola");//añado un valor a la arrayList
        stringTest.size(); //recupero el num total de elementos de la arrayList
        stringTest.get(0); //recupero el elemento que está en la posicion 0 de la arrayList stringTest
        stringTest.isEmpty(); //devuelve un boolean para saber si la arrayList está o no vacía
    }
}
