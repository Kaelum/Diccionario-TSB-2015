/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogicaDeNegocios;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Diccionario {
    private String nombre;
    private Timestamp fecha;
    private HashMap <String,  List <Frecuencia>> tablaDeFrecuencias;

    public Diccionario(String nombre, HashMap<String, List<Frecuencia>> tablaDeFrecuencias) {
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

    public HashMap<String, List<Frecuencia>> getTablaDeFrecuencias() {
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
          String nombreClave =  (String) it.next();
          resultado+="\n Clave: " + nombreClave + " -> Valor: " + tablaDeFrecuencias.get(nombreClave);
        }
        return resultado;
    }
    
    @SuppressWarnings("empty-statement")
    public Object getDatos(){
        //array bidimencional de objetos con los datos de la tabla
        String[] columnas = {"Palabra", "Frecuencia", "Archivos"};
        DefaultTableModel Modelo_Tabla = new DefaultTableModel(null,columnas);
        
        Object[][] data;
        data = new Object[3][tablaDeFrecuencias.size()];
        int index = 0;
         //obtengo el iterador de la hash map
        Iterator it = tablaDeFrecuencias.keySet().iterator();
        while(it.hasNext()){
           //itero todas las claves
          String nombreClave =  (String) it.next();
          String nombre = nombreClave;
          int contadorTotal = 0;
          int cantidadArchivos = 0;
          List <Frecuencia> listaEncontrada = tablaDeFrecuencias.get(nombreClave);
            for (Frecuencia frecuenciaEncontrada : listaEncontrada) {
                contadorTotal+= frecuenciaEncontrada.getContador();
                cantidadArchivos++;}
          Object[] fila = {nombre,contadorTotal,cantidadArchivos};
          Modelo_Tabla.addRow(fila);
          //data [index] = fila;
          index++;
          
        }
        
        
                        
                        
        return Modelo_Tabla;
    
    }
    
    
    public String guardarBDDiccionaro(){
        String consulta="";
        consulta="INSERT INTO PALABRA VALUES (default,'"+nombre+"')";
        return  consulta;
    }
    
    public String guardarBDFrecuencias(){
        
        String megaConsulta = "";
        // Imprimimos el Map con un Iterador
        Iterator it = tablaDeFrecuencias.keySet().iterator();
        while(it.hasNext()){
            int contador = 0;
            String archivoEncontrado =""; 
            Palabra nombreClave = (Palabra) it.next();
            List <Frecuencia> listaEncontrada = tablaDeFrecuencias.get(nombreClave);
            for (Frecuencia frecuenciaEncontrada : listaEncontrada) {
                            
                            if (frecuenciaEncontrada.equals(nombreClave)) {
                                contador = frecuenciaEncontrada.getContador();
                                archivoEncontrado = frecuenciaEncontrada.getPalabra().getArchivo();
                                break;
                                }
                        }
            
            megaConsulta += "INSERT INTO SUPERTABLA VALUES ('"+nombreClave.getNombre()+"','"+archivoEncontrado+"',"+contador+")";
                  
        }
        
        
        return  megaConsulta;
    }
}
