/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogicaDeNegocios;
// Esta es la forma de programar un dependencia (temporal)
// Aca explica todas las relaciones, leer bien para entender
//https://vaughnvernon.co/?page_id=31
//http://www.vogella.com/tutorials/DependencyInjection/article.html
import CapaLogicaDeNegocios.Diccionario;
import CapaPresentacion.PantallaConsola;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleListProperty;


/**
 *
 * @author Jose
 */
public class GestorDiccionarios {
    
    //ESTO ESTA MAL PORQUE ES UNA ASOCIACION, ALGO ESTATICO.
    // NO SE ME OCURRE OTRA FORMA DE TENER LOS DICCIONARIOS EN MEMORIA
    private Diccionario diccionarioEnMemoria;
    
    
    public GestorDiccionarios() {
    }
    
    //
    
    public Diccionario nuevoDiccionario(){
        PantallaConsola pantalla = new PantallaConsola();
        //un diccionario es palabras por frecunais
        String nombreDiccionario = pantalla.pedirNombreDiccionario();
        //Tengo la ruta del txt a leer
        Archivo archivosDeTexto =  pantalla.pedirArchivosDeTexto();
        //En este punto tengo todas las palabras filtradas pero sin contar.
        Palabra[] palabras = archivosDeTexto.leerTodasLasPalabras();
        
        HashMap <Palabra,  List <Frecuencia>> tablaDeFrecuencias = new HashMap <Palabra, List <Frecuencia>>(100000);
        //recorro todas las palabras y las agrego a la tabla.
        for (int i = 0; i < palabras.length; i++) {
            // una palabra va a tener una nombre y un archivo
            Palabra palabraAagregar = palabras[i];
            // la funcion constains busca por valor y utiliza el hashCode que solo depende del nombre
            // etocnes 2 palabras distintas pero con el mismmo nombre van a estar en el mismo luagr
            if (tablaDeFrecuencias.containsKey(palabraAagregar)){
                    // una vez que se que la palabra (clave) esta en la tabla voy a buscar si es igual, es decir en el mismo archivo
                    List <Frecuencia> listaEncontrada = tablaDeFrecuencias.get(palabraAagregar);
                    //pregunto si esta en la lista

                        //en caso de estar voy a sumarle uno al contador
                        boolean estaEnLaLista = false;
                        for (Frecuencia frecuenciaEncontrada : listaEncontrada) {
                            
                            if (frecuenciaEncontrada.equals(palabraAagregar)) {
                                frecuenciaEncontrada.sumar();
                                estaEnLaLista = true;
                                break;
                                }
                        }
                        //si no esta en la lista esa palabra la voya a gregar
                        if (!estaEnLaLista) {
                            listaEncontrada.add(new Frecuencia(palabraAagregar));}
                        
                        
                    
                    
                }
            else{
                    //creo una lista de frecuencia, con lo mucho se leera de 5 archivos
                    List<Frecuencia> listaDeFrecuencias = new ArrayList<Frecuencia>(3);
                    // agrego la frecunai a la lista
                    listaDeFrecuencias.add(new Frecuencia(palabraAagregar));
                    //agrego la lista a la tablaHASh
                    tablaDeFrecuencias.put(palabraAagregar, listaDeFrecuencias);              
                }
            }
        Diccionario diccionario = new Diccionario(nombreDiccionario, tablaDeFrecuencias);
        // una vez que lo creo lo asigno o se lo devuelvo a la pantalla?
        return diccionario;
        
    }
    
    public void buscarPalabra()
    {
        PantallaConsola pantalla = new PantallaConsola();
        //COMO HAGO PARA BUSCAR EL DICCIONARIO EN MEMORIA?
        Diccionario diccionarioSelecionado = pantalla.pedirSeleccionDiccionario(diccionarioEnMemoria);
        pantalla.mostrarDiccionario(diccionarioSelecionado);
        String palabraABuscar = pantalla.pedirPalabraABuscar();
        //lo hacemos de esta forma para que a la hora de mostrarlo sea igual.
        Diccionario diccionarioBuscado = diccionarioSelecionado.buscarPalabra(palabraABuscar);
        //la forma de mostrar un diccionario es la misma
        pantalla.mostrarDiccionario(diccionarioBuscado);
    }
    
    public String mostrarDicionario(Diccionario dic)
    {
        return dic.toString();
                
    }
    
    
    public boolean GuardarDicionario(Diccionario diccionario){
        return true;
    }
}
