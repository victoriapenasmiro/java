/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6Ejercicio2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author victoriapenas
 * Mejoras: como las quinielas y las primitivas son clases diferentes y
 * son dos instancias por seprada, pido el nombre y apellidos dos veces.
 * Estaría bien unificarlo a una.
 * 
 */
public class SimulacionLoteria {
    ArrayList <int []> apuestasAleatorias = new ArrayList <int []> (); //Array de apuestas aleatorias


    public SimulacionLoteria() {
        super();
    }

    public ArrayList<int[]> getApuestasAleatorias() {
        return apuestasAleatorias;
    }

    public void setApuestasAleatorias(ArrayList<int[]> apuestasAleatorias) {
        this.apuestasAleatorias = apuestasAleatorias;
    }
      
    public static void mostrarMenu() throws ExceptionSimulador{
        Scanner lector = new Scanner(System.in);
        int opcion;
        int totalApuestas = 0;
        char tipoApuesta; // q = quiniela & p = primitiva.
        boolean exit = false;
        do{
            System.out.println("\n============MENU=============");
            System.out.println("1) crear apuesta Primitiva");
            System.out.println("2) crear apuesta Quiniela");
            System.out.println("3) realizar simulación");
            System.out.println("4) salir");
            System.out.println("¿Qué opción deseas?");
            opcion = lector.nextInt();
            if (opcion == 1 || opcion == 2){
                System.out.println("¿Cuántas apuestas quieres realizar?");
                totalApuestas = lector.nextInt();
            }
            switch (opcion){
                case 1:
                    Primitiva nuevaPrim = new Primitiva();
                    for (int i= 0;i<totalApuestas;i++){
                        nuevaPrim.crearApuestaPrimitiva();
                    }
                    break;
                case 2:
                    Quiniela nuevaQuiniela = new Quiniela();
                    nuevaQuiniela.crearApuestaQuiniela();
                    break;
                case 3:
                    SimulacionLoteria simulacion = new SimulacionLoteria();
                    System.out.println("¿Cuántas primitivas quieres simular");
                    totalApuestas = Primitiva.pedirCantidadPrimitivas();
                    if (totalApuestas>0){
                        tipoApuesta = 'p';
                        simulacion.realizarSimulacion(totalApuestas, tipoApuesta);
                    }
                    
                    System.out.println("\n¿Cuántas quinielas quieres simular?");
                    totalApuestas = Quiniela.pedirCantidadQuinielas();
                    if (totalApuestas>0){
                        tipoApuesta = 'q';
                        simulacion.realizarSimulacion(totalApuestas, tipoApuesta);
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("La opción indicada no es correcta.");
            }
        } while (exit == false);
    }
    
    public void realizarSimulacion(int totalApuestas, char tipoApuesta) throws ExceptionSimulador{
        Scanner lector = new Scanner (System.in);
        Random r = new Random();
        int [] valoresQuiniela = {1,2,0};
        boolean acierto = false;
        char verSorteos = 'N';
        int auxApuestas = 0; //auxiliar para calcular las apuestas que jugará el usuario
        int [] primitiva;
        int [] quiniela;
                
        //genero las primitivas
        if (totalApuestas > 0 && tipoApuesta == 'p'){
            //genero apuestas aleatorias
            for(int i = 0;i<totalApuestas;i++){
                Primitiva primitivaAleatoria = new Primitiva();
                for(int j = 0; j<primitivaAleatoria.getListaNum().length;j++){
                    primitivaAleatoria.getListaNum()[j] = r.nextInt(49)+1;//genero enteros entre 1 y 49:
                }
                //this.getPrimitivasAleatorias().add(primitivaAleatoria.getListaNum());
                this.getApuestasAleatorias().add(primitivaAleatoria.getListaNum());
            }
            
            //genero apuestas manuales del usuario
            System.out.println("¿Cuántas primitivas quieres probar?");
            Primitiva primitivaUsuario = new Primitiva();
            auxApuestas = lector.nextInt();
            for (int i = 0;i<auxApuestas;i++){
                primitiva = primitivaUsuario.crearApuestaPrimitiva();
                //acierto = primitivaUsuario.comprobarAciertos(primitivasAleatorias,primitiva);
                acierto = primitivaUsuario.comprobarAciertos(apuestasAleatorias,primitiva);
                if(acierto){
                    primitivaUsuario.setAciertos(+1);
                }
            }
            
            //imprimo estadísticas
            System.out.println("Has acertado " + primitivaUsuario.getAciertos() +
                    " primitivas de un total de:" + totalApuestas + " sorteos");
        }
        
        //genero las quinielas aleatorias
        else if(totalApuestas > 0 && tipoApuesta == 'q'){
            for(int i = 0;i<totalApuestas;i++){
                Quiniela quinielaAleatoria = new Quiniela();
                quinielaAleatoria.setPartidos(new int [15]);//instancio aqui porque no lo he hecho en el atributo
                for(int j = 0; j<quinielaAleatoria.getPartidos().length;j++){
                    quinielaAleatoria.getPartidos()[j] = getRandom(valoresQuiniela);
                }
                this.getApuestasAleatorias().add(quinielaAleatoria.getPartidos());
            }
            
            //genero apuestas manuales del usuario
            System.out.println("¿Cuántas quinielas quieres probar?");
            Quiniela quinielaUsuario = new Quiniela();
            auxApuestas = lector.nextInt();
            for (int i = 0;i<auxApuestas;i++){
                quiniela = quinielaUsuario.crearApuestaQuiniela();
                acierto = quinielaUsuario.comprobarAciertos(apuestasAleatorias, quiniela);
                if(acierto){
                    quinielaUsuario.setAciertos(+1);
                }
            }
            
            //imprimo estadísticas
            System.out.println("Has acertado " + quinielaUsuario.getAciertos() +
                    " primitivas de un total de:" + totalApuestas + " sorteos");
        }        
        
        try{
            System.out.println("¿Quieres visualizar los sorteos aleatorios que se han generado? Y/N ");
            verSorteos = lector.next().charAt(0);
            if(verSorteos == 'Y' || verSorteos == 'y'){
                System.out.println("Las apuestas aleatorias que se han generado son:"); 
                this.mostrarApuestas(tipoApuesta); //Por último imprimo todas las apuestas aleatorias que se han generado
            }
            else if (verSorteos != 'N' && verSorteos != 'n'){
                throw new ExceptionSimulador(300);
            }
        }catch (ExceptionSimulador e){
            while(verSorteos != 'Y' && verSorteos != 'y' && verSorteos != 'N' && verSorteos != 'n'){
                System.out.println(e.getMensaje());
                verSorteos = lector.next().charAt(0);
                if(verSorteos == 'Y' || verSorteos == 'y'){
                    System.out.println("Las apuestas aleatorias que se han generado son:"); 
                    this.mostrarApuestas(tipoApuesta); //Por último imprimo todas las apuestas aleatorias que se han generado
                }
            }
        }
    }    
    
    //Método para obtener una posicion de la array de valores posibles
    public static int getRandom(int[] valoresQuiniela) {
        int rnd = new Random().nextInt(valoresQuiniela.length);
        return valoresQuiniela[rnd];
    }
   
    public void mostrarApuestas(char tipoApuesta){
        for (int i=0;i<this.getApuestasAleatorias().size();i++){
            if (tipoApuesta == 'p'){
                //solo imprimo primitivas
                if(this.getApuestasAleatorias().get(i).length == 6){
                    System.out.print("\nPrimitiva " + (i+1) + ": ");
                    for (int j = 0; j<this.getApuestasAleatorias().get(i).length;j++){
                        System.out.print(this.getApuestasAleatorias().get(i)[j] + " ");
                    }
                }
            }
            else{
                //solo imprimo quinielas
                if(this.getApuestasAleatorias().get(i).length == 15){
                    System.out.print("\nQuiniela " + (i+1) + ": ");
                    for (int j = 0; j<this.getApuestasAleatorias().get(i).length;j++){
                        if (this.getApuestasAleatorias().get(i)[j] == 0){
                            System.out.print("x" + " ");
                        }
                        else{
                            System.out.print(this.getApuestasAleatorias().get(i)[j] + " ");
                        }                        
                    }
                }
            }
        }
    }    
}
