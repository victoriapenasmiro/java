/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5Ejercicio2;

import java.util.ArrayList;
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
        System.out.println("licencia: " + this.getLicencia() + " estado: "
        + " número de Taxistas que trabajan con esta licencia: " + this.getNumTaxistas());
        if (this.isEstado() == false){
            System.out.println("estado: Ocupado");
        }
        else{
            System.out.println("estado: Libre");
        }
    }
    
    @Override
    public Taxi crearVehiculo(){
        Scanner lector = new Scanner(System.in);
        int aux = 0; //auxiliar para comprobar que cargan bien el valor del estado
        super.crearVehiculo();
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
        System.out.println("Indica el número de Taxistas que trabajan con esta licencia: ");
        this.setNumTaxistas(lector.nextInt());
        return this;
    }
    
    public static void buscarTaxiLibre(ArrayList<Vehiculo> vehiculos){
        boolean libre = false; //aux para romper el while
        int i = 0;//aux para ir incrementando el while
        if (vehiculos.isEmpty()){
            System.out.println("No hay taxis disponibles");
        }
        else{
            while(libre == false && i<vehiculos.size()){
                //hago un casting del objeto que recupero de la array porque por
                //defecto me coge los metodos dela clase padre
                if(vehiculos.get(i) instanceof Taxi && ((Taxi)vehiculos.get(i)).isEstado() == true){
                    System.out.println("El taxi libre es:");
                    vehiculos.get(i).mostrarAtributos();
                    //lo reservamos y cambio estado a ocupado
                    ((Taxi)vehiculos.get(i)).setEstado(false);
                    libre = true;
                //hago i+1 porqué en el momento que el for llegue a recorrer toda
                //la lista y no haya entrado en el if anterior es porque no hay taxis disponibles
                }else if (i+1 == vehiculos.size()){
                    System.out.println("No hay taxis disponibles");
                    libre = true;//para romper el bucle
                    }
                else{
                    i++; //sigo buscando
                }
                }
            }
        }
    
    public static void cambiarEstadoLibre (ArrayList<Vehiculo> vehiculos){
        Scanner lector = new Scanner(System.in);
        int id;//auxiliar para localizar el id
        boolean localizador = false; // auxiliar para romper el while
        int aux = 0; //auxiliar para ir incrementando el while
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados en el sistema");
        }
        else{
            System.out.println("Dime el id:");
            id = lector.nextInt();
            if (id>vehiculos.size()){
                System.out.println("El id indicado no existe.");
            }
            else{
                while (localizador == false && aux<vehiculos.size()){
                    if(vehiculos.get(aux).getId() != id){
                        aux+=1;
                    }
                    else if (vehiculos.get(aux).getId() == id && vehiculos.get(aux) instanceof Taxi){
                        if (((Taxi)vehiculos.get(aux)).isEstado() == true){
                            System.out.println("El taxi indicado ya está disponible. No hay que tomar acción.");
                            localizador = true;
                        }
                        else{
                            System.out.println("El taxi con id: " + vehiculos.get(aux).getId() + " se ha marcado como libre");
                            ((Taxi)vehiculos.get(aux)).setEstado(true);
                            localizador = true;
                        }
                    }
                    else if (vehiculos.get(aux).getId() == id && vehiculos.get(aux) instanceof Taxi == false){
                        System.out.println("El id indicado no es de un Taxi.");
                        localizador = true;
                    }
                }
            }
        }
    }
}
