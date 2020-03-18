/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.ArrayList;
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

    public int validarNumero(int valor, int posicion) {
        Scanner lector = new Scanner (System.in);
        while (valor < 1 || valor>49){
            System.out.println("Los números de la primitiva deben estar comprendidos"
                    + " entre 1 y 49.");
            valor = lector.nextInt();
        }
        if (valor >= 1 && valor <= 49){
            this.getListaNum()[posicion] = valor;
        }
        
        return valor;
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

    public Apuesta crearApuestaPrimitiva(ArrayList <Apuesta> apuestasUsuarios) throws ExceptionSimulador{
        Scanner lector = new Scanner(System.in);
        /*solo pido el nombre una vez, si el objeto que llama a esta función
        ya existe, no le vuelvo a pedir su nombre*/
        super.pedirNombre();
        int valor = 0;
        for (int j = 0; j<this.getListaNum().length; j++){
            if (j == 0){
                System.out.println("Dime un numero para la apuesta: ");
                valor = this.validarNumero(lector.nextInt(), j);
                /*compruebo que el numero esté entre 1 y 49, Envio el valor, y
                la posicion para validar que cumple con la condicion */
            }
            else{
                System.out.println("Dame otro para la apuesta: ");
                valor = this.validarNumero(lector.nextInt(), (j));
            }
        }
        System.out.println("primitiva creada");
        System.out.println(this.mostrarApuesta());
        
        apuestasUsuarios.add(this);
        
        return this;//devuelvo el objeto
    }
    
    //habia pensado en hacer un metodo abstract en Apuesta, pero como este metodo es static no puedo hacerlo.
    public static int pedirCantidadPrimitivas(){
        Scanner lector = new Scanner (System.in);
        int totalPrimitivas;
        totalPrimitivas = lector.nextInt();
        return totalPrimitivas;
    }
}
