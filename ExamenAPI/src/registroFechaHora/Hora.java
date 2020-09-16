/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registroFechaHora;

import java.util.Calendar;

/**
 *
 * @author victoriapenas
 */
public class Hora {
    public static String registrarHora(){
        Calendar calendario = Calendar.getInstance();
        String hora = calendario.get(Calendar.HOUR_OF_DAY) + ":" +
            calendario.get(Calendar.MINUTE) + ":" + calendario.get(Calendar.SECOND);
        return hora;
    }
}
