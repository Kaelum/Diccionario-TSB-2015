/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import java.util.Scanner;
import CapaPresentacion.*;

/**
 *
 * @author Jose
 */
public class SelectorDePantalla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
            System.out.println("Seleecione la pantalla\n"
                + " 1: CONSOLA \n"
                + " 2: GRAFICA \n");
            opcion =  sc.nextInt();
            
            switch (opcion){
                case 1: PantallaConsola pantallaC = new PantallaConsola();
                        pantallaC.mostrarPantalla();
                        break;
                case 2: PantallaGrafica pantallaG = new PantallaGrafica();
                        pantallaG.setVisible(true);
                        break;
            }
            
            
        
    }
}
