/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Scanner;

/**
 *Clase Repartidor, que se caracteriza por ser una especialización de Empleado,
 * y además tener los atributos horas trabajadas, zona. Asegúrate que de esta
 * clase nunca se podrán crear subclases.
 * @author victoriapenas
 */
final public class Repartidor extends Empleado{
    private double horasTrabajadas;
    private String zona;

    public Repartidor() {
    }

    public Repartidor(double horasTrabajadas, String zona, String nombre, String apellido1, String apellido2, String nif, int edad, double salario) {
        super(nombre, apellido1, apellido2, nif, edad, salario);
        this.setHorasTrabajadas(horasTrabajadas);
        this.setZona(zona);
    }

    
    public Repartidor(Repartidor r1, Empleado e1) {
        super(e1);
        this.setHorasTrabajadas(r1.horasTrabajadas);
        this.setZona(r1.zona);
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    @Override
    public void mostrarAtributos(){
        super.mostrarAtributos();//con super llamo al metodo del padre
        System.out.println("horas: " + this.getHorasTrabajadas() + "zona: "
                + this.getZona());
    }
    
    @Override
    public Repartidor pedirAlta(){
        Scanner lector = new Scanner(System.in);
        super.pedirAlta(); //llamo al método del padre
        System.out.println("dime las horas trabajadas");
        this.setHorasTrabajadas(Double.parseDouble(lector.nextLine()));
        System.out.println("Dime la zona");
        this.setZona(lector.nextLine());
        
        return this;
    }
}
