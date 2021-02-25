
package com.kc.ui;

import com.kc.bo.JugadorBO;
import com.kc.entity.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Main {
    
    public static void main (String[] args){
        //Instancia para ejecutar metodos y funciones
        JugadorBO jugadorBO = new JugadorBO();
        ArrayList lista = new ArrayList<>();
        
        // Define variables
        Scanner objInput = new Scanner(System.in);
        String strContinuar = null;
        
        do {
            Jugador jugador = new Jugador();
            //Se llama el menu principal
            jugadorBO.menu();
            //Recibe el valor del buffer del teclado
            String strOpcion = objInput.nextLine();
            
            //Define variable de error
            boolean blnError = false;
            switch(strOpcion){
                case "1":
                     System.out.println("Ingrese su codigo ");
                     
                     //Verifica que el usuario exista para poder jugar
                     if (!jugadorBO.menuInicio(objInput.nextLine(), jugador, blnError)) {
                         //Si el jugador existe inicia la logica del juego
                         jugadorBO.iniciaJuego(jugador);
                    }
                     
                    break;
                case "2":
                    //Manda a llamar la creación 
                     jugadorBO.menuCreacion(jugador);
                     System.out.println("");
                    break;
                default:
                    System.out.println("Hubo un error en seleccionar las opciones");
                    break;
            }
            System.out.println("");
            //Muestra el titulo
            jugadorBO.titulo();
            System.out.println("Desea continuar en el menu principal? 1. Si / 2. No");
            // Capturar el buffer para continuar
            Scanner objInput2 = new Scanner(System.in);
            strContinuar = objInput2.nextLine();
            
            
        } while (strContinuar.equals("1"));
    
    }
    
}
