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
public class Taxi extends Vehiculo{
    private int licencia;
    private boolean estado;
    private int numTaxistas;

    public Taxi() {
    }

    public Taxi(int licencia, boolean estado, int numTaxistas, int id, String matricula, String modelo, int potencia) {
        super(id, matricula, modelo, potencia);
        this.setLicencia(licencia);
        this.setEstado(estado);
        this.setNumTaxistas(numTaxistas);
    }

    public Taxi(Taxi taxi, Vehiculo vehiculo) {
        super(vehiculo);
        this.setLicencia(taxi.licencia);
        this.setEstado(taxi.estado);
        this.setNumTaxistas(taxi.numTaxistas);
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public boolean isEstado() {
        if (estado==false){
            System.out.println("ocupado");
        }
        else{
            System.out.println("libre");
        }
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumTaxistas() {
        return numTaxistas;
    }

    public void setNumTaxistas(int numTaxistas) {
        this.numTaxistas = numTaxistas;
    }    
    
    @Override
    public void mostrarAtributos(){
        super.mostrarAtributos();
        System.out.println("licencia: " + this.getLicencia() + " estado: " + this.isEstado()
        + " número de Taxistas que trabajan con esta licencia: " + this.getNumTaxistas());
    }
    
    @Override
    public Taxi crearVehiculo(){
        Scanner lector = new Scanner(System.in);
        int aux = 0; //auxiliar para comprobar que cargan bien el valor del estado
        super.crearVehiculo();
        this.setLicencia(Integer.parseInt(lector.nextLine()));
        System.out.println("El numero de licencia asignado es: " + this.getLicencia());
        while (aux == 0 && (aux != 1 || aux !=2)){
            System.out.println("Dime el estado. Siendo 1 = libre y 2 = ocupado");
            aux = Integer.parseInt(lector.nextLine());
        }
        if (aux==1){
            this.setEstado(true);
        }
        else if (aux==2){
            this.setEstado(false);
        }
        System.out.println("Indica el número de Taxistas que trabajan con la licencia: "
        + this.getLicencia());
        this.setNumTaxistas(lector.nextInt());
        return this;
    }
}
