/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogicaDeNegocios;

import java.io.File;

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
    
}
