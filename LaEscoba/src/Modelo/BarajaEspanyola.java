/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author victoriapenas
 */
public class BarajaEspanyola extends Baraja {

    ArrayList <Integer> cartasRepartidas = new ArrayList<>();
    ArrayList <Integer> cartasSinRepartir = new ArrayList<>();

    public BarajaEspanyola() {
        super();
        this.setNumCartasPalo(10);//¿Realmente es necesario en esta baraja?
        this.setNumCartas(39);//hay un total de 10 cartas por palo, empezamos a contar en cero
    }

    //Del 0 al 9 --> OROS
    //Del 10 al 19 --> BASTOS
    //Del 20 al 29 --> ESPADAS
    //Del 30 al 39 --> COPAS

    public ArrayList<Integer> getCartasRepartidas() {
        return cartasRepartidas;
    }

    public ArrayList<Integer> getCartasSinRepartir() {
        return cartasSinRepartir;
    }

    //TODO este método es general, que aplicaría a cualquier baraja, ¿lo metemos en la clase padre?
    //genera un número aleatorio entre 0 y max
    public static int generarAleatorio(int max) {
        // Instanciamos la clase Random
        Random random = new Random();
        return random.nextInt(max);
    }

    /**
     * Método para barajar las cartas. Crea una lista de números aleatorios
     */
    @Override
    public void inicializarBaraja() {
        int numGenerado;
        boolean existe;
        while (this.getCartasSinRepartir().size() < 40) { //mientras la lista sea inferior a 40 cartas, genero aleatorios
            numGenerado = generarAleatorio(40);
            existe = this.comprobarNumero(numGenerado);
            if (!existe){
                this.getCartasSinRepartir().add(numGenerado);
            }
        }
    }

    /**
     * Método para comprobar si el número aleatorio generado está añadido en la
     * baraja
     *
     * @param numGenerado número aleatorio generado
     * @return booleano con el resultado
     */
    public boolean comprobarNumero(int numGenerado) {
        int aux = 0;
        boolean res = false;
        if(this.getCartasSinRepartir().size() > 0){ //compruebo que la arraylist no esté vacía
            while (aux < this.getCartasSinRepartir().size() && res == false) {
                if (this.getCartasSinRepartir().get(aux) != numGenerado){
                    aux++;
                }else{
                    res = true;
                }
            }
        }
        return res;
    }
}
