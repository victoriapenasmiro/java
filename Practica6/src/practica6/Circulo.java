/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Circulo implements figurasGeometricas{
    private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    /*trato aqui la excepcion, porque lo pide el ejercicio pero no tiene sentido
    porqué aquí nunca se producirá ninguna excepcion*/
    @Override
    public double calcularArea() throws Exception{
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el radio:");
        this.setRadio(lector.nextDouble());
        return Math.pow(radio,2)*Math.PI;
    }

    @Override
    public double calcularVolumen() {
        double radio;
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el radio:");
        try{
            radio = lector.nextDouble();
            if(radio<=0){
                throw new ExceptionFiguras();
            }
            else{
                this.setRadio(radio);
            }
        } catch (ExceptionFiguras e){
            e.controlarValor();
        } catch (Exception e){
            System.out.println("El radio indicado no es correcto. Indica un"
                    + " valor válido");
            calcularVolumen();
        }
        
        return (4*Math.pow(this.getRadio(),3)*Math.PI)/3;
    }

    @Override
    public void imprimirCaracteristicas() throws Exception{
        Scanner lector = new Scanner(System.in);
        double area;
        double volumen;
        System.out.println("Calculadora de Victoria Peñas");      
        System.out.println("¿De qué figura quieres ves las características?");
        System.out.println("1. Circulo");
        System.out.println("2. Esfera");
        int opcion = lector.nextInt();
        Circulo nuevoCirculo = new Circulo();
        switch (opcion) {
            case 1:
                area = nuevoCirculo.calcularArea();
                System.out.print("Un circulo con ");
                //convierto el número a un formato de dos decimales
                System.out.print(nuevoCirculo.getRadio());
                System.out.print(" metros de radio tiene un área de " + area);
                System.out.printf("%.2f",area);
                break;
            case 2:
                volumen = nuevoCirculo.calcularVolumen();
                System.out.print("Un esfera con ");
                //este tipo de print me permite dar formato al double que me retorna este método.
                System.out.print(nuevoCirculo.getRadio());
                System.out.println(" metros de radio tiene un volumen de " + volumen);
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
            System.out.println("1. Calcular el área de un circulo");
            System.out.println("2. Calcular el volumen de una esfera");
            System.out.println("3. Imprimir características de un círculo o esfera");
            System.out.println("4. Salir");
            int opcion = lector.nextInt();
            Circulo nuevoCirculo = new Circulo();
            switch (opcion) {
                case 1:
                    //este tipo de print me permite dar formato al double que me retorna este método.
                    System.out.printf("%.2f",nuevoCirculo.calcularArea());
                    break;
                case 2:
                    //este tipo de print me permite dar formato al double que me retorna este método.
                    System.out.printf("%.2f",nuevoCirculo.calcularVolumen());
                    break;
                case 3:
                    nuevoCirculo.imprimirCaracteristicas();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("La opción indicada no es correcta,"
                            + "por favor, indica otra.");
            }
        } while (exit == false);  
    }   
    
}
