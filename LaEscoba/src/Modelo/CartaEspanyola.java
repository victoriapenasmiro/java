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
public class CartaEspanyola extends Carta{
    
    /**
     * todo, CONSIDERO QUE ESTA contante es algo general de la baraja española, ¿lo meto en esa clase?
     */
    private final String [] palos = {"OROS", "BASTOS", "ESPADAS", "COPAS"};
    private String palo;
    
    public CartaEspanyola() {
        super();
    }

    /**
     * Constructor copia
     * @param ce1 Obtenemos el palo de la carta española
     * @param c1 Obtenemos numero de carta
     */
    public CartaEspanyola(CartaEspanyola ce1, Carta c1) {
        this.setNumCarta(c1.getNumCarta());
        this.setPalo(ce1.getPalo());
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    
    /**
     * TODO aqui no tiene sentido el contructor copia
     * @param c1
     * @param ce1 
     */
    public CartaEspanyola(Carta c1, CartaEspanyola ce1) {
        super(c1);
    }   
    
    /**
     * Método para mostrar la carta
     * @param carta recibe una carta
     * @return devuelve el valor de la carta
     */
    @Override
    public String mostrarCarta(Carta carta) {
        return this.getNumCarta() + " de " + this.getPalo();
    }
    
}
