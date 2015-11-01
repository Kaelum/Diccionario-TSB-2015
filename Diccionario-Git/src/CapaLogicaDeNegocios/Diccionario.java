/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogicaDeNegocios;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Diccionario {
    private String nombre;
    private Timestamp fecha;
    private HashMap <Palabra,  List <Frecuencia>> tablaDeFrecuencias;

    public Diccionario(String nombre, HashMap<Palabra, List<Frecuencia>> tablaDeFrecuencias) {
        this.nombre = nombre;
        this.fecha = new Timestamp(System.currentTimeMillis());
        this.tablaDeFrecuencias = tablaDeFrecuencias;
    }

    

    public Diccionario() {
    }

    public String getNombre() {
        return nombre;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public HashMap<Palabra, List<Frecuencia>> getTablaDeFrecuencias() {
        return tablaDeFrecuencias;
    }
    
    
    public Diccionario buscarPalabra(String patron){
        
       return null;
    }

    @Override
    public String toString() {
        String resultado= "Diccionario{" + "nombre=" + nombre + ", fecha=" + fecha;
        // Imprimimos el Map con un Iterador
        Iterator it = tablaDeFrecuencias.keySet().iterator();
        while(it.hasNext()){
          Palabra nombreClave = (Palabra) it.next();
          resultado+="\n Clave: " + nombreClave.getNombre() + " -> Valor: " + tablaDeFrecuencias.get(nombreClave);
        }
        return resultado;
    }
    
    
    
    
   
}
