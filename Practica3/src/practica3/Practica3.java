/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author victoriapenas
Escribe una clase Cuenta para representar una cuenta bancaria.
Los datos de la cuenta son: nombre del cliente (String),
número de cuenta (String), tipo de interés (double) y saldo (double).
La clase contendrá los siguientes métodos: 
1. Constructor por defecto. 
2. Constructor con todos los parámetros. 
3. Constructor copia. 
4. Métodos setters/getters para asignar y obtener los datos de la cuenta. 
5. Métodos ingreso y reintegro.  
    a. Un ingreso consiste en aumentar el saldo en la cantidad que se indique.
Esa cantidad no puede ser negativa.  
    b. Un reintegro consiste en disminuir el saldo en una cantidad pero antes se debe
comprobar que hay saldo suficiente. La cantidad no puede ser negativa.  
    c. Los métodos ingreso y reintegro devuelven true si la operación se ha podido
realizar o false en caso contrario. 
6. Método transferencia. Debe permitir pasar dinero de una cuenta a otra siempre
que en la cuenta de origen haya dinero suficiente para poder hacerla.
    a. Ejemplo de uso del método transferencia:
cuentaOrigen.transferencia(cuentaDestino, importe) que indica que queremos 
hacer una transferencia desde cuentaOrigen a cuentaDestino del importe indicado. 
7. Clase main. Desarrolla otra clase que tenga el main, y ponga a prueba todos
los métodos de la clase Cuenta mediante un menú de usuario que se ejecutará
indefinidamente hasta que este quiera salir.

 */
public class Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.ingreso();
        nuevaCuenta.reintegro();
    }
    
}
