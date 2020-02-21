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
public class Autobus extends Vehiculo{
    private int plazas;
    private int paradas;

    public Autobus() {
    }

    public Autobus(int plazas, int paradas, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.setPlazas(plazas);
        this.setParadas(paradas);
    }

    public Autobus(Autobus autobus, Vehiculo vehiculo) {
        super(vehiculo);
        this.setPlazas(autobus.plazas);
        this.setParadas(autobus.paradas);
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getParadas() {
        return paradas;
    }

    public void setParadas(int paradas) {
        Scanner lector = new Scanner(System.in);
        while (paradas < 3 || paradas>20 ){
            System.out.println("Las paradas mínimas serán 3 y las máximas 20. Dime una cantidad valida:");
            paradas = lector.nextInt();
        }
        
        this.paradas = paradas;
    }
   
    @Override
    public void mostrarAtributos(){
        super.mostrarAtributos();
        System.out.println("número de plazas: " + this.getPlazas() + 
        " número de paradas: " + this.getParadas());
    }
    
    @Override
    public Autobus crearVehiculo(){
        Scanner lector = new Scanner(System.in);
        super.crearVehiculo();
        System.out.println("Dime el número de paradas");
        this.setParadas(lector.nextInt());
        System.out.println("Dime el número de plazas");
        this.setPlazas(lector.nextInt());
        return this;
    }
}
