/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class VTC extends Vehiculo{
    private double horasTrabajadas;
    private int radio;
    private String ciudad;

    public VTC() {
    }

    public VTC(double horasTrabajadas, int radio, String ciudad, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.setHorasTrabajadas(horasTrabajadas);
        this.setRadio(radio);
        this.setCiudad(ciudad);
    }

    public VTC(VTC vtc, String ciudad, Vehiculo vehiculo) {
        super(vehiculo);
        this.setHorasTrabajadas(vtc.horasTrabajadas);
        this.setRadio(vtc.radio);
        this.setCiudad(vtc.ciudad);
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public void mostrarAtributos(){
        super.mostrarAtributos();
        System.out.println("número máximo de horas trabajadas: " + this.getHorasTrabajadas()
        + " radio de acción en km por el que pueden trabajar" + this.getHorasTrabajadas()
        + " ciudad para la que trabajan: " + this.getCiudad());
    }
    
    @Override
    public VTC crearVehiculo(){
        Scanner lector = new Scanner(System.in);
        super.crearVehiculo();
        System.out.println("Dime el número máximo de horas trabajadas:");
        this.setHorasTrabajadas(lector.nextDouble());
        System.out.println("Dime el radio de acción en km por el que pueden trabajar:");
        this.setRadio(Integer.parseInt(lector.nextLine()));
        System.out.println("Dime la ciudad para la que trabajan:");
        this.setCiudad(lector.nextLine());
        return this;
    }
}
