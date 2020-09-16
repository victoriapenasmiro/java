/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author victoriapenas
 */
public abstract class Carta {
    
    private int numCarta;

    public Carta() {
    }
    
    /**
     * Constructor copia
     * @param c1 Carta que se debe copiar
     */
    public Carta(Carta c1) {
        this.setNumCarta(c1.getNumCarta());
    }

    public int getNumCarta() {
        return numCarta;
    }

    public void setNumCarta(int numCarta) {
        this.numCarta = numCarta;
    }

    /**
     * Método para mostrar una carta
     * @param carta recibe un objeto de tipo carta
     * @return devuelve un string con los datos de la carta
     */
    public abstract String mostrarCarta(Carta carta);
    
}
