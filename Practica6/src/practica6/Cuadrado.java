/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author victoriapenas
 */
public class Cuadrado implements figurasGeometricas{
    private double arista;

    public Cuadrado() {
    }

    public Cuadrado(double arista) {
        this.setArista(arista);
    }

    public double getArista() {
        return arista;
    }

    public void setArista(double arista) {
        this.arista = arista;
    }
    
    //elevo la excepcion hasta el main
    public void mostrarMenu() throws Exception{
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Calcular el área de un cuadrado");
            System.out.println("2. Calcular el volumen de un cubo");
            System.out.println("3. Imprimir características de un cuadrado o cubo");
            System.out.println("4. Salir");
            int opcion = lector.nextInt();
            Cuadrado cuadrado = new Cuadrado();
            switch (opcion) {
                case 1:
                    //este tipo de print me permite dar formato al double que me retorna este método.
                    System.out.printf("%.2f",cuadrado.calcularArea());
                    break;
                case 2:
                    //este tipo de print me permite dar formato al double que me retorna este método.
                    System.out.printf("%.2f",cuadrado.calcularVolumen());
                    break;
                case 3:
                    cuadrado.imprimirCaracteristicas();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("La opción indicada no es correcta,"
                            + "por favor, indica otra.");
                }
        }while (exit == false);  
    }   

    @Override
    public double calcularArea() throws Exception {
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el tamaño en metros del lado:");
        this.setArista(lector.nextDouble());
        return Math.pow(this.getArista(),2);
    }

    @Override
    public double calcularVolumen() {
        double arista;
        try{
            Scanner lector = new Scanner(System.in);
            System.out.println("Dime el tamaño en metros de la arista:");
            arista = lector.nextDouble();
            if (arista<=0){
                throw new ExceptionFiguras();
            }else{
                this.setArista(arista);
            }
        }catch (InputMismatchException e){
//este tipo de excepcion controla que me inserte un valor por teclado del tipo que esperamos
            System.out.println("Por favor, indtroduce un valor numérico. Inténtalo de nuevo");
            this.calcularVolumen();
        } catch (ExceptionFiguras ex) {
            ex.controlarValor();
            //el siguiente método da problemas, no respecta el orden del print --> reportado a rafa
            ex.printStackTrace();
            this.calcularVolumen();
        }
        return Math.pow(this.getArista(),3);
    }

    @Override
    public void imprimirCaracteristicas() throws Exception {
        Scanner lector = new Scanner(System.in);
        double area;
        double volumen;
        System.out.println("Calculadora de Victoria Peñas");
        System.out.println("¿De qué figura quieres ves las características?");
        System.out.println("1. Cuadrado");
        System.out.println("2. Cubo");
        int opcion = lector.nextInt();
        Cuadrado cuadrado = new Cuadrado();
        switch (opcion) {
            case 1:
                area = cuadrado.calcularArea();
                System.out.print("Un cuadrado con ");
                //convierto el número a un formato de dos decimales
                System.out.print(cuadrado.getArista());
                System.out.print(" metros de cada lados tiene un área de " + area);
                System.out.printf("%.2f",area);
                break;
            case 2:
                volumen = cuadrado.calcularVolumen();
                System.out.print("Un cubo con ");
                //este tipo de print me permite dar formato al double que me retorna este método.
                System.out.print(cuadrado.getArista());
                System.out.println(" metros de arista tiene un volumen de " + volumen);
                System.out.printf("%.2f",volumen);
                break;
            default:
                System.out.println("La opción indicada no es valida.");
        }   
    }
}