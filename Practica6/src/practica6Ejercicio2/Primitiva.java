/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Primitiva extends Apuesta{
    private int [] listaNum = new int [6];
    private int aciertos = 0;

    public Primitiva() {
        super();
    }

    public Primitiva(String nombre, String apellidos) throws ExceptionSimulador {
        super(nombre, apellidos);
    }

    public Primitiva(Primitiva nuevaPrimitiva) throws ExceptionSimulador {
        super((Apuesta)nuevaPrimitiva);
        this.setAciertos(nuevaPrimitiva.getAciertos());
        this.setListaNum(nuevaPrimitiva.getListaNum());
    }
    
    public int[] getListaNum() {
        return listaNum;
    }

    public void setListaNum(int[] listaNum) {
        this.listaNum = listaNum;
    }

    public boolean validarNumero(int valor, int posicion) {
        if(valor < 1 || valor>49){
            System.out.println("Los números de la primitiva deben estar comprendidos"
                    + " entre 1 y 49.");
            return false;
        }
        else{
            this.getListaNum()[posicion] = valor;
            return true;
        }
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    @Override
    public String mostrarApuesta() { 
        return super.mostrarApuesta() + "Primitiva{" + "listaNum=" + Arrays.toString(this.getListaNum())
                + ", aciertos=" + this.getAciertos() + '}';
    //To change body of generated methods, choose Tools | Templates.
    }

    public static void crearApuestaPrimitiva(int totalApuestas) throws ExceptionSimulador{
        Scanner lector = new Scanner(System.in);
        String nombre;
        String apellido;
        int valor = 0;
        boolean resultado;
        System.out.println("Dime tu nombre");
        nombre = lector.nextLine();
        System.out.println("Dime tu apellido");
        apellido = lector.nextLine();

        for (int i = 1;i<=totalApuestas;i++){
            Primitiva nuevaPrim = new Primitiva();
            nuevaPrim.setNombre(nombre);
            nuevaPrim.setApellidos(apellido);

            for (int j = 0; j<nuevaPrim.getListaNum().length; j++){
                if (j == 0){
                    System.out.println("Dime un numero para la apuesta: " + i);
                    valor = lector.nextInt();
                    resultado = nuevaPrim.validarNumero(valor, j);
                    if (!resultado){
                        resultado = nuevaPrim.comprobarResultado(valor, i, resultado);
                    }
                }
                else{
                    System.out.println("Dame otro para la apuesta: " + i);
                    valor = lector.nextInt();
                    resultado = nuevaPrim.validarNumero(valor, j);
                    if(!resultado){
                        resultado = nuevaPrim.comprobarResultado(valor, i, resultado);
                    }
                }
            }/* Envio el valor, y la posicion para validar que cumple con la condicion */
            
            System.out.println(nuevaPrim.mostrarApuesta());
        }
    }
    
    public boolean comprobarResultado(int valor, int aux, boolean res){
        Scanner lector = new Scanner(System.in);
        while (res == false){
            System.out.println("Dame un número valido para la apuesta: " + aux);
            valor = lector.nextInt();
            res = this.validarNumero(valor, aux);
        }
        return res;
    }
    
}
