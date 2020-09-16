/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author victoriapenas
 */
public class Vehiculo {
    //atributos de la clase vehiculo
    private int id;
    private String matricula;
    private String modelo;
    private int potencia;

    //constructor vacio
    public Vehiculo() {
        this.setId(id);
    }
    
    //constructor con parametros
    public Vehiculo(int id, String matricula, String modelo, int potencia) {
        this.setId(id);
        this.setMatricula(matricula);
        this.setModelo(modelo);
        this.setPotencia(potencia);
    }
    
    //constructor copia
    public Vehiculo(Vehiculo vehiculo) {
        this.setId(vehiculo.id);
        this.setMatricula(vehiculo.matricula);
        this.setModelo(vehiculo.modelo);
        this.setPotencia(vehiculo.potencia);
    }
    
    //getters i setters    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        //guardamos la matricula en mayúsculas
        this.matricula = matricula.toUpperCase();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        //el nombre del modelo la primera en mayúscula y el resto en minúscula
        this.modelo = modelo.substring(0, 1).toUpperCase() + modelo.substring(1);
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        Scanner lector = new Scanner(System.in);
        while (potencia <= 0){
            System.out.println("La potencia no puede ser menor o igual a cero."
                    + "Dime una potencia válida:");
            potencia = lector.nextInt();
        }
        this.potencia = potencia;
    }
    
    //métodos
    //metodo que muestra los atributos de una instancia
    public void mostrarAtributos(){
        System.out.println("ID: " + this.getId() + " matricula: " + this.getMatricula()
        + " modelo: " + this.getModelo() + " potencia: " + this.getPotencia());
        
    }
    
    //metodo que muestra los atributos de toda la array
    public static void mostrarVehiculos (ArrayList<Vehiculo> vehiculos){
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos regstrados");
        }
        else{
            for (int i=0; i<vehiculos.size();i++){
                vehiculos.get(i).mostrarAtributos();
        }
        }
    }
    
    public Vehiculo crearVehiculo(){
        Scanner lector = new Scanner (System.in);
        System.out.println("Dime la matricula");
        this.setMatricula(lector.nextLine());
        System.out.println("Dime el modelo");
        this.setModelo(lector.nextLine());
        System.out.println("Dime la potencia");
        this.setPotencia(lector.nextInt());
        return this;
    }
    
    public static void buscarVehiculo(ArrayList<Vehiculo> vehiculos){
        Scanner lector = new Scanner(System.in);
        int id;//auxiliar para localizar el id
        String matricula;//auxiliar para localizar la matricula
        boolean localizador = false; // auxiliar para romper el while
        int aux = 0; //auxiliar para ir incrementando el while
        int opcion;
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados");
        }
        else{
            System.out.println("¿Por qué dato quieres buscar el vehículo?");
            System.out.println("1. id");
            System.out.println("2. matricula");
            opcion = Integer.parseInt(lector.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Dime el id:");
                    id = lector.nextInt();
                    while (localizador == false && aux<vehiculos.size()){
                        if(vehiculos.get(aux).getId() != id){
                                aux+=1;
                            }
                        else if (vehiculos.get(aux).getId() == id){
                            vehiculos.get(aux).mostrarAtributos();
                            localizador = true;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Dime la matricula");
                    matricula = lector.nextLine();
                    while (localizador == false && aux<vehiculos.size()){
                      //si la matricula no coincide en esta posicion incremento la auxiliar
                        if(!vehiculos.get(aux).getMatricula().equals(matricula)){
                            aux+=1;
                            //con este if controlo que en la siguiente vuelta
                            //rompe el while y no ha encontrado vehiculos
                            if (aux >= vehiculos.size()){
                                System.out.println("No hay vehiculos con esta matricula registrados");
                            }
                        }
                            //si la matricula coinice la muestro
                        else if (vehiculos.get(aux).getMatricula().equals(matricula)){
                            vehiculos.get(aux).mostrarAtributos();
                            localizador = true;
                        }
                    }
                    break;
                }
            }
        }
}
