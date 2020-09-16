/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacrojava;

/**
 *
 * @author victoriapenas
 */
public class TarjetaDebito extends Tarjeta {
    private double saldo;

    public TarjetaDebito() {
        super();
    }

    public TarjetaDebito(String NIF, int PIN, String nombre, String apellido,double saldo) {
        super(NIF, PIN, nombre, apellido);
        this.setSaldo(saldo);
    }
    
    public TarjetaDebito(Tarjeta tarjeta,TarjetaDebito tarjetaDebito) {
        super(tarjeta);
        this.setSaldo(tarjetaDebito.getSaldo());
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public String mostrarTarjeta() {
        return super.mostrarTarjeta() + "TarjetaDebito{" + "saldo=" + saldo + '}';
        
    }
    
    @Override
    public boolean disminuirSaldoDisponible(int importe){
        boolean resultado;
        if (this.getSaldo()>= importe){
            this.setSaldo(this.getSaldo() - importe);
            resultado = true;
        }
        else{
            System.out.println("No tienes saldo suficiente para sacar el importe indicado");
            resultado = false;
        }
        
        return resultado;
    }
    
}
