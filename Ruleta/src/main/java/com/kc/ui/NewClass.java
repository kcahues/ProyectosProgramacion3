/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kc.ui;

import com.kc.bo.JugadorBO;
import com.kc.entity.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class NewClass {
    
    public static void main (String[] args){
        JugadorBO jugadorBO = new JugadorBO();
        ArrayList lista = new ArrayList<>();
        
        
//        jugador.setIdJugador(1);
//        jugador.setNombre("Kevin");
//        jugador.setSaldo(100);
//        jugador.setBorrado(false);
//        
//        lista.add(jugador);
//        
//        Jugador jugador2 = new Jugador();
//        jugador2.setIdJugador(2);
//        jugador2.setNombre("Matias");
//        jugador2.setSaldo(900);
//        jugador2.setBorrado(true);
//        
//        lista.add(jugador2);
//        jugadorBO.crearArchivo(lista);
//        
//        ArrayList<Jugador> lista2 = new ArrayList<>();
//        lista2 = jugadorBO.leerArchivo();
//        
//        jugadorBO.menu();
//        for (Jugador cancion : lista2) {
//                System.out.print(cancion.getIdJugador());
//                System.out.print(" ");
//                System.out.print(cancion.getNombre());
//                System.out.print(" ");
//                System.out.print(cancion.getSaldo());
//                System.out.print(" ");
//                System.out.println(cancion.isBorrado());
//        }
//        // Define variables
        Scanner objInput = new Scanner(System.in);
        String strContinuar = null;
        
        do {
            Jugador jugador = new Jugador();
            jugadorBO.menu();
            //Recibe el valor del buffer del teclado
            String strOpcion = objInput.nextLine();
            
            //Define variable de error
            boolean blnError = true;
            switch(strOpcion){
                case "1":
                     System.out.println("Ingrese su codigo ");
                     jugadorBO.menuInicio(objInput.nextLine(), jugador, blnError);
                     jugadorBO.iniciaJuego(jugador);
                    break;
                case "2":
                     jugadorBO.menuCreacion(jugador);
                     System.out.println("");
                    break;
                
                default:
                    System.out.println("Hubo un error en seleccionar las opciones");
                    break;
            }
            System.out.println("");
            
            System.out.println("Desea continuar? 1. Si / 2. No");
            // Capturar el buffer para continuar
            Scanner objInput2 = new Scanner(System.in);
            strContinuar = objInput2.nextLine();
            
            
        } while (strContinuar.equals("1"));
    
    }
    
}