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
public class Cilindro implements figurasGeometricas{
    private double radio;
    private double altura;

    public Cilindro() {
    }

    public Cilindro(double radio, double altura) {
        this.setAltura(altura);
        this.setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea() throws Exception {
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el tamaño en metros de la altura:");
        this.setAltura(lector.nextDouble());
        System.out.println("Dime el tamaño en metros del radio");
        this.setRadio(lector.nextDouble());
        return 2*Math.PI*this.getRadio()*(this.getAltura()+this.getRadio());
    }

    @Override
    public double calcularVolumen() {
        Scanner lector = new Scanner(System.in);
        double altura;
        double radio;
        try{
            System.out.println("Dime el tamaño en metros de la altura:");
            altura = lector.nextDouble();
            
            System.out.println("Dime el tamaño en metros del radio");
            radio = lector.nextDouble();
            
            if (altura <=0 || radio <=0){
                throw new ExceptionFiguras();
            }
            else{
                this.setRadio(radio);
                this.setAltura(altura);
            }
        }catch (ExceptionFiguras ex){
            ex.controlarValor();
        }
        catch (InputMismatchException e){
            System.out.println("Por favor, indtroduce un valor numérico. Inténtalo de nuevo");
            this.calcularVolumen();
        }
        return Math.PI*(Math.pow(this.getRadio(), 2))*this.getAltura();
    }

    @Override
    public void imprimirCaracteristicas() throws Exception {
        double area;
        double volumen;
        Cilindro nuevoCilindro = new Cilindro();
        area = nuevoCilindro.calcularArea();
        System.out.print("Un cilindro con una altura de");
        System.out.print(nuevoCilindro.getAltura());
        System.out.print(" metros y una base de ");
        System.out.println(nuevoCilindro.getRadio());
        System.out.print("tiene un área de ");
        //convierto el número a un formato de dos decimales
        System.out.printf("%.2f",area);
        volumen = nuevoCilindro.calcularVolumen();
        System.out.print("Y un volumen de:");
        System.out.printf("%.2f",volumen);
    }
    
        //elevo la excepcion hasta el main
    public void mostrarMenu() throws Exception{
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Calcular el área");
            System.out.println("2. Calcular el volumen");
            System.out.println("3. Imprimir características de un");
            System.out.println("4. Salir");
            int opcion = lector.nextInt();
            Cilindro nuevoCilindro = new Cilindro();
            switch (opcion) {
                case 1:
                    //este tipo de print me permite dar formato al double que me retorna este método.
                    System.out.printf("%.2f",nuevoCilindro.calcularArea());
                    break;
                case 2:
                    //este tipo de print me permite dar formato al double que me retorna este método.
                    System.out.printf("%.2f",nuevoCilindro.calcularVolumen());
                    break;
                case 3:
                    nuevoCilindro.imprimirCaracteristicas();
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
}
