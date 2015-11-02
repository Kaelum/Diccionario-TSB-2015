/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;
import CapaLogicaDeNegocios.Archivo;
import CapaLogicaDeNegocios.Diccionario;
import CapaLogicaDeNegocios.GestorDiccionarios;
import java.util.Scanner;
import javax.tools.Diagnostic;
/**
 *
 * @author Jose
 */
public class PantallaConsola {
    //que sea estatico significa que es de la clase y no del objeto en si mismo
    private  Scanner sc;
    private  String nombreDiccionario;
    private  Archivo archivoDeTexto;
    private  String palabraABuscar;

    public PantallaConsola() {
        sc = new Scanner(System.in);
    }
    
    public void mostrarPantalla() {
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
    
    private void opcionGenerarDiccionario(){
        System.out.println("Llamo al caso de uso 1");
        //habilitar pnatllas
        GestorDiccionarios gestor = new GestorDiccionarios();
        Diccionario dicCreado =  gestor.nuevoDiccionarioConsola();
        System.out.println(gestor.mostrarDicionario(dicCreado));
    
    }
        
    public String pedirNombreDiccionario()
    {
        System.out.println("Ingrese el nombre del diccionario");
        // el read seria como tomar nombre diccionario desde el actor
        nombreDiccionario = sc.next();
        return nombreDiccionario;
    }
    
    public Archivo pedirArchivosDeTexto()
    {
        System.out.println("Ingrese el nombre del archivo");
        // el read seria como tomar nombre diccionario desde el actor
        String ruta = "src\\ArchivosDeTexto\\";
        String nombre = sc.next();
        archivoDeTexto = new Archivo(ruta+nombre);
        return archivoDeTexto;
                
    }
            
    
    public void opcionBuscarPalabra(){
        System.out.println("Llamo al caso de uso 1");
        //habilitar pnatllas
        GestorDiccionarios gestor = new GestorDiccionarios();
        gestor.buscarPalabra();
    }
    
    public Diccionario pedirSeleccionDiccionario(Diccionario vector)
    {
        System.out.println("Seleccione Un Diccionario (1,2,3,4)");
        // el read seria como tomar nombre diccionario desde el actor
        //int indice = sc.nextInt();
        //return vector[indice];
        return vector;
                
    }
    
    public void mostrarDiccionario(Diccionario dicionario){
        //en la pantalla se cargara la grilla
        dicionario.toString();
    }
    
    public void opcionGuardarDicionario(Diccionario diccionario){
        System.out.println("Se esta guardando su diccionario");
        GestorDiccionarios gestor = new GestorDiccionarios();
        gestor.buscarPalabra();
    }
    
    public String pedirPalabraABuscar()
    {
        System.out.println("La palabra a buscar");
        // el read seria como tomar nombre diccionario desde el actor
        palabraABuscar = sc.next();
        return palabraABuscar;
    }
}
