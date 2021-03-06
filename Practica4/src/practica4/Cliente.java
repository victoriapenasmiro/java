/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class Cliente {
    private int codCliente;
    private String password;
    private String nombre;
    private String apellidos;
    private int telefono;
    private final ArrayList <Pelicula> peliculasReservadas = new ArrayList <Pelicula>(); //pongo final para que la instancia NO SE PUEDA MODIFICAR

    public Cliente(int codCliente, String password, String nombre, String apellidos, int telefono) {
        this.codCliente = codCliente;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public Cliente() {
    }
    
    public Cliente(Cliente cliente) {
        this.setCodCliente(cliente.codCliente);
        this.setPassword(cliente.password);
        this.setNombre(cliente.nombre);
        this.setApellidos(cliente.apellidos);
        this.setTelefono(cliente.telefono);
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Pelicula> getPeliculasReservadas() {
        return peliculasReservadas;
    }

    public static void altaCliente(ArrayList <Cliente> clientes){
        Scanner lector = new Scanner(System.in);
        Cliente nuevoCliente = new Cliente();
        System.out.println("Dime tu nombre");
        nuevoCliente.setNombre(lector.nextLine());
        System.out.println("Dime tus apellidos");
        nuevoCliente.setApellidos(lector.nextLine());
        System.out.println("Dime tu teléfono");
        nuevoCliente.setTelefono(Integer.parseInt(lector.nextLine()));
        System.out.println("Escribe una contraseña");
        nuevoCliente.setPassword(lector.nextLine());
        nuevoCliente.setCodCliente(clientes.size()+1);
        clientes.add(nuevoCliente);
        System.out.println("Tu codigo de usuario es: " + clientes.size());
    }
    
    public void altaPeliReservada(Pelicula pelicula){
        this.peliculasReservadas.add(pelicula);
    }
    //metodo de instancia para ver las pelis reservadas de un cliente
    public void verPeliculasReservadas(){
        System.out.println("Las peliculas reservadas son");
        for (int i=0;i<this.getPeliculasReservadas().size();i++){
            System.out.println("id: " + peliculasReservadas.get(i).getId() + " titulo: " +
            peliculasReservadas.get(i).getTitulo() + " año: " + peliculasReservadas.get(i).getAnio()+
            " director: " + peliculasReservadas.get(i).getDirector() + " duración: " +
            peliculasReservadas.get(i).getDuracion());
        }
    }
    
}