/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;
import CapaLogicaDeNegocios.Archivo;
import CapaLogicaDeNegocios.Diccionario;
import CapaLogicaDeNegocios.GestorDiccionarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author Jose
 */
public class PantallaConsola {
    
    private static Scanner sc;
    private static String nombreDiccionario;
    private static Archivo archivoDeTexto;
    private static String palabraABuscar;
    
    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Seleecione Un CU  \n"
                + " 1: Generar Diccionario \n"
                + " 2: Buscar Palabras \n"
                + " 0: SALIR");
           
            opcion =  sc.nextInt();
            
            switch (opcion){
                case 1: opcionGenerarDiccionario();
                        break;
                case 2: opcionBuscarPalabra();
                        break;
            }
            
            
        } while (opcion != 0);
        
    }
    
    // para no hacer grande el break creamos un metodo
    
    public static void opcionGenerarDiccionario(){
        System.out.println("Llamo al caso de uso 1");
        //habilitar pnatllas
        GestorDiccionarios gestor = new GestorDiccionarios();
        
        gestor.nuevoDiccionario();
    
    }
        
    public static String pedirNombreDiccionario()
    {
        System.out.println("Ingrese el nombre del diccionario que estan en ArchivosDeTexto");
        // el read seria como tomar nombre diccionario desde el actor
        nombreDiccionario = sc.next();
        return nombreDiccionario;
    }
    
    public static Archivo pedirArchivosDeTexto()
    {
        System.out.println("Ingrese el nombre del archivo");
        // el read seria como tomar nombre diccionario desde el actor
        String ruta = "src\\ArchivosDeTexto\\";
        String nombre = sc.next();
        archivoDeTexto = new Archivo(ruta+nombre);
        return archivoDeTexto;
                
    }
            
    
    public static void opcionBuscarPalabra(){
        System.out.println("Llamo al caso de uso 1");
        //habilitar pnatllas
        GestorDiccionarios gestor = new GestorDiccionarios();
        gestor.buscarPalabra();
    }
    
    public static Diccionario pedirSeleccionDiccionario(Diccionario vector)
    {
        System.out.println("Seleccione Un Diccionario (1,2,3,4)");
        // el read seria como tomar nombre diccionario desde el actor
        //int indice = sc.nextInt();
        //return vector[indice];
        return vector;
                
    }
    
    public static void mostrarDiccionario(Diccionario dicionario){
        //en la pantalla se cargara la grilla
        dicionario.toString();
    }
    
    public static String pedirPalabraABuscar()
    {
        System.out.println("La palabra a buscar");
        // el read seria como tomar nombre diccionario desde el actor
        palabraABuscar = sc.next();
        return palabraABuscar;
    }
}
