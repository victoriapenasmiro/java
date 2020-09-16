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
public class TarjetaCredito extends Tarjeta{
    private double saldoDisponible;
    private double creditoDisponible;

    public TarjetaCredito() {
        super();
    }

    public TarjetaCredito(String NIF, int PIN, String nombre, String apellido, double saldoDisponible, double creditoDisponible) {
        super(NIF, PIN, nombre, apellido);
        this.setSaldoDisponible(saldoDisponible);
        this.setCreditoDisponible(creditoDisponible);
    }
    
    //TO DO --> Comprobar si funciona
    public TarjetaCredito(Tarjeta tarjeta,TarjetaCredito tarjetaCredito) {
        super(tarjeta);
        this.setSaldoDisponible(tarjetaCredito.getSaldoDisponible());
        this.setCreditoDisponible(tarjetaCredito.getCreditoDisponible());
    }
    
    //otra forma de crear contructor copia:
    public TarjetaCredito(TarjetaCredito t1) {
        super((Tarjeta)t1);
        this.setSaldoDisponible(t1.getSaldoDisponible());
        this.setCreditoDisponible(t1.getCreditoDisponible());
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public double getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(double creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }
    
    @Override
    public String mostrarTarjeta() {
        return super.mostrarTarjeta() + "TarjetaCredito{" + "saldoDisponible="
                + saldoDisponible + ", creditoDisponible=" + creditoDisponible + '}';         
    }
    
    @Override
    public boolean disminuirSaldoDisponible(int importe){
        boolean resultado;
        if (this.getSaldoDisponible()>= importe){
            this.setSaldoDisponible(this.getSaldoDisponible() - importe);
            resultado = true;
        }
        else if (this.getCreditoDisponible()>= importe){
            this.setCreditoDisponible(this.getCreditoDisponible() - importe);
            resultado = true;
        }
        else{
            System.out.println("No tienes saldo suficiente para sacar el importe indicado");
            resultado = false;
        }
        
        return resultado;
        
    }
}
