/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaabstraccion;

/**
 *
 * @author victoriapenas
 */
public abstract class vehiculo {
    private String matricula;
    private int licencia;

    public vehiculo(String matricula, int licencia) {
        this.matricula = matricula;
        this.licencia = licencia;
    }

    public vehiculo() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }
    
    public abstract void mostrarAbstraccion (int i);
}
