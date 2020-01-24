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
public class Persona {
    
    //1º declaración de atributos
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private Nif infNif;
    
    //atajo para crear constructor: ctrl+i
    
    //constructor con todos los parámetros.
    public Persona(String nombre, String apellido1, String apellido2, int edad, Nif infNif) {
        this.setNombre(nombre);//utilizamos el setter para convertir a mayúsculas
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.infNif = infNif;
    }
    //constructor vacío
    public Persona() {
    }
    
    //contructor copia. Copiamos el constructor completo y le indicamos por
    //parametro lo que va a recibir, una persona.
    public Persona(Persona p1) {
        this.nombre = p1.nombre;
        this.apellido1 = p1.apellido1;
        this.apellido2 = p1.apellido2;
        this.edad = p1.edad;
        this.infNif = p1.infNif;
    }
    
    /*ctrl+i create getter i setters. Creamos métodos para manipular
    los atributos de esta clase desde otra clase*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();//para que todos los nombres que reciba los convierta a mayúsculas.
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Nif getInfNif() {
        return infNif;
    }

    public void setNif(Nif infNif) {
        this.infNif = infNif;
    }
//despues de los getters i setters empiezan los métodos
    
    public void solicitarDatos(){
        Scanner lector=new Scanner(System.in);
        System.out.println("dime el nombre");
        this.setNombre(lector.nextLine());
        System.out.println("dime el apellido 1");
        this.setApellido1(lector.nextLine());
        System.out.println("dime el apellido 2");
        this.setApellido2(lector.nextLine());
        //pediré a continuación los datos del DNI
        this.setNif(new Nif());//tengo que instanciar el objeto llamando al constructor vacío de la clase Nif
        infNif.solicitarDatosNif();
        System.out.println("dime la edad");
        this.setEdad(Integer.parseInt(lector.nextLine()));
        /*cuando en un mismo método pedimos por teclado enteros y strings,
        hay que utilizar el integer.parseInt() para que funcione correctamente.
        Cuando pedimos un integer y le damos a intro, el sistema espera que el
        retorno de carro lo recoja un lector y por tanto, el siguiente lector
        que viene lo recoge y ya no pide el ultimo valor*/
        lector.close(); //cierro el recurso de scanner
        /*cuando */
    }
    
    public void mostrarAtributos(){
        System.out.println("el nombre es "+this.getNombre());
        System.out.println("el apellido 1 es "+this.getApellido1());
        System.out.println("el apellido 2 es "+this.getApellido2());
        infNif.mostrarAtributosNif();
        System.out.println("la edad es "+this.getEdad());
    }
}
