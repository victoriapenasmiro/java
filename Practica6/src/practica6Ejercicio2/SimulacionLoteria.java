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
 * 
 */
public class SimulacionLoteria {

    public SimulacionLoteria() {
        super();
    }

    public static void mostrarMenu(ArrayList <Apuesta> apuestasUsuarios, ArrayList <Apuesta> apuestasAleatorias)
            throws ExceptionSimulador{
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
                    for (int i= 0;i<totalApuestas;i++){
                        Primitiva nuevaPrim = new Primitiva();
                        nuevaPrim.crearApuestaPrimitiva(apuestasUsuarios);
                    }
                    break;
                case 2:
                    for (int i= 0;i<totalApuestas;i++){
                        Quiniela nuevaQuiniela = new Quiniela();
                        nuevaQuiniela.crearApuestaQuiniela(apuestasUsuarios);
                    }
                    break;
                case 3:
                    SimulacionLoteria simulacion = new SimulacionLoteria();
                    System.out.println("¿Cuántas primitivas quieres simular");
                    totalApuestas = Primitiva.pedirCantidadPrimitivas();
                    if (totalApuestas>0){
                        tipoApuesta = 'p';
                        simulacion.realizarSimulacion(totalApuestas, tipoApuesta, apuestasAleatorias, apuestasUsuarios);
                    }
                    
                    System.out.println("\n¿Cuántas quinielas quieres simular?");
                    totalApuestas = Quiniela.pedirCantidadQuinielas();
                    if (totalApuestas>0){
                        tipoApuesta = 'q';
                        simulacion.realizarSimulacion(totalApuestas, tipoApuesta, apuestasAleatorias, apuestasUsuarios);
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
    
    public void realizarSimulacion(int totalApuestas, char tipoApuesta,
            ArrayList <Apuesta> apuestasAleatorias, ArrayList <Apuesta> apuestasUsuarios)
            throws ExceptionSimulador{
        boolean acierto = false;//auxiliar para actualizar los aciertos
        int aciertos = 0;  
        
        //genero las primitivas
        if (totalApuestas > 0 && tipoApuesta == 'p'){
            //genero apuestas aleatorias
            for(int i = 0;i<totalApuestas;i++){
                Primitiva primitivaAleatoria = new Primitiva();
                primitivaAleatoria = primitivaAleatoria.generarPrimitivasAleatorias(apuestasAleatorias);
                
                //compruebo si esta apuesta la ha acertado el usuario
                acierto = primitivaAleatoria.comprobarAciertos(apuestasUsuarios, primitivaAleatoria.getListaNum());
                if(acierto){
                    aciertos +=1;
                }
            }
        }
        //genero las quinielas aleatorias
        else if(totalApuestas > 0 && tipoApuesta == 'q'){
            for(int i = 0;i<totalApuestas;i++){
                Quiniela quinielaAleatoria = new Quiniela();
                quinielaAleatoria = quinielaAleatoria.generarQuinielasAleatorias(apuestasAleatorias);               
                //compruebo si esta apuesta la ha acertado el usuario
                acierto = quinielaAleatoria.comprobarAciertos(apuestasUsuarios, quinielaAleatoria.getPartidos());
                if(acierto){
                    aciertos +=1;
                }
            }
        }
        //imprimo los aciertos del usuario
        imprimirAciertos(aciertos, totalApuestas,tipoApuesta);
        //pregunto al usuaio si quieren ver las apuestas aleatorias que se han generado
        visualizarApuestasAleatorias(apuestasAleatorias);
    }    
   
    public static void mostrarApuestas(ArrayList <Apuesta> apuestasAleatorias){
        /*con estas variables imprimire un texto una sola vez por todas las
        primitivas o quinielas que haya*/
        boolean hayPrimitivas = false;
        boolean hayQuinielas = false;
        for(int i = 0;i<apuestasAleatorias.size();i++){
            if (apuestasAleatorias.get(i) instanceof Primitiva){
                if (hayPrimitivas == false){
                    System.out.println("Las Primitivas que se han generado son: ");
                    hayPrimitivas = true;
                }
                for(int j = 0;j<((Primitiva)apuestasAleatorias.get(i)).getListaNum().length;j++){
                    if (j == ((Primitiva)apuestasAleatorias.get(i)).getListaNum().length-1){
                        System.out.println (((Primitiva)apuestasAleatorias.get(i)).getListaNum()[j] + " ");
                    }
                    else{
                        System.out.print(((Primitiva)apuestasAleatorias.get(i)).getListaNum()[j] + " ");
                    }
                }
            }
            
            else if(apuestasAleatorias.get(i) instanceof Quiniela){
                if (hayQuinielas == false){
                    System.out.println("Las Quinielas que se han generado son: ");
                    hayQuinielas = true;
                }
                for(int j = 0;j<((Quiniela)apuestasAleatorias.get(i)).getPartidos().length;j++){
                    if(j == ((Quiniela)apuestasAleatorias.get(i)).getPartidos().length-1){
                        if(((Quiniela)apuestasAleatorias.get(i)).getPartidos()[j] == 0){
                            System.out.println("x ");
                        }
                        else{
                            System.out.println(((Quiniela)apuestasAleatorias.get(i)).getPartidos()[j] + " ");
                        }
                    }
                    else{
                        if(((Quiniela)apuestasAleatorias.get(i)).getPartidos()[j] == 0){
                            System.out.print("x ");
                        }
                        else{
                            System.out.print(((Quiniela)apuestasAleatorias.get(i)).getPartidos()[j] + " ");
                        }
                    }
                }
            }
        }
    }
    
    public void imprimirAciertos(int aciertos, int totalApuestas, char tipo){
        System.out.print("Has acertado " + aciertos);
        if(tipo == 'p'){
            System.out.print("Primitivas ");
        }
        else if(tipo == 'q'){
            System.out.println("Quinielas");
        }
        System.out.println("de un total de: " + totalApuestas + " sorteos generados.");
    }
    
    public void visualizarApuestasAleatorias(ArrayList <Apuesta> apuestasAleatorias){
        Scanner lector = new Scanner (System.in);
        char verSorteos = 'N';// la inicializo en NO   
        try{
            System.out.println("¿Quieres visualizar los sorteos aleatorios que se han generado? Y/N ");
            verSorteos = lector.next().charAt(0);
            if(verSorteos == 'Y' || verSorteos == 'y'){
                mostrarApuestas(apuestasAleatorias); //Por último imprimo todas las apuestas aleatorias que se han generado
            }
            else if (verSorteos != 'N' && verSorteos != 'n'){
                throw new ExceptionSimulador(300);
            }
        }catch (ExceptionSimulador e){
            while(verSorteos != 'Y' && verSorteos != 'y' && verSorteos != 'N' && verSorteos != 'n'){
                System.out.println(e.getMensaje());
                verSorteos = lector.next().charAt(0);
                if(verSorteos == 'Y' || verSorteos == 'y'){
                    mostrarApuestas(apuestasAleatorias); //Por último imprimo todas las apuestas aleatorias que se han generado
                }
            }
        }
    }
}
