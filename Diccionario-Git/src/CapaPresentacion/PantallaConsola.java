/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;
import CapaLogicaDeNegocios.Archivo;
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
    
    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Seleecione Un CU  \n"
                + " 1: Generar Diccionario \n"
                + " 2: Buscar Palabras \n"
                + " 0: SALIR \n");
           
            opcion =  sc.nextInt();
            
            switch (opcion){
                case 1: 
                        break;
                case 2: System.out.println("Llamo al caso de uso 2");
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
        System.out.println("Ingrese el nombre del diccionario");
        // el read seria como tomar nombre diccionario desde el actor
        return nombreDiccionario = sc.nextLine();
    }
    
    public static File pedirArchivosDeTexto()
    {
        System.out.println("Ingrese el nombre del archivo");
        // el read seria como tomar nombre diccionario desde el actor
        return archivoDeTexto = new Archivo(sc.nextLine());
                
    }
            
    
}
