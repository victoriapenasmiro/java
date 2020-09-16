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
public abstract class Baraja {
    
    private int numCartas;//TODO es posible que no todas las cartas sean de palo, por ejemplo los comodines, por ese motivo sepramaos losa tributos asi
    private int numCartasPalo;

    public Baraja() {
    }
    
    public int getNumCartas() {
        return numCartas;
    }

    public void setNumCartas(int numCartas) {
        this.numCartas = numCartas;
    }

    public int getNumCartasPalo() {
        return numCartasPalo;
    }

    public void setNumCartasPalo(int numCartasPalo) {
        this.numCartasPalo = numCartasPalo;
    }

    /**
     * Método para mostrar el valor de los atributos
     * @return el valor de los atributos
     */
    @Override
    public String toString() {
        return "Baraja{" + "numCartas=" + numCartas + ", numCartasPalo=" + numCartasPalo + '}';
    }
    
    public abstract void inicializarBaraja();
    
}
