/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogicaDeNegocios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jose
 */
public class Archivo  extends File {
    // el origen es el path que ya se hereda de File
    //private String origen;
    //hacemos herencia porque file es una clase y aparte tenemos que agregar metodos propiios de nuestro dominio
    

    public Archivo(String string) {
        super(string);
    }
    
    public Palabra[] leerTodasLasPalabras22(){
        //es menos eficiente y lindo este codigo pero el otro no funciona
        return  null;
    }
    public Palabra[] leerTodasLasPalabras(){
        //leo todo el libro en un string
        String libroCompleto = null;
        try {
            libroCompleto = new String(Files.readAllBytes(Paths.get(getPath())));
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("Sin filtro: \n" + libroCompleto);
        //para no complicarnos primero elimino las cosas que no van y luego las palabra alfanumericas
        //todo las palabras que tiene un numero
        // 2 horas reloj para encontrar la puta expresion regular y no anda.
        String filtro = "\\b[^A-Za-z]*\\b";
        filtro = "[^\\\\p{L}\\\\p{Nd}]+";
        filtro = "[^[\\s|\\t|\\n|\\r|] A-Za-z$]*";
        filtro = "[^ A-Za-z$ ]*";
        filtro = "[^A-Za-z$]*";
        String libroFiltrado;
        //anda maso menos
        libroFiltrado = libroCompleto.replaceAll("\\b[^A-Za-z]*\\b", " ");
        // como me quedan mucho espacion en balnco los camvbio por uno solo para poder despues hacer el split
        //libroFiltrado = libroCompleto.replaceAll("[ ]*", " ");
        libroFiltrado = libroFiltrado.toLowerCase();
        System.out.println("---------- LIBRO ILTRADO");
        //System.out.println(libroFiltrado);
        //CON LO MISMO QUE REEMPLAZO
        String [] cadenas = libroFiltrado.split(" ");
        
        Palabra [] palabras = new Palabra[cadenas.length];
        System.out.println("----------TODAS LAS PALABRAS");
        for (int i = 0; i < cadenas.length ; i++) {
            palabras[i] = new Palabra(cadenas[i],getName());
            //ystem.out.println(palabras[i]);
            
        }
        return palabras;
    } 
    
    private String leerTextoCompleto (){
        //el archivo ya sabe su ubicacion por si mismo
        byte [] encode = null;
        try {
            encode = Files.readAllBytes(Paths.get(getPath()));
        } catch (IOException ex) {
            
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String(encode,Charset.defaultCharset());
        }
    
 
    
 
    
}
