/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Incremental;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author victoriapenas
 */
public class AtomicInteger_Demo {
    /*Lo creamos static para que el programa recuerde el valor de la ultima
    instancia y final para que no se pueda modificar el valor, será una constante
    para cada instancia, por lo que se debe declarar en mayúsculas.
    En el ejemplo, su valor inicial es 100*/
    private static final AtomicInteger INCREMENTAL = new AtomicInteger(99);
    private String nombre;
    private int id;
    
    //constructores
    public AtomicInteger_Demo() {
        this.setId(getINCREMENTAL().incrementAndGet());
    }

    public AtomicInteger_Demo(String nombre) {
        this.nombre = nombre;
        this.setId(getINCREMENTAL().incrementAndGet());
    }

    public AtomicInteger_Demo(AtomicInteger_Demo nuevo) {
        this.setNombre(nuevo.getNombre());
        this.setId(nuevo.getId());
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static AtomicInteger getINCREMENTAL() {
        return INCREMENTAL;
    }

}
