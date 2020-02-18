/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoherencia;

/**
 *
 * @author victoriapenas
 */
public class Empleado extends Persona{
    private double sueldo;

    public Empleado() {
    }

    //creo el constructor con todos los atributos de persona y empleado
    public Empleado(double sueldo, String nombre, String apellido) {
        super(nombre, apellido);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //este metodo ya existe en la clase persona y se pueden crear metodos
    //que se llamen igual, el override declara que se ha descrito
    @Override
    public void mostrarSaludo(){
        super.mostrarSaludo(); // con esto, este método hará lo que hace el método del padre y lo suyo
        System.out.println("Saludo del empleado");
    }
}
