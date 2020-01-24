/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpersonas;

import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Nif {
    private String nif;
    private String direccion;
    private String nombreMadre;
    private String nombrePadre;

    public Nif(String nif, String direccion, String nombreMadre, String nombrePadre) {
        this.setNif(nif);
        this.setDireccion(direccion);
        this.setNombreMadre(nombreMadre);
        this.setNombrePadre(nombrePadre);
    }

    public Nif() {
    }
  

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }
    
    public void solicitarDatosNif(){
        Scanner lector=new Scanner(System.in);
        System.out.println("Dime el num de dni");
        this.setNif(lector.nextLine());
        System.out.println("dime la direccion");
        this.setDireccion(lector.nextLine());
        System.out.println("el nombre de tu madre");
        this.setNombreMadre(lector.nextLine());
        System.out.println("el nombre de tu padre");
        this.setNombrePadre(lector.nextLine());
    }
    
    public void mostrarAtributosNif(){
        System.out.println("el num de dni es: "+this.getNif());
        System.out.println("la direccion es: "+this.getDireccion());
        System.out.println("el nombre de la madre es "+this.getNombreMadre());
        System.out.println("el nombre del padre es "+this.getNombrePadre());
    }
}
