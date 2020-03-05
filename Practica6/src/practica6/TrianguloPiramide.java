/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victoriapenas
 */
public class TrianguloPiramide implements figurasGeometricas{
    private double altura;
    private double base;

    public TrianguloPiramide() {
    }

    public TrianguloPiramide(double altura, double base) {
        this.setAltura(altura);
        this.setBase(base);
    }
    
    //constructor copia
    public TrianguloPiramide(TrianguloPiramide obj) {
        this.setAltura(obj.altura);
        this.setBase(obj.base);
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    
    @Override
    public double calcularArea() throws Exception {
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el tamaño en metros de la altura:");
        this.setAltura(lector.nextDouble());
        System.out.println("Dime el tamaño en metros de la base");
        this.setBase(lector.nextDouble());
        return (this.getAltura()*this.getAltura())/2;
    }

    @Override
    public double calcularVolumen() {
        Scanner lector = new Scanner(System.in);
        double altura;
        double base;
        try{
            System.out.println("Dime el tamaño en metros de la altura:");
            altura = lector.nextDouble();
            System.out.println("Dime el tamaño en metros de la base");
            base = lector.nextDouble();
            if (altura<=0 || base <=0){
                throw new ExceptionFiguras();
            }
            else{
                this.setBase(base);
                this.setAltura(altura);
            }
        }catch (InputMismatchException e){
            System.out.println("Por favor, indtroduce un valor numérico. Inténtalo de nuevo");
            this.calcularVolumen();
        } catch (ExceptionFiguras ex) {
            ex.controlarValor();
        }
        return (this.getAltura()*Math.pow(this.getBase(), 2))/3;
    }

    @Override
    public void imprimirCaracteristicas() throws Exception {
        Scanner lector = new Scanner(System.in);
        double area;
        double volumen;
        System.out.println("Calculadora de Victoria Peñas");
        System.out.println("¿De qué figura quieres ves las características?");
        System.out.println("1. Triángulo");
        System.out.println("2. Pirámide");
        int opcion = lector.nextInt();
        TrianguloPiramide nuevoTriangulo = new TrianguloPiramide();
        switch (opcion) {
            case 1:
                area = nuevoTriangulo.calcularArea();
                System.out.print("Un triángulo con una altura de");
                System.out.print(nuevoTriangulo.getAltura());
                System.out.print(" metros y una base de ");
                System.out.println(nuevoTriangulo.getBase());
                System.out.print("tiene un área de ");
                //convierto el número a un formato de dos decimales
                System.out.printf("%.2f",area);
                break;
            case 2:
                volumen = nuevoTriangulo.calcularVolumen();
                System.out.print("Una pirámide con ");
                System.out.print(nuevoTriangulo.getAltura());
                System.out.println(" metros de altura y " + nuevoTriangulo.getBase() +
                        "metros de base tiene un volumen de " + volumen);
                System.out.printf("%.2f",volumen);
                break;
            default:
                System.out.println("La opción indicada no es valida.");
        }   
    }
    
        //elevo la excepcion hasta el main
    public void mostrarMenu() throws Exception{
        Scanner lector = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("\n=============== MENU PRINCIPAL ============");
            System.out.println("1. Calcular el área de un triángulo");
            System.out.println("2. Calcular el volumen de una pirámide");
            System.out.println("3. Imprimir características de un triángulo o pirámide");
            System.out.println("4. Salir");
            int opcion = lector.nextInt();
            TrianguloPiramide nuevoTriangulo = new TrianguloPiramide();
            switch (opcion) {
                case 1:
                    //este tipo de print me permite dar formato al double que me retorna este método.
                    System.out.printf("%.2f",nuevoTriangulo.calcularArea());
                    break;
                case 2:
                    //este tipo de print me permite dar formato al double que me retorna este método.
                    System.out.printf("%.2f",nuevoTriangulo.calcularVolumen());
                    break;
                case 3:
                    nuevoTriangulo.imprimirCaracteristicas();
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
