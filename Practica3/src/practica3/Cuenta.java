/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.util.ArrayList;
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
    //Me declaro el Scanner que utilizaré en todos los métodos
    Scanner lector = new Scanner(System.in);

    //resto de metodos
    public Cuenta crearCuenta(ArrayList cuentas){
        System.out.println("dime tu nombre");
        this.setNombreCliente(lector.nextLine());
        this.setNumCuenta(String.valueOf(cuentas.size()+1));
        System.out.println("tu numero de cuenta es " + this.getNumCuenta());
        this.setSaldo(0);
        this.setTipoInteres(0.25);
        cuentas.add(this);
        return this;
    }
    //método para comprobar si la cuenta está dada de alta
    public static int verificarCuenta(ArrayList <Cuenta> cuentas){
        System.out.println("Dime el numero de cuenta:");
        Scanner lector1 = new Scanner(System.in);
        String numcuenta = lector1.nextLine();
        int i = 0;
        while(!numcuenta.equals(cuentas.get(i).getNumCuenta()) && i < cuentas.size()){
            i++;
        }
        if (!cuentas.get(i).getNumCuenta().equals(cuentas.get(i).getNumCuenta())){
            i=-1; // reseteo el valor para controlar si existe o no
        }
        else{
            System.out.println("cuenta valida");
        }
        return i;
    }
    
    public boolean realizarIngreso(){
        boolean resultado = false; //variable local, valor inicial = true
        double importe = 0; //inicializo la variable local
        System.out.println("Dime la cantidad que deseas ingresar:");
        importe = lector.nextDouble();
        while(importe<1){
            System.out.println("El ingreso debe ser superior a 0, por favor/"
                    + "indica una cantidad válida:");
            importe = lector.nextDouble();
        }
        this.setSaldo(getSaldo()+importe);
        resultado=true;
        if(resultado=true){
            System.out.println("Has ingresado: " + this.getSaldo() + "€");
        }
        return resultado;
    }
    
    public boolean realizarReintegro(){
        boolean resultado = false;
        double importe = 0;
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
            this.setSaldo(getSaldo()-importe);
            System.out.println("Te quedan: " + this.getSaldo() + "€.");
            resultado = true; // operacion realizada con exito
        }
        return resultado;
    }
    
    public void realizarTransferencia(Cuenta cuentaDestino, double importe){
        if(this.getSaldo()>=importe){
            this.setSaldo(this.getSaldo()-importe);
            cuentaDestino.setSaldo(getSaldo()+importe);
        }
        else{
            System.out.println("No tienes saldo suficiente para realizar"
                    + "una transferencia.");
        }
    }
}