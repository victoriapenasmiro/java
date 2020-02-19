/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 *
 */
public class Empleado {
    //atributos
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private int edad;
    private double salario;
    
    //constructor vacio
    public Empleado() {
    }
    
    //constructor con parámetros
    public Empleado(String nombre, String apellido1, String apellido2, String nif, int edad, double salario) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNif(nif);
        this.setEdad(edad);
        this.setSalario(salario);
    }
    
    //constructor copia
    public Empleado(Empleado e1) {
        this.setNombre(e1.nombre);
        this.setApellido1(e1.apellido1);
        this.setApellido2(e1.apellido2);
        this.setNif(e1.nif);
        this.setEdad(e1.edad);
        this.setSalario(e1.salario);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        //convierto a mayúsculas el primer caracter del nombre
        this.nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        //convierto a mayúsculas el primer caracter del nombre
        this.apellido1 = apellido1.substring(0, 1).toUpperCase() + apellido1.substring(1);
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        //convierto a mayúsculas el primer caracter del nombre
        this.apellido2 = apellido2.substring(0, 1).toUpperCase() + apellido2.substring(1);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        Scanner lector = new Scanner(System.in);
        while (edad < 16){
            System.out.println("La edad debe ser igual o mayor a 16 años."
                    + "Dime una edad válida:");
            edad = lector.nextInt();
        }
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void mostrarAtributos(){
        System.out.println(this.getNombre() + " " + this.getApellido1() + " "
        + this.getApellido2() + " " + "edad: " + this.getEdad() + " nif: " +
        this.getNif() + " salario: " + this.getSalario());
    }
    
    public Empleado pedirAlta(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el nombre");
        this.setNombre(lector.nextLine());
        System.out.println("Dime el primer apellido");
        this.setApellido1(lector.nextLine());
        System.out.println("Dime el segundo apellido");
        this.setApellido2(lector.nextLine());
        System.out.println("Dime el DNI");
        this.setNif(lector.nextLine());
        System.out.println("Dime el edad");
        this.setEdad(Integer.parseInt(lector.nextLine()));
        System.out.println("Dime el salario");
        this.setSalario(lector.nextDouble());
        
        return this;
    }
}
