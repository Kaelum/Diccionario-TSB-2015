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
    
    public void nuevoDiccionario(){
        
        String nombreDiccionario =  PantallaConsola.pedirNombreDiccionario();
        Archivo archivosDeTexto =  PantallaConsola.pedirArchivosDeTexto();
        Palabra[] palabras = archivosDeTexto.leerTodasLasPalabras();
        
        Frecuencia[]frecuencia = new Frecuencia[1];
        
        Diccionario diccionario = new Diccionario(nombreDiccionario, frecuencia);
        // una vez que lo creo lo asigno o se lo devuelvo a la pantalla?
        diccionarioEnMemoria = diccionario;
        
    }
    
    public void buscarPalabra()
    {
        //COMO HAGO PARA BUSCAR EL DICCIONARIO EN MEMORIA?
        Diccionario diccionarioSelecionado = PantallaConsola.pedirSeleccionDiccionario(diccionarioEnMemoria);
        PantallaConsola.mostrarDiccionario(diccionarioSelecionado);
        String palabraABuscar = PantallaConsola.pedirPalabraABuscar();
        //lo hacemos de esta forma para que a la hora de mostrarlo sea igual.
        Diccionario diccionarioBuscado = diccionarioSelecionado.buscarPalabra(palabraABuscar);
        //la forma de mostrar un diccionario es la misma
        PantallaConsola.mostrarDiccionario(diccionarioBuscado);
    }
    
    
}
