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
 * Clase Comercial, que se caracteriza por ser una especialización de Empleado,
 * y además tener los atributos ventas realizadas y comisión. Asegúrate que de
 * esta clase nunca se podrán crear subclases.
 */

//poniendo final indico que no se pueden crear subclases de esta clase, es para bloquear
final public class Comercial extends Empleado{
    private int ventas;
    private double comision;

    public Comercial() {
        super();
    }

    public Comercial(int ventas, double comision, String nombre, String apellido1, String apellido2, String nif, int edad, double salario) {
        super(nombre, apellido1, apellido2, nif, edad, salario);
        this.setVentas(ventas);
        this.setComision(comision);
    }

    //como creo el constructor copia en herencia
    public Comercial(Comercial c1, Empleado e1) {
        //super(e1.setNombre(nombre));
        this.setVentas(c1.ventas);
        this.setComision(c1.ventas);
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    @Override
    public void mostrarAtributos(){
        super.mostrarAtributos();//con super llamo al metodo del padre
        System.out.println("ventas: " + this.getVentas() + " " +
                "comision" + this.getComision());
    }
    
    @Override
    public Comercial pedirAlta(){
        Scanner lector = new Scanner(System.in);
        super.pedirAlta();
        System.out.println("Dime el total de ventas");
        this.setVentas(Integer.parseInt(lector.nextLine()));
        System.out.println("Dime la comision");
        this.setComision(lector.nextDouble());
        
        return this;
    }
}
