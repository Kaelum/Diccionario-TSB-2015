/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soporte;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jose
 */
public class Cronometro {
    private long tiempoInicio;
    private long tiempoFin;

    public Cronometro() {
        
    }
    
    public void iniciar(){
        tiempoInicio = System.currentTimeMillis();
    }
    
    public void parar(){
        tiempoFin = System.currentTimeMillis();
    }
    
    public String tiempo(){
        long total = tiempoFin - tiempoInicio;
        int seconds = (int) (total/ 1000) % 60 ;
        int minutes = (int) ((total/ (1000*60)) % 60);
        return "--- Min: " + minutes+ "Seg: "+seconds+" Milesimas: "+total;
        
    }
    
    
   
}
