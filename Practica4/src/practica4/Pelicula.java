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
public class Pelicula {
    //atributos
    private int id; // id incremental
    private String titulo;
    private String director;
    private int duracion;
    private String genero;
    private int anio;//año de la pelicula
    private boolean disponibilidad;
    private int numCopias; //cantidad de copias total
    private int copiasReservadas; //Cantidad de copias reservadas
    
    //constructores
    //constructor con todos los parámetros
    public Pelicula(int id, String titulo, String director, int duracion,
            String genero, int anio, boolean disponibilidad, int numCopias,
            int copiasReservadas) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setDirector(director);
        this.setDuracion(duracion);
        this.setGenero(genero);
        this.setAnio(anio);
        this.setDisponibilidad(disponibilidad);
        this.setNumCopias(numCopias);
        this.setCopiasReservadas(copiasReservadas);
    }
    //constructor por defecto
    public Pelicula() {
    }
    
    //constructor copia
    public Pelicula(Pelicula pelicula) {
        this.setId(pelicula.id);
        this.setTitulo(pelicula.titulo);
        this.setDirector(pelicula.director);
        this.setDuracion(pelicula.duracion);
        this.setGenero(pelicula.genero);
        this.setAnio(pelicula.anio);
        this.setDisponibilidad(pelicula.disponibilidad);
        this.setNumCopias(pelicula.numCopias);
        this.setCopiasReservadas(pelicula.copiasReservadas);
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }

    public int getCopiasReservadas() {
        return copiasReservadas;
    }

    public void setCopiasReservadas(int copiasReservadas) {
        this.copiasReservadas = copiasReservadas;
    }
    
    public static void addPelicula(ArrayList <Pelicula> peliculas, int limite){
        Scanner lector = new Scanner(System.in);
        Pelicula nuevaPeli = new Pelicula();
        System.out.println("dime la cantidad de copias a introducir");
        int copias = Integer.parseInt(lector.nextLine());
        if (peliculas.size()+copias <= 3000){
            nuevaPeli.setCopiasReservadas(0);
            nuevaPeli.setNumCopias(copias);
            nuevaPeli.setDisponibilidad(true);
            nuevaPeli.setId(peliculas.size()+1);
            System.out.println("Dime el título de la película");
            nuevaPeli.setTitulo(lector.nextLine());
            System.out.println("dime el año");
            nuevaPeli.setAnio(Integer.parseInt(lector.nextLine()));
            System.out.println("Dime el director");
            nuevaPeli.setDirector(lector.nextLine());
            System.out.println("dime la duración de la pelicula");
            nuevaPeli.setDuracion(Integer.parseInt(lector.nextLine()));
            System.out.println("dime el género");
            nuevaPeli.setGenero(lector.nextLine());
            peliculas.add(nuevaPeli);//añado la pelicula a la lista
        }
        
        else{
            System.out.println("el videoclub no puede almacenar más copias");
        }
    }
    
    public static void listarPeliculas (ArrayList <Pelicula> peliculas){
        for (int i=0;i<peliculas.size();i++){
            System.out.println("id: " + peliculas.get(i).getId() + " titulo: " +
            peliculas.get(i).getTitulo() + " año: " + peliculas.get(i).getAnio()+
            " director: " + peliculas.get(i).getDirector() + " duración: " +
            peliculas.get(i).getDuracion());
            if (peliculas.get(i).isDisponibilidad() == true){
                System.out.println("Esta disponible");
            }
            else{
                System.out.println("No disponible");
            }
        }
    }
    
    public static void reservarPelicula (ArrayList <Pelicula> peliculas, Cliente cliente){
        Scanner lector = new Scanner(System.in);
        listarPeliculas(peliculas);
        System.out.println("Dime el id de la pelicula que quieres reservar");
        int id = lector.nextInt();
        if (id > peliculas.size()){
            System.out.println("El id indicado no existe");
        }
        //resto 1 porque el id empieza en 1 y con el get recupero desde la posicion 0
        else if (peliculas.get(id-1).isDisponibilidad() == false){
            System.out.println("no está disponible la película.");
        }
        else{
            System.out.println("Película reservada");
            //actualizo la cantidad de copias reservadas
            peliculas.get(id-1).setCopiasReservadas(peliculas.get(id-1).getCopiasReservadas()+1);
            //añado la pelicula al cliente
            cliente.altaPeliReservada(peliculas.get(id-1));
            //si ya no hay copias, cambio la disponibilidad de la pelicula
            if (peliculas.get(id-1).getCopiasReservadas() == peliculas.get(id-1).getNumCopias()){
                peliculas.get(id-1).setDisponibilidad(false);
            }
        }
    }
    
    public static void buscarPelicula(ArrayList <Pelicula> peliculas){
        Scanner lector = new Scanner(System.in);
        //me delaro una lista que utilizaré para añadir los resultados que
        //encuentre y llamar a la función listarPeliculas
        ArrayList <Pelicula> pelisEncontradas = new ArrayList <Pelicula>();
        System.out.println("¿indica por qué dato quieres buscar?");
        System.out.println("1) por título" + "\n2) por director" +
        "\n3) por género" + "\n4) por año" +"\n5) por duración");
        int dato = Integer.parseInt(lector.nextLine());
        System.out.println("Introduce el texto que quieres que aparezca"
                + "en la búsqueda: ");
        String texto = lector.nextLine();
        switch (dato){
            case 1:
                for (int i=0;i<peliculas.size();i++){
                    if (peliculas.get(i).getTitulo().contains(texto)){
                        pelisEncontradas.add(peliculas.get(i));
                    }
                }
                //si la lista esta vacia
                if (pelisEncontradas.isEmpty()){
                    System.out.println("No se ha encontrado ninguna pelicula"
                            + "que contenga: " + texto + " en Titulo");
                }
                else{
                    listarPeliculas(pelisEncontradas);
                }
                break;
            case 2:
                for (int i=0;i<peliculas.size();i++){
                    if (peliculas.get(i).getDirector().contains(texto)){
                        pelisEncontradas.add(peliculas.get(i));
                    }
                }
                //si la lista esta vacia
                if (pelisEncontradas.isEmpty()){
                    System.out.println("No se ha encontrado ninguna pelicula"
                            + "que contenga: " + texto + " en Director");
                }
                else{
                    listarPeliculas(pelisEncontradas);
                }
                break;
            case 3:
                for (int i=0;i<peliculas.size();i++){
                    if (peliculas.get(i).getGenero().contains(texto)){
                        pelisEncontradas.add(peliculas.get(i));
                    }
                }
                //si la lista esta vacia
                if (pelisEncontradas.isEmpty()){
                    System.out.println("No se ha encontrado ninguna pelicula"
                            + "que contenga: " + texto + " en genero");
                }
                else{
                    listarPeliculas(pelisEncontradas);
                }
                break;
            case 4:
                for (int i=0;i<peliculas.size();i++){
                    //convierto el año a string para poder usar uel método contains
                    if (String.valueOf(peliculas.get(i).getAnio()).contains(texto)){
                        pelisEncontradas.add(peliculas.get(i));
                    }
                }
                //si la lista esta vacia
                if (pelisEncontradas.isEmpty()){
                    System.out.println("No se ha encontrado ninguna pelicula"
                            + "que contenga: " + texto + " en año");
                }
                else{
                    listarPeliculas(pelisEncontradas);
                }
                break;
            case 5:
                for (int i=0;i<peliculas.size();i++){
                    //convierto el año a string para poder usar uel método contains
                    if (String.valueOf(peliculas.get(i).getDuracion()).contains(texto)){
                        pelisEncontradas.add(peliculas.get(i));
                    }
                }
                //si la lista esta vacia
                if (pelisEncontradas.isEmpty()){
                    System.out.println("No se ha encontrado ninguna pelicula"
                            + "que contenga: " + texto + " en duración");
                }
                else{
                    listarPeliculas(pelisEncontradas);
                }
                break;
        }
    }
    
    //enseño todas las pelis reservadas
    public static void mostrarPelisReservadas(ArrayList <Cliente> clientes){
        System.out.println("Las peliculas reservadas son:");
        for (int i=0;i<clientes.size();i++){
            if(clientes.get(i).getPeliculasReservadas().size() > 0){
                System.out.println("Datos del cliente:");
                System.out.println(clientes.get(i).getNombre() + " " +
                clientes.get(i).getApellidos() + " con codigo de cliente: " +
                clientes.get(i).getCodCliente());
                clientes.get(i).verPeliculasReservadas();
            }
        }
    }
}
