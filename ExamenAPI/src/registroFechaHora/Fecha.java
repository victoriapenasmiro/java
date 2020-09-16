/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registroFechaHora;

import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author victoriapenas
 */
public class Fecha {
    public static String registrarFecha() throws IOException{
        Calendar calendario = Calendar.getInstance();
        String fecha = calendario.get(Calendar.DATE)+"/"+
                (calendario.get(Calendar.MONTH) + 1)+"/"+calendario.get(Calendar.YEAR);
            
        return fecha;
    }
    
}
