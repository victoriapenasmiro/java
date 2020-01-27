/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Cuenta {
    //atributos
    private String nombreCliente;
    private String numCuenta;
    private double tipoInteres;
    private double saldo;
    
    //contructores
    //constructor con todos los parámetros
    public Cuenta(String nombreCliente, String numCuenta, double tipoInteres,
            double saldo) {
        this.setNombreCliente(nombreCliente);
        this.setNumCuenta(numCuenta);
        this.setTipoInteres(tipoInteres);
        this.setSaldo(saldo);
    }
    //Constructor por defecto.
    public Cuenta() {
    }
    //constructor copia
    public Cuenta(Cuenta c1) {
        this.setNombreCliente(c1.getNombreCliente());
        this.setNumCuenta(c1.getNumCuenta());
        this.setTipoInteres(c1.getTipoInteres());
        this.setSaldo(c1.getSaldo());
    }
    
    //setters y getters

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //resto de metodos
    public boolean ingreso(){
        boolean resultado = false; //variable local, valor inicial = true
        double importe = 0; //inicializo la variable local
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime la cantidad que deseas indicar:");
        importe = lector.nextDouble();
        while(importe<1){
            System.out.println("El ingreso debe ser superior a 0, por favor/"
                    + "indica una cantidad válida:");
            importe = lector.nextDouble();
        }
        //this.saldo+=importe; // entiendo que esta opción  no es correcta,
        //ya que tengo que utilizar el setter para acceder al atributo.
        //verificar con rafa
        this.setSaldo(saldo+=importe);
        resultado=true;
        if(resultado=true){
            System.out.println("Has ingresado: " + this.getSaldo() + "€");
        }
        return resultado;
    }
    
    public boolean reintegro(){
        boolean resultado = false;
        double importe = 0;
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el importe a retirar:");
        importe = lector.nextDouble();
        while(importe<1){
            System.out.println("El ingreso debe ser superior a 0, por favor/"
                    + "indica una cantidad válida:");
            importe = lector.nextDouble();
        }
        if(this.getSaldo()<importe){
            System.out.println("No tienes suficiente saldo para sacar.");
        }
        else{
            this.setSaldo(saldo-importe);
            System.out.println("Te quedan: " + this.getSaldo() + "€.");
            resultado = true; // operacion realizada con exito
        }
        return resultado;
    }
}