/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogicaDeNegocios;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Jose
 */
public class Diccionario {
    private String nombre;
    private Timestamp fecha;
    private Frecuencia [] frecuencia;

    public Diccionario(String nombre, Frecuencia[] frecuencia) {
        this.nombre = nombre;
        this.fecha = new Timestamp(System.currentTimeMillis());
        this.frecuencia = frecuencia;
    }

    public Diccionario() {
    }

    public String getNombre() {
        return nombre;
    }

    public Timestamp getFecha() {
        return fecha;
    }
    
    public Diccionario buscarPalabra(String patron){
        
       return null;
    }

    @Override
    public String toString() {
        return "Diccionario{" + "nombre=" + nombre + ", fecha=" + fecha + ", frecuencia=" + frecuencia + '}';
    }
    
    
    
    
   
}
