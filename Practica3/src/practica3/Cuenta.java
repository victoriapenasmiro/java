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
    private String pin;
    
    //contructores
    //constructor con todos los parámetros
    public Cuenta(String nombreCliente, String numCuenta, double tipoInteres,
            double saldo, String pin) {
        this.setNombreCliente(nombreCliente);
        this.setNumCuenta(numCuenta);
        this.setTipoInteres(tipoInteres);
        this.setSaldo(saldo);
        this.setPin(pin);
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
        this.setPin(c1.getPin());
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    //Me declaro el Scanner que utilizaré en todos los métodos
    Scanner lector = new Scanner(System.in);

    //resto de metodos    
    //método para comprobar si la cuenta está dada de alta
    public static int iniciarSesion(ArrayList <Cuenta> cuentas,
            String numcuenta, String pin){
        int i = 0;
        while(!numcuenta.equals(cuentas.get(i).getNumCuenta()) &&
                pin.equals(cuentas.get(i).getPin())
                && i != cuentas.size()-1){
                i++;              
        }
        //convierto el pin a string para poder revisar si existe
        if(numcuenta.equals(cuentas.get(i).getNumCuenta()) &&
                pin.equals(cuentas.get(i).getPin())){
            System.out.println("cuenta validada");
        }
        
        else{
            i=-1;
            System.out.println("Acceso denegado. Inténtalo de nuevo.");
        }
        
        return i;
    }
    // método para verificar que una cuenta existe
        public static int verificarCuenta(ArrayList <Cuenta> cuentas,
            String numcuenta){
        int i = 0;
        while(!numcuenta.equals(cuentas.get(i).getNumCuenta())
                && i != cuentas.size()-1){
                i++;              
        }
        
        if (numcuenta.equals(cuentas.get(i).getNumCuenta())){
            System.out.println("cuenta correcta");
        }
        
        else{
            i=-1;
            System.out.println("La cuenta indicada no existe."
                    + "No se puede hacer la transferencia.");
        }
        
        return i;
    }
    
    public static Cuenta crearCuenta(ArrayList <Cuenta> cuentas){
        Scanner lector = new Scanner(System.in);
        Cuenta nuevaCuenta = new Cuenta();
        System.out.println("dime tu nombre");
        nuevaCuenta.setNombreCliente(lector.nextLine());
        System.out.println("Carga un código pin de 4 dígitos");
        nuevaCuenta.setPin(lector.next());
        while(nuevaCuenta.getPin().length() != 4){
            System.out.println("formato de pin incorrecto, indica 4 digitos");
            nuevaCuenta.setPin(lector.next());
        }
        nuevaCuenta.setNumCuenta(String.valueOf(cuentas.size()+1));
        System.out.println("tu numero de cuenta es " + nuevaCuenta.getNumCuenta());
        nuevaCuenta.setSaldo(0);
        nuevaCuenta.setTipoInteres(0.25);
        cuentas.add(nuevaCuenta);
        return nuevaCuenta;
    }
        
    public boolean realizarIngreso(){
        boolean resultado = false; //variable local, valor inicial = true
        double importe; //inicializo la variable local
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
        double importe;
        System.out.println("Dime el importe a retirar:");
        importe = lector.nextDouble();
        while(importe<1){
            System.out.println("El ingreso debe ser superior a 0, por favor/"
                    + "indica una cantidad válida:");
            importe = lector.nextDouble();
        }
        if(this.getSaldo()<importe){
            System.out.println("No tienes suficiente saldo para sacar dinero.");
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
            System.out.println("Transferencia realizada con éxito."
                    + "se han transferido: " + importe + "€ desde la cuenta "
                    + this.getNumCuenta() + "a la cuenta "
                    + cuentaDestino.getNumCuenta());
        }
        else{
            System.out.println("No tienes saldo suficiente para realizar"
                    + "la transferencia.");
        }
    }
}