/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacrojava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author victoriapenas
 */
public class CajeroAutomatico {
    /*los atributos staticos pertenecen a la clase no a la intancia, y sin
    tener instanciado nada ya existe y se pueden almacenar cosas.
    Un atributo de instancia solo pueden usarse si hay una instancia, los static
    ya existen por si mismos.*/
    private static int idCajeroUltimo;
    private int idCajero;
    private int [][] listaBilletes;
    private ArrayList <Tarjeta> listaTarjetas = new ArrayList();

    public CajeroAutomatico() {
        this.setIdCajero(idCajeroUltimo++);
    }

    public CajeroAutomatico(int idCajero, int[][] listaBilletes, ArrayList<Tarjeta> listaTarjetas) {
        this.setIdCajero(idCajero);
        this.setIdCajeroUltimo(idCajeroUltimo++);
        this.setListaTarjetas(listaTarjetas);
    }

    public int getIdCajeroUltimo() {
        return idCajeroUltimo;
    }

    public void setIdCajeroUltimo(int idCajeroUltimo) {
        this.idCajeroUltimo = idCajeroUltimo;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public int[][] getListaBilletes() {
        return listaBilletes;
    }

    public void setListaBilletes(int[][] listaBilletes) {
        this.listaBilletes = listaBilletes;
    }

    public ArrayList getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(ArrayList listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }
    
    public void addTarjeta(Tarjeta tarjeta){
        listaTarjetas.add(tarjeta);
    }
    
    public void mostrarCajero(){
        for (int i=0;i<listaBilletes.length;i++){
            int j = 0;
            System.out.print(listaBilletes[i][j+1] + " billetes de ");
            System.out.println(listaBilletes[i][j] + "€");
        }
    }
    
    public void sacarDinero() throws ExcepcionCajero{
        Scanner lector = new Scanner(System.in);
        String nif;
        int pin;
        int importe;
        int i = 0; //aux para while
        boolean exit = false;
        System.out.println("Dime tu NIF");
        nif = lector.nextLine();
        System.out.println("Dime el PIN");
        pin = lector.nextInt();
        
        while (exit == false && i<listaTarjetas.size()){
            if(listaTarjetas.get(i).getNIF().equals(nif) && listaTarjetas.get(i).getPIN() == pin){
                System.out.println("Dime el importe a extraer:");
                importe = lector.nextInt();
                if(this.comprobarBilletes(importe) && listaTarjetas.get(i).disminuirSaldoDisponible(importe)){
                    exit = true;
                }
                else if(this.comprobarBilletes(importe) == false ||
                        listaTarjetas.get(i).disminuirSaldoDisponible(importe) == false){
                    exit = true;
                }
            }
            else if (i == listaTarjetas.size()-1){
                System.out.println("Los datos introducidos no son incorrectos");
                exit = true;
            }
            else{
                i++;
            }
        }
    }
    
    public boolean comprobarBilletes(int importe) throws ExcepcionCajero{
        boolean hayBilletes = false;
        int i = 0; //aux para while
        int j = 1; //aux para while
        int billete500 = 0; //auxiliares para ir sumando
        int billete50 = 0;
        int billete10 = 0;
        int billete5 = 0;
        int sumatorio = 0;
        boolean exit = false;
        while (exit == false && i<listaBilletes.length){
            //TO DO falta resto de billetes, mirar de crear un metodo para todos los sumatorios. no tengo tiempo
            if(this.getListaBilletes()[i][j] != 0 && sumatorio < importe
                    && this.getListaBilletes()[i][0]==500){
                while(sumatorio+500<=importe){
                       billete500+=1;
                       sumatorio+=500;
                }
                
                if (sumatorio+500>importe){
                    i++;
                }
                
                if(sumatorio == importe){
                    exit = true;
                }
            }
            else if(this.getListaBilletes()[i][j] != 0 && sumatorio < importe
                    && this.getListaBilletes()[i][0]==50){
                while(sumatorio+50<=importe){
                    billete50+=1;
                    sumatorio+=50;
                }   
                if (sumatorio+50>importe){
                        i++;
                    }
               
                if(sumatorio == importe){
                    exit = true;
                }
            }
            else if(this.getListaBilletes()[i][j] != 0 && sumatorio < importe
                    && this.getListaBilletes()[i][0]==10){
                while(sumatorio+10<=importe){
                    billete10+=1;
                    sumatorio+=10;
                }
                if(sumatorio+10>importe){
                        i++;
                    }
                
                if(sumatorio == importe){
                    exit = true;
                }
            }
            else if(this.getListaBilletes()[i][j] != 0 && sumatorio < importe
                    && this.getListaBilletes()[i][0]==5){
                while(sumatorio+5<=importe){
                   billete5+=1;
                   sumatorio+=5;
                }
                if(sumatorio+5>importe){
                    i++;
                }
                
                if(sumatorio == importe){
                    exit = true;
                }
            }
            else{
                i++;
            }
        }   
        if (sumatorio == importe && importe > 0){
            hayBilletes = true;
            exit = true;
            System.out.println("Hay dinero en el cajero");
            //actualizo el dinero del cajero DEBERÍA SER OTRA FUNCION e ir actualizando la diponibilidad del cajero al momento
            for(int k=0; k<this.getListaBilletes().length; k++){
                if(this.getListaBilletes()[k][0] == 500 && billete500 !=0){
                    System.out.println(billete500 + "billetes de 500");
                    this.getListaBilletes()[k][1] = this.getListaBilletes()[k][1] - billete500;
                }
                else if(this.getListaBilletes()[k][0] == 50 && billete50 !=0){
                    System.out.println(billete50 + "billetes de 50");
                    this.getListaBilletes()[k][1] = this.getListaBilletes()[k][1] - billete50;
                }else if(this.getListaBilletes()[k][0] == 10 && billete10 !=0){
                    System.out.println(billete10 + "billetes de 10");
                    this.getListaBilletes()[k][1] = this.getListaBilletes()[k][1] - billete10;
                }else if(this.getListaBilletes()[k][0] == 5 && billete5 !=0){
                    System.out.println(billete5 + "billetes de 5");
                    this.getListaBilletes()[k][1] = this.getListaBilletes()[k][1] - billete5;
                }
            }
        } else if (sumatorio != importe && i==this.getListaBilletes().length) {
            
            throw new ExcepcionCajero(importe);
            
            }
        else if (importe<0){
            System.out.println("Por favor, indica un importe válido");
        }
        
        return hayBilletes;
    }

}
